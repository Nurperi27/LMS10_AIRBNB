package peaksoft.repository;

import peaksoft.entity.RentInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RentInfoRepository {
    /*get кылып жатканда эки дата берилет, ошол датанын ортосундагы check out болгон rent info лордо алып чыгып бериниз
    Agency id менен учурдагы датада канча уй ижарага берилген санын чыгарыныз.*/
    void saveRentInfo(RentInfo rentInfo);
    void deleteRentInfo(Long idRentInfo);
    List<RentInfo> findRentInfoByCheckOutBetween(LocalDate x1, LocalDate x2);
    Long countOfHouseRentedByAgencyId(Long idAgency);
}
