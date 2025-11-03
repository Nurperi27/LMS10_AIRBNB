package peaksoft.repository.implRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Agency;
import peaksoft.entity.House;
import peaksoft.entity.Owner;
import peaksoft.repository.OwnerRepository;
import java.time.LocalDate;
import java.util.List;

public class OwnerRepoImpl implements OwnerRepository {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public void saveOwner(Owner owner) {
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            int yearOfBirth = owner.getDateOfBirth().getYear();
            int currentYear = LocalDate.now().getYear();
            int age = currentYear - yearOfBirth;
            if(age > 18){
                entityManager.persist(owner);
            }else System.out.println("Меньше 18 лет Owner не создается");
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Owner getOwnerById(Long idOwner) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
           return entityManager.find(Owner.class, idOwner);
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Owner> getAllOwners() {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            return entityManager.createQuery("select s from Owner s", Owner.class).getResultList();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void updateOwner(Long idOwner, Owner owner) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            Owner owner1 = entityManager.find(Owner.class, idOwner);
            owner1.setFirstName(owner.getFirstName());
            owner1.setLastName(owner.getLastName());
            owner1.setEmail(owner.getEmail());
            owner1.setDateOfBirth(owner.getDateOfBirth());
            owner1.setGender(owner.getGender());
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteOwner(Long idOwner) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Owner owner1 = entityManager.find(Owner.class, idOwner);
            entityManager.remove(owner1);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void assignOwnerToAgency(Long idAgency, Long idOwner) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            Owner owner1 = entityManager.find(Owner.class, idOwner);
            Agency agency1 = entityManager.find(Agency.class, idAgency);
            owner1.getAgencies().add(agency1);
            agency1.getOwners().add(owner1);
            entityManager.merge(owner1);
            entityManager.merge(agency1);
            entityManager.getTransaction().commit();
            System.out.println("Owner " + owner1.getFirstName() + " assigned to Agency " + agency1.getAgencyId());
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeOwnerWithHouse(Long idOwner) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            Owner owner1 = entityManager.find(Owner.class, idOwner);
            //Owner-ди очуруп жатканда, house-тары чогу очот. Бирок ижарасы жок болсо очсун
            List<House> houses = entityManager.createQuery("select s from House s where s.owner.ownerId = :id", House.class).setParameter("id", idOwner).getResultList();
            if(houses.isEmpty()){
                entityManager.createQuery("delete from Owner o where o.ownerId = :id").setParameter("id", idOwner).executeUpdate();
            }else {
                //эгерде ижарасы бар болсо checkout датасын текшерсин. Учурдагы датадан мурун болсо rent_info менен чогу очуп кетсин. Бирок customer очпосун.
                entityManager.createQuery("delete from RentInfo r where r.rentInfoId in (select h.rentInfo.rentInfoId from House h where h.owner.ownerId = :idOwner and h.rentInfo.checkOutDate < current_date) ").setParameter("idOwner", idOwner).executeUpdate();
            }

        }
    }

    @Override
    public Owner getOwnerByAgencyId(Long idAgency) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            return entityManager.createQuery("select s from Owner s join s.agencies a where a.agencyId = :idAgency", Owner.class).setParameter("idAgency", idAgency).getSingleResult();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void getAgeAndNameFromAllOwners() {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            List resultList = entityManager.createQuery("select o.firstName, o.lastName, year(o.dateOfBirth) from Owner o").getResultList();
            System.out.println(resultList);
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }
}
