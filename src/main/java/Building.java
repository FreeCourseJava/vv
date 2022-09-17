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

    public int calcArea() {
        return multiplyExact(this.length, this.width);
    }

    public JSON getJson() {
        return new JSON()
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