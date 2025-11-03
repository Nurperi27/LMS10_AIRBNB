package peaksoft.service;

import peaksoft.entity.Agency;

import java.util.List;

public interface AgencyService {
    void saveAgency(Agency agency);
    Agency getAgencyById(Long idAgency);
    List<Agency> getAllAgencies();
    void updateAgency(Long idAgency, Agency agency);
    void deleteAgency(Long idAgency);
}
