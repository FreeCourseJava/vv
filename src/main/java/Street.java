package main.java;

public class Street {
    public String name;
    public int registryNumber;
    public boolean isMainRoad;
    public int length;
    public int avgWidth;
    public Building[] buildings;
    public Park[] parks;

    public Street (String name, int length, int avgWidth) {
        this.name = name;
        this.length = length;
        this.avgWidth = avgWidth;
    }

}
