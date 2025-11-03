package peaksoft.service;

import peaksoft.entity.Owner;

import java.util.List;

public interface OwnerService {
    void saveOwner(Owner owner);
    Owner getOwnerById(Long idOwner);
    List<Owner> getAllOwners();
    void updateOwner(Long idOwner, Owner owner);
    void deleteOwner(Long idOwner);
    void assignOwnerToAgency(Long idAgency,  Long idOwner);
    void removeOwnerWithHouse(Long idOwner);
    Owner getOwnerByAgencyId(Long idAgency);
    void getAgeAndNameFromAllOwners();
}
