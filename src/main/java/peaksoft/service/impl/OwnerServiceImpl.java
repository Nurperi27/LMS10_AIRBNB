package peaksoft.service.impl;

import peaksoft.entity.Owner;
import peaksoft.repository.OwnerRepository;
import peaksoft.repository.implRepository.OwnerRepoImpl;
import peaksoft.service.OwnerService;

import java.util.List;

public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository = new OwnerRepoImpl();

    @Override
    public void saveOwner(Owner owner) {
        ownerRepository.saveOwner(owner);
    }

    @Override
    public Owner getOwnerById(Long idOwner) {
        return ownerRepository.getOwnerById(idOwner);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.getAllOwners();
    }

    @Override
    public void updateOwner(Long idOwner, Owner owner) {
        ownerRepository.updateOwner(idOwner, owner);
    }

    @Override
    public void deleteOwner(Long idOwner) {
        ownerRepository.deleteOwner(idOwner);
    }

    @Override
    public void assignOwnerToAgency(Long idAgency, Long idOwner) {
        ownerRepository.assignOwnerToAgency(idAgency, idOwner);
    }

    @Override
    public void removeOwnerWithHouse(Long idOwner) {
        ownerRepository.removeOwnerWithHouse(idOwner);
    }

    @Override
    public Owner getOwnerByAgencyId(Long idAgency) {
        return ownerRepository.getOwnerByAgencyId(idAgency);
    }

    @Override
    public void getAgeAndNameFromAllOwners() {
        ownerRepository.getAgeAndNameFromAllOwners();
    }
}
