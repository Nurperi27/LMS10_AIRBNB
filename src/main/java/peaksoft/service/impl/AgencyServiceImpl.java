package peaksoft.service.impl;

import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRepository;
import peaksoft.repository.implRepository.AgencyRepoImpl;
import peaksoft.service.AgencyService;
import java.util.List;

public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository = new AgencyRepoImpl();
    @Override
    public void saveAgency(Agency agency) {
        agencyRepository.saveAgency(agency);
    }

    @Override
    public Agency getAgencyById(Long idAgency) {
        return agencyRepository.getAgencyById(idAgency);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.getAllAgencies();
    }

    @Override
    public void updateAgency(Long idAgency, Agency agency) {
        agencyRepository.updateAgency(idAgency, agency);
    }

    @Override
    public void deleteAgency(Long idAgency) {
        agencyRepository.deleteAgency(idAgency);
    }
}
