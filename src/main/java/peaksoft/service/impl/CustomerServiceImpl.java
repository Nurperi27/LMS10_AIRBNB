package peaksoft.service.impl;

import peaksoft.entity.Customer;
import peaksoft.repository.CustomerRepository;
import peaksoft.repository.implRepository.CustomerRepoImpl;
import peaksoft.service.CustomerService;

import java.time.LocalDate;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepoImpl();
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long idCustomer) {
        return customerRepository.getCustomerById(idCustomer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public void updateCustomer(Long idCustomer, Customer customer) {
        customerRepository.updateCustomer(idCustomer, customer);
    }

    @Override
    public void deleteCustomerById(Long idCustomer) {
        customerRepository.deleteCustomerById(idCustomer);
    }

    @Override
    public String rentHouse(Long idCustomer, Long idHouse, Long idAgency, LocalDate checkIn, LocalDate checkOut) {
        return customerRepository.rentHouse(idCustomer, idHouse, idAgency, checkIn, checkOut);
    }

    @Override
    public void removeCustomerById(Long idCustomer) {
        customerRepository.removeCustomerById(idCustomer);
    }
}
