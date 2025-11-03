package peaksoft.repository.implRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRepository;

import java.util.List;

public class AgencyRepoImpl implements AgencyRepository {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public void saveAgency(Agency agency) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(agency);
            entityManager.getTransaction().commit();
            //entityManager.close(); //автоматически закрывается с помощью try-with-resource
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Agency getAgencyById(Long idAgency) {
        //Agency agency = new Agency();
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            //entityManager.getTransaction().begin();
            return entityManager.find(Agency.class, idAgency);
            //entityManager.getTransaction().commit();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Agency> getAllAgencies() {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("select a from Agency a", Agency.class).getResultList();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void updateAgency(Long idAgency, Agency agency) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Agency agency1 = entityManager.find(Agency.class, idAgency);
            agency1.setAgencyName(agency.getAgencyName());
            agency1.setPhoneNumber(agency.getPhoneNumber());
            entityManager.getTransaction().commit();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAgency(Long idAgency) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Agency.class, idAgency));
            entityManager.getTransaction().commit();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
