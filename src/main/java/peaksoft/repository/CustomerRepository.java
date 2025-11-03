package peaksoft.repository;

import peaksoft.entity.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository {
    /*CRUD
    Customer эки жол менен тузулсун. Биринчисинде озу эле тузулот, экинчисинде customer тузулуп жатканда бир уйду ижарага алып тузулот(rent_info).
    Customer уйду ижарага алса болот. Ижарага алып жатканда customer id, house id, agency id жана check in check out жазышы керек.
    Customer-ди очуруп жатканда. Ижарасы жок Customer-лер очсун, эгерде ижарасы бар болсо checkout датасын текшерсин.
                        Учурдагы датадан мурун болсо rent_info customer-менен чогу очуп кетсин. Азыркыдан болсо - очпойт*/
    void saveCustomer(Customer customer);
    Customer getCustomerById(Long idCustomer);
    List<Customer> getAllCustomers();
    void updateCustomer(Long idCustomer, Customer customer);
    void deleteCustomerById(Long idCustomer);

    String rentHouse(Long idCustomer, Long idHouse, Long idAgency, LocalDate checkIn,  LocalDate checkOut);
    void removeCustomerById(Long idCustomer);
}
