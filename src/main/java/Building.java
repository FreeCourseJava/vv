package main.java;


public class Building extends Measurable {
    public int number;

    public Building(int number, int length, int width) {
        super(length, width);
        this.number = number;
    }
}