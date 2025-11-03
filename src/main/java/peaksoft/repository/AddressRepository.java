package peaksoft.repository;

import peaksoft.entity.Address;
import peaksoft.entity.Agency;

import java.util.List;
import java.util.Map;

public interface AddressRepository {
    /*RU
    Сonstraint: street unique (service)
    Бир метод ар бир адрести агентсвосу менен чыгарсын.
    Колдонуучу бир шаардын атын жазса ошол шаарда канча агентсво бар экенин эсептеп чыгарсын
    Ар бир регион жана ошол региондун агентсволары баары чыксын Map<String, List<Agency>> groupByRegion.*/
    void saveAddress(Address address);
    void deleteAddress(Long idAddress);
    List<Address> getAddressByAgencyId();
    Address getAddressById(Long idAddress);
    List<Address> getAllAddress();
    void updateAddress(Long idAddress, Address address);
    Long countAgency(String cityName);
    Map<String, List<Agency>> groupByRegion();
}
