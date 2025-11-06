package peaksoft.repository.implRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Address;
import peaksoft.entity.Agency;
import peaksoft.repository.AddressRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressRepoImpl implements AddressRepository {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public void saveAddress(Address address) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAddress(Long idAddress) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Address address = entityManager.find(Address.class, idAddress);
            entityManager.remove(address);
            entityManager.getTransaction().commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Address> getAddressByAgencyId() {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            List<Address> addressList = entityManager.createQuery("select a from Address a join a.agency g",  Address.class).getResultList();
            return addressList;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Address getAddressById(Long idAddress) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.find(Address.class, idAddress);
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Address> getAllAddress() {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("select a from Address a",  Address.class).getResultList();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void updateAddress(Long idAddress, Address address) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Address oldAddress = entityManager.find(Address.class, idAddress);
            oldAddress.setCity(address.getCity());
            oldAddress.setRegion(address.getRegion());
            oldAddress.setStreet(address.getStreet());
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Long countAgency(String cityName) { //HQL всегда возвращает count() в Long типа
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
           Long countOfAgency = entityManager.createQuery("select count(a) from Agency a where a.address.city = :cityName", Long.class).setParameter("cityName", cityName).getSingleResult();
           return countOfAgency;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return 0L;
        }
    }

    @Override
    public Map<String, List<Agency>> groupByRegion() {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            List resultList = entityManager.createNativeQuery("select ad.region, ag.agency_name from addresses ad join agencies ag on ad.id_address = ag.address_id_address order by ad.region").getResultList();
            Map<String, List<Agency>> map = new HashMap<>();
            map.put("region", resultList);
            return map;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
