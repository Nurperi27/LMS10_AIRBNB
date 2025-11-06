package peaksoft.repository.implRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.House;
import peaksoft.entity.RentInfo;
import peaksoft.repository.HouseRepository;

import java.time.LocalDate;
import java.util.List;

public class HouseRepoImpl implements HouseRepository {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public void saveHouse(House house) {
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(house);
            em.getTransaction().commit();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public House getHouseById(Long idHouse) {
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
            House house = em.find(House.class, idHouse);
            return house;
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<House> getAllHouse() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            List<House> houses = entityManager.createQuery("select h from House h", House.class).getResultList();
            return houses;
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void updateHouse(Long idHouse, House house) {
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();
            House house1 = em.find(House.class, idHouse);
            house1.setHouseType(house.getHouseType());
            house1.setPrice(house.getPrice());
            house1.setRating(house.getRating());
            house1.setDescription(house.getDescription());
            house1.setRoom(house.getRoom());
            house1.setFurniture(house.getFurniture());
            em.getTransaction().commit();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteHouse(Long idHouse) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            House house = entityManager.find(House.class, idHouse);
            entityManager.remove(house);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeHouseWithAddress(Long idHouse) { //?
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            House house = entityManager.find(House.class, idHouse);
            RentInfo rentInfo = house.getRentInfo();
            if(rentInfo == null){
                entityManager.remove(house); //ижара жок болсо House & Address удаляется (с помощью cascadeType.Remove)
            }else {
                //эгерде ижарасы бар болсо checkout датасын текшерсин
                if(rentInfo.getCheckOutDate().isBefore(LocalDate.now())){
                    entityManager.remove(house); //Учурдагы датадан мурун болсо rent_info менен address чогу очуп кетсин
                }
            }
            entityManager.getTransaction().commit();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<House> getHouseByRegion(String region) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
           return entityManager.createQuery("select h from House h where h.address.region = :region", House.class).setParameter("region", region).getResultList();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<House> getHouseByAgencyId(Long idAgency) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            return entityManager.createQuery("select h from House h join h.rentInfo r join r.owner o join o.agencies a where a.agencyId = :agencyId", House.class).setParameter("agencyId", idAgency).getResultList();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<House> getHouseByOwnerId(Long idOwner) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            return entityManager.createQuery("select h from House h where h.owner.ownerId = :idOwner", House.class).setParameter("idOwner", idOwner).getResultList();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<House> getHouseByCheckInBetween(LocalDate checkIn1, LocalDate checkIn2) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
           return entityManager.createQuery("select distinct h from House h join h.rentInfo r where r.checkInDate between :checkIn1 and :checkIn2", House.class).setParameter("checkIn1", checkIn1).setParameter("checkIn2", checkIn2).getResultList();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
