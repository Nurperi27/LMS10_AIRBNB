package peaksoft.service.impl;

import peaksoft.entity.Address;
import peaksoft.entity.Agency;
import peaksoft.repository.AddressRepository;
import peaksoft.repository.implRepository.AddressRepoImpl;
import peaksoft.service.AddressService;

import java.util.List;
import java.util.Map;

public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository = new AddressRepoImpl();

    @Override
    public void saveAddress(Address address) {
        addressRepository.saveAddress(address);
    }

    @Override
    public void deleteAddress(Long idAddress) {
        addressRepository.deleteAddress(idAddress);
    }

    @Override
    public List<Address> getAddressByAgencyId() {
        return addressRepository.getAddressByAgencyId();
    }

    @Override
    public Address getAddressById(Long idAddress) {
        return addressRepository.getAddressById(idAddress);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.getAllAddress();
    }

    @Override
    public void updateAddress(Long idAddress, Address address) {
        addressRepository.updateAddress(idAddress, address);
    }

    @Override
    public Long countAgency(String cityName) {
        return addressRepository.countAgency(cityName);
    }

    @Override
    public Map<String, List<Agency>> groupByRegion() {
        return addressRepository.groupByRegion();
    }
}
