package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entity.*;
import peaksoft.enums.FamilyStatus;
import peaksoft.enums.Gender;
import peaksoft.enums.HouseType;
import peaksoft.service.*;
import peaksoft.service.impl.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        //System.out.println(HibernateConfig.getEntityManagerFactory());

        AgencyService agencyService = new AgencyServiceImpl();
        AddressService addressService = new AddressServiceImpl();
        //SAVE AGENCY + ADDRESS
        /*Address address1 = new Address("Bishkek", "Asanbai", "A.Tokombaev 132");
        Agency agency1 = new Agency();
        agency1.setAgencyName("House_kg");
        agency1.setPhoneNumber("+996700919191");
        agency1.setAddress(address1);
        agencyService.saveAgency(agency1);*/
        //---
        /*Address address2 = new Address("Shanshu", "AU-NT", "65435 Jana Circle");
        Agency agency2 = new Agency();
        agency2.setAgencyName("Apartment Agency");
        agency2.setPhoneNumber("+996550123456");
        agency2.setAddress(address2);
        agencyService.saveAgency(agency2);*/
        //---
        /*Address address3 = new Address("Pont Cassé", "US-FL", "36921 Briar Crest Point");
        Agency agency3 = new Agency();
        agency3.setAgencyName("Rent Agency");
        agency3.setPhoneNumber("+996999098765");
        agency3.setAddress(address3);
        agencyService.saveAgency(agency3);*/
        //---
        /*Address address4 = new Address("Samboan", "BR-PE", "47931 Delaware Road");
        Agency agency4 = new Agency();
        agency4.setAgencyName("Comfort House");
        agency4.setPhoneNumber("+996500789098");
        agency4.setAddress(address4);
        agencyService.saveAgency(agency4);*/
        //---
        //GET AGENCY BY ID
        //System.out.println(agencyService.getAgencyById(2L));
        //---
        //GET ALL AGENCY
        //System.out.println(agencyService.getAllAgencies());
        //---
        //UPDATE AGENCY
        /*Agency updateAgency1 = new Agency();
        updateAgency1.setAgencyName("My House");
        updateAgency1.setPhoneNumber("+996086123456");
        agencyService.updateAgency(1L, updateAgency1);*/
        //---
        //DELETE AGENCY
        /*System.out.println("Enter id of Agency to delete: ");
        agencyService.deleteAgency(new Scanner(System.in).nextLong());*/

        //Get All Address With Agency
        //System.out.println(addressService.getAddressByAgencyId());
        //---
        //Get ADDRESS BY ID
        //System.out.println(addressService.getAddressById(3L)); //??
        //---
        //Get ADDRESS WITHOUT AGENCY
        //System.out.println(addressService.getAllAddress()); //??
        //---
        //UPDATE ADDRESS
        /*Address updateAddress1 = new Address();
        updateAddress1.setCity("KwaMbonambi");
        updateAddress1.setRegion("BR-AM");
        updateAddress1.setStreet("1554 Talmadge Street");
        addressService.updateAddress(2L, updateAddress1);*/
        //---
        //COUNT OF AGENCY BY CITY_NAME
        //System.out.println("Count of Agency: " + addressService.countAgency("Bishkek"));
        //--
        //REGION + AGENCY
        //System.out.println(addressService.groupByRegion());

        CustomerService customerService = new CustomerServiceImpl();
        //SAVE CUSTOMER WITHOUT RENT_INFO
        //customerService.saveCustomer(new Customer("Serene", "Roggerone", "sroggeronej@shop-pro.jp",LocalDate.of(1988, 6, 13), Gender.FEMALE, "French", FamilyStatus.MARRIED));
        //customerService.saveCustomer(new Customer("Rafaellle", "Hannent", "rhannentk@miitbeian.gov.cn", LocalDate.of(1974, 10, 14), Gender.MALE, "Icelandic", FamilyStatus.SINGLE));
        //---
        //SAVE CUSTOMER WITH RENT_INFO
        RentInfoService rentInfoService = new RentInfoServiceImpl();
        /*Customer customer1 = new Customer("Aveline", "Aslum", "aasluml@w3.org", LocalDate.of(1994, 12, 23), Gender.FEMALE, "Kurdish", FamilyStatus.DIVORCED);
        RentInfo rentInfo1 = new RentInfo();
        rentInfo1.setCheckInDate(LocalDate.of(2021, 10, 12));
        rentInfo1.setCheckOutDate(LocalDate.of(2021, 10, 27));
        rentInfo1.setCustomer(customer1);
        List<RentInfo> rentInfos1 = Arrays.asList(rentInfo1);
        customer1.setRentInfos(rentInfos1);
        customerService.saveCustomer(customer1);*/
        //---
        /*Customer customer2 = new Customer("Gloria", "Powrie", "gpowriem@msn.com", LocalDate.of(1986, 11, 19), Gender.FEMALE, "Malay", FamilyStatus.WIDOW);
        RentInfo rentInfo2 = new RentInfo();
        rentInfo2.setCheckInDate(LocalDate.of(2021, 1, 19));
        rentInfo2.setCheckOutDate(LocalDate.of(2022, 11, 13));
        rentInfo2.setCustomer(customer2);
        customer2.setRentInfos(Arrays.asList(rentInfo2));
        customerService.saveCustomer(customer2);*/
        //---
        /*Customer customer3 = new Customer("Tilek", "Adam", "tcrimminsn@google.co.uk", LocalDate.of(1990, 1, 18), Gender.MALE, "Kyrgyz", FamilyStatus.MARRIED);
        RentInfo rentInfo3 = new RentInfo();
        rentInfo3.setCheckInDate(LocalDate.of(2021, 12, 12));
        rentInfo3.setCheckOutDate(LocalDate.of(2022, 3, 24));
        rentInfo3.setCustomer(customer3);
        customer3.setRentInfos(Arrays.asList(rentInfo3));
        customerService.saveCustomer(customer3);*/
        //---
        /*Customer customer4 = new Customer("Felike", "Jurisic", "fjurisico@joomla.org", LocalDate.of(1994, 8, 24), Gender.MALE, "Guaraní", FamilyStatus.SINGLE);
        RentInfo rentInfo4 = new RentInfo();
        rentInfo4.setCheckInDate(LocalDate.of(2021, 1, 27));
        rentInfo4.setCheckOutDate(LocalDate.of(2021, 8, 31));
        rentInfo4.setCustomer(customer4);
        customer4.setRentInfos(Arrays.asList(rentInfo4));
        customerService.saveCustomer(customer4);*/
        //---
        //GET CUSTOMER BY ID
        //System.out.println(customerService.getCustomerById(3L));
        //---
        //GET ALL CUSTOMERS
        //System.out.println(customerService.getAllCustomers());
        //---
        //UPDATE CUSTOMER
        /*Customer updateCustomer1 = new Customer();
        updateCustomer1.setFirstName("Kailey");
        updateCustomer1.setLastName("Gate");
        updateCustomer1.setEmail("kgatep@lycos.com");
        updateCustomer1.setDateOfBirth(LocalDate.of(1987, 4, 21));
        updateCustomer1.setGender(Gender.FEMALE);
        updateCustomer1.setNationality("Malayalam");
        updateCustomer1.setFamilyStatus(FamilyStatus.WIDOW);
        customerService.updateCustomer(4L, updateCustomer1);*/
        //---
        //DELETE CUSTOMER BY ID
        //customerService.deleteCustomerById(1L);
        //---
        //RENT CUSTOMER THE HOUSE BY RENT-INFO
        //System.out.println(customerService.rentHouse(3L, 1L, 1L, LocalDate.now(), LocalDate.of(2026, 1, 20)));
        //---
        //REMOVE CUSTOMER IF THEY DON'T HAVE RENT-INFO
        //customerService.removeCustomerById(3L); //?????????

        //SAVE OWNER WITHOUT HOUSE
        OwnerService ownerService = new OwnerServiceImpl();
        //ownerService.saveOwner(new Owner("Nikos", "Oxenford", "noxenford0@forbes.com", LocalDate.of(1960, 2, 3), Gender.MALE));
        //ownerService.saveOwner(new Owner("Mirlan", "Emirov", "aperford1@ask.com", LocalDate.of(1990, 5, 26), Gender.MALE));
        //---
        //SAVE OWNER WITH HOUSE
        HouseService houseService = new HouseServiceImpl();
        /*Owner owner = new Owner("Franky", "Lettuce", "flettuce2@wordpress.com", LocalDate.of(1983, 2, 27), Gender.MALE);
        House house = new House(HouseType.HOUSE, BigDecimal.valueOf(890), 1.8, "Goldner, Skiles and Gorczany", 11, true);
        house.setOwner(owner);
        owner.setHouses(Arrays.asList(house));
        ownerService.saveOwner(owner); */ //owner сохранился, но house - нет, т.к. PERSIST не было внутри Owner class
        /*Owner owner1 = new Owner("Katharyn", "Antonutti", "kantonutti3@usatoday.com", LocalDate.of(1984, 4, 5), Gender.FEMALE);
        House house1 = new House(HouseType.APARTMENT, BigDecimal.valueOf(1407), 2.6, "Dibbert, Emard and Gerlach", 19, false);
        house1.setOwner(owner1);
        owner1.setHouses(Arrays.asList(house1));
        ownerService.saveOwner(owner1);*/
        //---
        /*Owner owner2 = new Owner("Marney", "Cossey", "mcossey4@chron.com", LocalDate.of(1970, 2, 20), Gender.FEMALE);
        House house2 = new House(HouseType.APARTMENT, BigDecimal.valueOf(747), 1.4, "Smitham-Rogahn", 14, true);
        house2.setOwner(owner2);
        owner2.setHouses(Arrays.asList(house2));
        ownerService.saveOwner(owner2);*/
        //---
        /*Owner owner3 = new Owner("Byrann", "Brereton", "bbrereton5@vk.com", LocalDate.of(1980, 8, 15), Gender.MALE);
        House house3 = new House(HouseType.HOUSE, BigDecimal.valueOf(1393), 4.3, "Russel LLC", 14, true);
        house3.setOwner(owner3);
        owner3.setHouses(Arrays.asList(house3));
        ownerService.saveOwner(owner3);*/
        //---
        /*Owner owner4 = new Owner("Deena", "Gudd", "dgudd6@shutterfly.com", LocalDate.of(1977, 2, 13), Gender.FEMALE);
        House house4 = new House(HouseType.APARTMENT, BigDecimal.valueOf(496), 4.5, "Big light rooms", 5, false);
        house4.setOwner(owner4);
        owner4.setHouses(Arrays.asList(house4));
        ownerService.saveOwner(owner4);*/
        //---
        //GET OWNER BY ID
        //System.out.println(ownerService.getOwnerById(5L));
        //---
        //GET ALL OWNER
        //System.out.println(ownerService.getAllOwners());
        //---
        //UPDATE OWNER
        /*Owner updateOwner1 = new Owner();
        updateOwner1.setFirstName("Kirsteni");
        updateOwner1.setLastName("Winfred");
        updateOwner1.setEmail("kwinfred7@fastcompany.com");
        updateOwner1.setDateOfBirth(LocalDate.of(1986, 11, 6));
        updateOwner1.setGender(Gender.FEMALE);
        ownerService.updateOwner(6L, updateOwner1);*/
        //---
        // DELETE OWNER BY ID
        //ownerService.deleteOwner(3L);
        //---
        //ASSIGN OWNER TO AGENCY
        //ownerService.assignOwnerToAgency(4L, 8L);
        //ownerService.assignOwnerToAgency(3L, 5L);
        //ownerService.assignOwnerToAgency(2L, 6L);
        //ownerService.assignOwnerToAgency(1L, 7L);
        //---
        //REMOVE OWNER IF DOESN'T HAVE HOUSE OR RENT_INFO checkOut < CURRENT_DATE
        //ownerService.removeOwnerWithHouse(2L); //?????
        //---
        //GET OWNER BY AGENCY ID
        //System.out.println(ownerService.getOwnerByAgencyId(2L));
        //---
        //GET FULL NAME AND YEAR OF BIRTH DATE OF OWNER
        //ownerService.getAgeAndNameFromAllOwners(); //?????

        //GET HOUSE BY ID
        //System.out.println(houseService.getHouseById(3L));
        //---
        //GET ALL HOUSES
        //System.out.println(houseService.getAllHouse());
        //---
        //UPDATE HOUSE
        /*House updateHouse1 = new House();
        updateHouse1.setHouseType(HouseType.HOUSE);
        updateHouse1.setPrice(BigDecimal.valueOf(1162));
        updateHouse1.setRating(4.4);
        updateHouse1.setDescription("Armstrong, Kilback and Mueller");
        updateHouse1.setRoom(4);
        updateHouse1.setFurniture(true);
        houseService.updateHouse(3L, updateHouse1);*/
        //---
        //DELETE HOUSE
        //houseService.deleteHouse(1L);
        //---
        //REMOVE HOUSE WITH ADDRESS AND RENT-INFO
        //houseService.removeHouseWithAddress(1L);
        //---
        //GET ALL HOUSES BY REGION
        //System.out.println(houseService.getHouseByRegion("NORTH")); //[]
        //---
        //GET ALL HOUSE BY AGENCY ID
        //System.out.println(houseService.getHouseByAgencyId(3L)); //[]
        //---
        //GET ALL HOUSE BY OWNER ID
        //System.out.println(houseService.getHouseByOwnerId(7L));
        //---
        //GET HOUSE BY CHECKIN BETWEEN
        //System.out.println(houseService.getHouseByCheckInBetween(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 12, 31))); //NULL

        //GET RENT-INFO BY CHECKOUT BETWEEN
        //System.out.println(rentInfoService.findRentInfoByCheckOutBetween(LocalDate.of(2021, 8, 1), LocalDate.of(2021, 10, 31)));
        //---
        //Agency id менен учурдагы датада канча уй ижарага берилген санын чыгарыныз.
        //System.out.println(rentInfoService.countOfHouseRentedByAgencyId(4L)); //null
    }
}
