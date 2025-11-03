package peaksoft.service;

import peaksoft.entity.Address;
import peaksoft.entity.Agency;

import java.util.List;
import java.util.Map;

public interface AddressService {
    void saveAddress(Address address);
    void deleteAddress(Long idAddress);
    List<Address> getAddressByAgencyId();
    Address getAddressById(Long idAddress);
    List<Address> getAllAddress();
    void updateAddress(Long idAddress, Address address);
    Long countAgency(String cityName);
    Map<String, List<Agency>> groupByRegion();
}
