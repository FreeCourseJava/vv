package main.java;


public class Street extends Measurable{
    public String name;
    public int registryNumber;
    public boolean isMainRoad;
    private DynamicArray buildings;
    public DynamicArray parks;

    public Street (String name, int length, int avgWidth) {
        super(length,avgWidth);
        this.name = name;
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
            result = Math.addExact(result, this.buildings.getItem(i).calcArea());
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
            result = Math.addExact(result, this.parks.getItem(i).calcArea());
        }

        return result;
    }

}
