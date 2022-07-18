package main.java;

public class ClassesBasics {
    public static void main(String[] args) {
        // City 1
        Building building001 = new Building(1);
        Building building002 = new Building(2);

        Park park001 = new Park("Сокольники", 10,30);

        Street street01 = new Street("Сокольнический вал", 20, 40);
        street01.parks = new Park[] {park001};
        street01.buildings = new Building[] {building001, building002};

        Building building011 = new Building(11);
        Building building012 = new Building(12);

        Park park011 = new Park("Бабушкинский", 10,30);

        Street street02 = new Street("Енисейская", 20, 40);
        street02.parks = new Park[] {park011};
        street02.buildings = new Building[] {building011, building012};

        City city1 = new City("Москва", 30,80, new Street[]{street01, street02});

        // City 2
        Building building101 = new Building(101);
        Building building102 = new Building(102);

        Park park101 = new Park("Stromovka", 10,30);

        Street street11 = new Street("Královská obora", 20, 40);
        street11.parks = new Park[] {park101};
        street11.buildings = new Building[] {building101, building102};

        Building building111 = new Building(111);
        Building building112 = new Building(112);

        Park park111 = new Park("Malešice", 10,30);

        Street street12 = new Street("Akademická", 20, 40);
        street12.parks = new Park[] {park111};
        street12.buildings = new Building[] {building111, building112};

        City city2 = new City("Praha", 30,80);
        city2.streets =  new Street[]{street11, street12};
    }
}


