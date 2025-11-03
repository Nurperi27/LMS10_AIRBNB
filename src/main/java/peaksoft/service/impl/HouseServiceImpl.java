package peaksoft.service.impl;

import peaksoft.entity.House;
import peaksoft.repository.HouseRepository;
import peaksoft.repository.implRepository.HouseRepoImpl;
import peaksoft.service.HouseService;

import java.time.LocalDate;
import java.util.List;

public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository = new HouseRepoImpl();
    @Override
    public void saveHouse(House house) {
        houseRepository.saveHouse(house);
    }

    @Override
    public House getHouseById(Long idHouse) {
        return houseRepository.getHouseById(idHouse);
    }

    @Override
    public List<House> getAllHouse() {
        return houseRepository.getAllHouse();
    }

    @Override
    public void updateHouse(Long idHouse, House house) {
        houseRepository.updateHouse(idHouse, house);
    }

    @Override
    public void deleteHouse(Long idHouse) {
        houseRepository.deleteHouse(idHouse);
    }

    @Override
    public void removeHouseWithAddress(Long idHouse) {
        houseRepository.removeHouseWithAddress(idHouse);
    }

    @Override
    public List<House> getHouseByRegion(String region) {
        return houseRepository.getHouseByRegion(region);
    }

    @Override
    public List<House> getHouseByAgencyId(Long idAgency) {
        return houseRepository.getHouseByAgencyId(idAgency);
    }

    @Override
    public List<House> getHouseByOwnerId(Long idOwner) {
        return houseRepository.getHouseByOwnerId(idOwner);
    }

    @Override
    public List<House> getHouseByCheckInBetween(LocalDate checkIn1, LocalDate checkIn2) {
        return houseRepository.getHouseByCheckInBetween(checkIn1, checkIn2);
    }
}
