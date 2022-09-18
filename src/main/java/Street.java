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

    public Street(String jsonStr) throws JsonReadException {
        JSONReader json = new JSONReader(jsonStr);
        this.name = json.getStrFiled("name");
        this.registryNumber = json.getIntFiled("registryNumber");
        this.isMainRoad = json.getBooleanFiled("isMainRoad");
        this.length = json.getIntFiled("length");
        this.avgWidth = json.getIntFiled("avgWidth");

        this.buildings = new DynamicArray();
        String [] buildingsStr = json.getArrayFiled("buildings");
        for (String s : buildingsStr) {
            this.buildings.add(new Building(s));
        }

        this.parks = new DynamicArray();
        String [] parksStr = json.getArrayFiled("parks");
        for (String s : parksStr) {
            this.parks.add(new Park(s));
        }
    }

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


    public JSONWriter getJson () {
        JSONWriter res = new JSONWriter().startObject();
        res.startArray("buildings");
        for (int i=0; i<this.buildings.getSize();i++) {
            res.addArrayItem(((Building) this.buildings.getItem(i)).getJson());
        }
        res.closeArray();

        res.startArray("parks");
        for (int i=0; i<this.parks.getSize();i++) {
            res.addArrayItem(((Park) this.parks.getItem(i)).getJson());
        }
        res.closeArray();

        res.addStrField("name", name)
                .addIntField("length",this.length)
                .addIntField("avgWidth", this.avgWidth)
                .addBooleanField("isMainRoad", this.isMainRoad)
                .addIntField("registryNumber",this.registryNumber);


        return res.closeObject();
    }
    public String getJsonString() {
        return this.getJson().toString();
    }

}
