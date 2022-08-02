package main.java;

public class ClassesBasics {
    public static void main(String[] args) {
        // City 1 creation
        Building building001 = new Building(1, 10, 10);
        Building building002 = new Building(2, 20 , 20) ;

        Park park001 = new Park("Сокольники", 10,30);

        Street street01 = new Street("Сокольнический вал", 20, 40);
        street01.addPark(park001);
        street01.addBuilding(building001);
        street01.addBuilding(building002);

        Building building011 = new Building(11, 5, 5);
        Building building012 = new Building(12, 6, 6);

        Park park011 = new Park("Бабушкинский", 10,30);

        Street street02 = new Street("Енисейская", 20, 40);
        street02.addPark(park011);
        street02.addBuilding(building011);
        street02.addBuilding(building012);

        DynamicArray streets = new DynamicArray();
        streets.add(street01);
        streets.add(street02);

        City city1 = new City("Москва", 30,80, streets);

        // City 2 creation
        Building building101 = new Building(101, 12,12);
        Building building102 = new Building(102,15,7);

        Park park101 = new Park("Stromovka", 10,30);

        Street street11 = new Street("Královská obora", 20, 40);
        street11.addPark(park101);
        street11.addBuilding(building101);
        street11.addBuilding(building102);
        Building building111 = new Building(111, 8, 7);
        Building building112 = new Building(112, 4, 10);

        Park park111 = new Park("Malešice", 10,30);

        Street street12 = new Street("Akademická", 20, 40);
        street12.addPark(park111);
        street12.addBuilding(building111);
        street12.addBuilding(building112);

        City city2 = new City("Praha", 30,80);
        city2.addStreet(street11);
        city2.addStreet(street12);


        // Test calculation methods

        System.out.println("city1.countBuildings(): " + city1.countBuildings());
        System.out.println("city1.calcBuildingsArea(): " + city1.calcBuildingsArea());
        System.out.println("city1.calcParksArea(): " + city1.calcParksArea());

        System.out.println("street01.countBuildings(): " + street01.countBuildings());
        System.out.println("street01.calcBuildingsArea(): " + street01.calcBuildingsArea());

        System.out.println("street02.countBuildings(): " + street02.countBuildings());
        System.out.println("street02.calcBuildingsArea(): " + street02.calcBuildingsArea());




    }
}


