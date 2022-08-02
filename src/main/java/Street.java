package main.java;

import static java.lang.Math.addExact;

public class Street {
    public String name;
    public int registryNumber;
    public boolean isMainRoad;
    public int length;
    public int avgWidth;
    private DynamicArray buildings;
    public DynamicArray parks;

    public Street (String name, int length, int avgWidth) {
        this.name = name;
        this.length = length;
        this.avgWidth = avgWidth;
        this.buildings = new DynamicArray();
        this.parks = new DynamicArray();
    }

    public void addBuilding(Building building) {
        this.buildings.add(building);
    }

    public int countBuildings(){
        return this.buildings.getSize();
    }

    public int calcBuildingsArea() {
        int result = 0;

        for (int i = 0; i < this.buildings.getSize(); i++) {
            result = addExact(result, ((Building) this.buildings.getItem(i)).calcArea());
        }

        return result;
    }

    public void addPark(Park park) {
        this.parks.add(park);
    }

    public int countParks(){
        return this.parks.getSize();
    }

    public int calcParksArea() {
        int result = 0;

        for (int i = 0; i < this.parks.getSize(); i++) {
            result = addExact(result, ((Park) this.parks.getItem(i)).calcArea());
        }

        return result;
    }

}
