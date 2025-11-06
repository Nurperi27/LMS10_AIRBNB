package peaksoft.repository.implRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.*;
import peaksoft.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

public class CustomerRepoImpl implements CustomerRepository {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public void saveCustomer(Customer customer) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Customer getCustomerById(Long idCustomer) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Customer customer = entityManager.find(Customer.class, idCustomer);
            return customer;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            List<Customer> customers = entityManager.createQuery("select a from Customer a", Customer.class).getResultList();
            return customers;
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void updateCustomer(Long idCustomer, Customer customer) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Customer customer1 = entityManager.find(Customer.class, idCustomer);
            customer1.setFirstName(customer.getFirstName());
            customer1.setLastName(customer.getLastName());
            customer1.setEmail(customer.getEmail());
            customer1.setDateOfBirth(customer.getDateOfBirth());
            customer1.setGender(customer.getGender());
            customer1.setNationality(customer.getNationality());
            customer1.setFamilyStatus(customer.getFamilyStatus());
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCustomerById(Long idCustomer) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Customer.class, idCustomer));
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String rentHouse(Long idCustomer, Long idHouse, Long idAgency, LocalDate checkIn, LocalDate checkOut) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Customer customer1 = entityManager.find(Customer.class, idCustomer);
            House house1 = entityManager.find(House.class, idHouse);
            Agency agency1 = entityManager.find(Agency.class, idAgency);
            Owner owner1 = house1.getOwner(); //узнать, есть ли владелец дома
            RentInfo rentInfo = new  RentInfo(checkIn, checkOut); //новый объект для сохранения новой аренды
            rentInfo.setCustomer(customer1);
            rentInfo.setOwner(owner1);
            entityManager.persist(rentInfo);
            entityManager.getTransaction().commit();
            return "success rented";
        }catch (HibernateException e){
            return e.getMessage();
        }
    }

    @Override
    public void removeCustomerById(Long idCustomer) { //??????????
       
    }
}
