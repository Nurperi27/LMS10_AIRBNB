package peaksoft.repository.implRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.RentInfo;
import peaksoft.repository.RentInfoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class RentInfoRepoImpl implements RentInfoRepository {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public void saveRentInfo(RentInfo rentInfo) {
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            em.persist(rentInfo);
            em.getTransaction().commit();
            em.close();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRentInfo(Long idRentInfo) {
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            RentInfo rentInfo = em.find(RentInfo.class, idRentInfo);
            em.remove(rentInfo);
            em.getTransaction().commit();
            em.close();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<RentInfo> findRentInfoByCheckOutBetween(LocalDate x1, LocalDate x2) {
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            return em.createQuery("select r from RentInfo r where r.checkOutDate between :x1 and :x2", RentInfo.class).setParameter("x1", x1).setParameter("x2", x2).getResultList();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return  null;
        }finally {
            entityManagerFactory.close();
        }
    }

    @Override
    public Long countOfHouseRentedByAgencyId(Long idAgency) {
        LocalDate dateNow = LocalDate.now();
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
           return em.createQuery("select count(h) from House h join h.rentInfo r join r.owner o join o.agencies a where a.agencyId = :idAgency and r.checkOutDate <= :dateNow and r.checkOutDate >= :dateNow", Long.class).setParameter("idAgency", idAgency).getSingleResult();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return  null;
        }
    }
}
