package peaksoft.repository;

import peaksoft.entity.Owner;

import java.util.List;

public interface OwnerRepository {
    /*CRUD
    Owner эки жол менен тузулсун(1-озу жалгыз 2- house менен чогу ), жашы 18-ден кичине owner-лер тузулбосун
    Owner-ди agency-ге assign кылган метод болсун
    Constraint: email unique
    Owner-ди очуруп жатканда, house-тары чогу очот. Бирок ижарасы жок болсо очсун, эгерде ижарасы бар болсо checkout датасын текшерсин.
                Учурдагы датадан мурун болсо rent_info менен чогу очуп кетсин. Бирок customer очпосун.
    Агентсвонун id-си менен owner-лерди ала турган метод туз
    Бардык owner-лердин аттарын жана жаштарын чыгарган метод болсун*/
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
