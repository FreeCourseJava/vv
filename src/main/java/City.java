package main.java;

import static java.lang.Math.addExact;

public class City {
    public String name;
    public int maxWidth;
    public int maxLength;
    private DynamicArray streets;

    public City (String name, int maxWidth, int maxLength, DynamicArray streets) {
        this(name, maxWidth, maxLength);
        this.streets = streets;

    }

    public City(String name, int maxWidth, int maxLength) {
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
        this.streets = new DynamicArray();
    }

    public void addStreet(Street street) {
        this.streets.add(street);
    }

    public int countBuildings () {
        int result = 0;

        for (int i = 0; i < this.streets.getSize(); i++) {
            result = addExact(result, ((Street) this.streets.getItem(i)).countBuildings());
        }

        return result;
    }

    public int calcBuildingsArea() {
        int result = 0;

        for (int i = 0; i < this.streets.getSize(); i++) {
            result = addExact(result, ((Street) this.streets.getItem(i)).calcBuildingsArea());
        }

        return result;
    }

    public int calcParksArea() {
        int result = 0;

        for (int i = 0; i < this.streets.getSize(); i++) {
            result = addExact(result, ((Street) this.streets.getItem(i)).calcParksArea());
        }

        return result;
    }

    public JSON getJson () {
        JSON res = new JSON().startObject();
        res.startArray("streets");
        for (int i=0; i<this.streets.getSize();i++) {
            res.addArrayItem(((Street) this.streets.getItem(i)).getJson());
        }
        res.closeArray();

        res.addStrField("name", name)
                .addIntField("maxWidth",this.maxWidth)
                .addIntField("maxLength", this.maxLength);

        return res.closeObject();
    }
    public String getJsonString() {
        return this.getJson().toString();
    }
}
