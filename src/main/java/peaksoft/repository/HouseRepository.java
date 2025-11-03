package peaksoft.repository;

import peaksoft.entity.House;

import java.time.LocalDate;
import java.util.List;

public interface HouseRepository {
    /*CRUD
    House-тузулуп жатканда бир owner-ге тиешелуу болуп тузулсун
    House-ту очуруп жатканда адреси чогу очсун . Бирок ижарасы жок болсо очсун, эгерде ижарасы бар болсо checkout датасын текшерсин.
                                Учурдагы датадан мурун болсо rent_info менен чогу очуп кетсин.
    Бир региондогу бардык уйлор чыксын
    Бир агентсвога тиешелуу бардык уйлор чыксын
    Бир owner-ге тиешелуу бардык уйлор чыксын
    Эки датанын ортосундагы checkIn болгон бардык уйлор чыксын*/
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
