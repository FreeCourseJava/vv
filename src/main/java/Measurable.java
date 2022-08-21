package main.java;

import static java.lang.Math.*;

public class Measurable {
    private int length;
    private int width;

    public Measurable(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int calcArea() {
        return Math.multiplyExact(this.length, this.width);
    }
}
