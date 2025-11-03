package peaksoft.repository;

import peaksoft.entity.Agency;

import java.util.List;

public interface AgencyRepository {
    /*CRUD
    Agency тузулуп жатканда адреси кошо тузулсун!
    Agency очкондо адреси жана rent_info кошо очсун
    Constraint: phoneNumber (+996) and length(13)*/
    void saveAgency(Agency agency);
    Agency getAgencyById(Long idAgency);
    List<Agency> getAllAgencies();
    void updateAgency(Long idAgency, Agency agency);
    void deleteAgency(Long idAgency);
}
