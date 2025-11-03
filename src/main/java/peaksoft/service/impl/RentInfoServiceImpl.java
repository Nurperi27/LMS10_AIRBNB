package peaksoft.service.impl;

import peaksoft.entity.RentInfo;
import peaksoft.repository.RentInfoRepository;
import peaksoft.repository.implRepository.RentInfoRepoImpl;
import peaksoft.service.RentInfoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class RentInfoServiceImpl implements RentInfoService {
    private final RentInfoRepository rentInfoRepository = new RentInfoRepoImpl();

    @Override
    public void saveRentInfo(RentInfo rentInfo) {
        rentInfoRepository.saveRentInfo(rentInfo);
    }

    @Override
    public void deleteRentInfo(Long idRentInfo) {
        rentInfoRepository.deleteRentInfo(idRentInfo);
    }

    @Override
    public List<RentInfo> findRentInfoByCheckOutBetween(LocalDate x1, LocalDate x2) {
        return rentInfoRepository.findRentInfoByCheckOutBetween(x1, x2);
    }

    @Override
    public Long countOfHouseRentedByAgencyId(Long idAgency) {
        return rentInfoRepository.countOfHouseRentedByAgencyId(idAgency);
    }
}
