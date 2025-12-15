package com.xworkz.coreapp.airport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(CoreConfigure.class);

        AirPort airPort = context.getBean(AirPort.class);
        airPort.setNum(1);
        airPort.setName("Bangloreeeeeeeee");
        System.out.println(airPort);

        AirPort airPort1 = context.getBean(AirPort.class);
        airPort1.setNum(1);
        airPort1.setName("Banglore");
        System.out.println(airPort1);

        Terminal terminal = context.getBean(Terminal.class);
        terminal.setTerminalPlace("xyz");
        terminal.setTerminalNumber(21);
        terminal.setTerminalGateNumber(12);
        terminal.setTerminalName("abc");
        System.out.println(terminal);

        Terminal terminal1 = context.getBean(Terminal.class);
        terminal1.setTerminalPlace("xyzzzzzzzzz");
        terminal1.setTerminalNumber(21);
        terminal1.setTerminalGateNumber(12);
        terminal1.setTerminalName("abc");
        System.out.println(terminal1);

        Hospital hospital = context.getBean(Hospital.class);
        System.out.println(hospital);

        College college = context.getBean(College.class);
        System.out.println(college);

        Company company = context.getBean(Company.class);
        System.out.println(company);

        Bank bank = context.getBean(Bank.class);
        System.out.println(bank);

        School school = context.getBean(School.class);
        System.out.println(school);

        Library library = context.getBean(Library.class);
        System.out.println(library);

        Hotel hotel = context.getBean(Hotel.class);
        System.out.println(hotel);

        Restaurant restaurant = context.getBean(Restaurant.class);
        System.out.println(restaurant);

        Office office = context.getBean(Office.class);
        System.out.println(office);

        University university = context.getBean(University.class);
        System.out.println(university);

        PoliceStation policeStation = context.getBean(PoliceStation.class);
        System.out.println(policeStation);

        CentralLibrary centralLibrary = context.getBean(CentralLibrary.class);
        System.out.println(centralLibrary);

        Court court = context.getBean(Court.class);
        System.out.println(court);

        Warehouse warehouse = context.getBean(Warehouse.class);
        System.out.println(warehouse);

        Zoo zoo = context.getBean(Zoo.class);
        System.out.println(zoo);

        Factory factory = context.getBean(Factory.class);
        System.out.println(factory);

        Cinema cinema = context.getBean(Cinema.class);
        System.out.println(cinema);

        Gym gym = context.getBean(Gym.class);
        System.out.println(gym);

        Stadium stadium = context.getBean(Stadium.class);
        System.out.println(stadium);

        Server server = context.getBean(Server.class);
        System.out.println(server);

        Network network = context.getBean(Network.class);
        System.out.println(network);

        Application application = context.getBean(Application.class);
        System.out.println(application);

        Website website = context.getBean(Website.class);
        System.out.println(website);

        Database database = context.getBean(Database.class);
        System.out.println(database);

        Cloud cloud = context.getBean(Cloud.class);
        System.out.println(cloud);

        OperatingSystem operatingSystem = context.getBean(OperatingSystem.class);
        System.out.println(operatingSystem);

        ApplicationServer applicationServer = context.getBean(ApplicationServer.class);
        System.out.println(applicationServer);

        Device device = context.getBean(Device.class);
        System.out.println(device);

        Machine machine = context.getBean(Machine.class);
        System.out.println(machine);

        Engine engine = context.getBean(Engine.class);
        System.out.println(engine);

        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println(vehicle);

        House house = context.getBean(House.class);
        System.out.println(house);

        City city = context.getBean(City.class);
        System.out.println(city);

        State state = context.getBean(State.class);
        System.out.println(state);

        Country country = context.getBean(Country.class);
        System.out.println(country);

        Classroom classroom = context.getBean(Classroom.class);
        System.out.println(classroom);

        Shop shop = context.getBean(Shop.class);
        System.out.println(shop);

        Garden garden = context.getBean(Garden.class);
        System.out.println(garden);

        Forest forest = context.getBean(Forest.class);
        System.out.println(forest);

        Laptop laptop = context.getBean(Laptop.class);
        System.out.println(laptop);

        Mobile mobile = context.getBean(Mobile.class);
        System.out.println(mobile);

        Camera camera = context.getBean(Camera.class);
        System.out.println(camera);

        Television television = context.getBean(Television.class);
        System.out.println(television);

        Refrigerator refrigerator = context.getBean(Refrigerator.class);
        System.out.println(refrigerator);

        WashingMachine washingMachine = context.getBean(WashingMachine.class);
        System.out.println(washingMachine);

        AirConditioner airConditioner = context.getBean(AirConditioner.class);
        System.out.println(airConditioner);

        Printer printer = context.getBean(Printer.class);
        System.out.println(printer);

        Speaker speaker = context.getBean(Speaker.class);
        System.out.println(speaker);

        Fan fan = context.getBean(Fan.class);
        System.out.println(fan);

        Bus bus = context.getBean(Bus.class);
        System.out.println(bus);

        Train train = context.getBean(Train.class);
        System.out.println(train);

        Ship ship = context.getBean(Ship.class);
        System.out.println(ship);

        Flight flight = context.getBean(Flight.class);
        System.out.println(flight);

        HospitalRoom hospitalRoom = context.getBean(HospitalRoom.class);
        System.out.println(hospitalRoom);

        ShopMall shopMall = context.getBean(ShopMall.class);
        System.out.println(shopMall);

        OfficeFloor officeFloor = context.getBean(OfficeFloor.class);
        System.out.println(officeFloor);

        ParkingLot parkingLot = context.getBean(ParkingLot.class);
        System.out.println(parkingLot);

        LibrarySection librarySection = context.getBean(LibrarySection.class);
        System.out.println(librarySection);

        DataCenter dataCenter = context.getBean(DataCenter.class);
        System.out.println(dataCenter);
    }
}
