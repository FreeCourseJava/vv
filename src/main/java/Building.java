package main.java;

import static java.lang.Math.multiplyExact;

public class Building {
    public int number;
    public int length;
    public int width;

    public Building(int number, int length, int width) {
        this.number = number;
        this.length = length;
        this.width = width;
    }

    public Building(String jsonStr) {
        JSONReader json = new JSONReader(jsonStr);
        this.number = json.getIntFiled("number");
        this.length = json.getIntFiled("length");
        this.width = json.getIntFiled("width");
    }

    public int calcArea() {
        return multiplyExact(this.length, this.width);
    }

    public JSONWriter getJson() {
        return new JSONWriter()
                .startObject()
                .addIntField("number", number)
                .addIntField("length", length)
                .addIntField("width", width)
                .closeObject();
    }

    public String getJsonString() {
        return getJson().toString();
    }

}