package peaksoft.service;

import peaksoft.entity.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    Customer getCustomerById(Long idCustomer);
    List<Customer> getAllCustomers();
    void updateCustomer(Long idCustomer, Customer customer);
    void deleteCustomerById(Long idCustomer);
    String rentHouse(Long idCustomer, Long idHouse, Long idAgency, LocalDate checkIn, LocalDate checkOut);
    void removeCustomerById(Long idCustomer);
}
