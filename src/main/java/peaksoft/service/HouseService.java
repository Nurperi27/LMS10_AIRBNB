package peaksoft.service;

import peaksoft.entity.House;

import java.time.LocalDate;
import java.util.List;

public interface HouseService {
    void saveHouse(House house);
    House getHouseById(Long idHouse);
    List<House> getAllHouse();
    void updateHouse(Long idHouse, House house);
    void deleteHouse(Long idHouse);
    void removeHouseWithAddress(Long idHouse);
    List<House> getHouseByRegion(String region);
    List<House> getHouseByAgencyId(Long idAgency);
    List<House> getHouseByOwnerId(Long idOwner);
    List<House> getHouseByCheckInBetween(LocalDate checkIn1, LocalDate checkIn2);
}
