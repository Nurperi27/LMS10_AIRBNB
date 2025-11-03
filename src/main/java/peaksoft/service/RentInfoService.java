package peaksoft.service;

import peaksoft.entity.RentInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RentInfoService {
    void saveRentInfo(RentInfo rentInfo);
    void deleteRentInfo(Long idRentInfo);
    List<RentInfo> findRentInfoByCheckOutBetween(LocalDate x1, LocalDate x2);
    Long countOfHouseRentedByAgencyId(Long idAgency);
}
