package main.java;

import static java.lang.Math.*;

public class Measurable {
    private int length;
    private int width;

    public Measurable(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public boolean equals(Measurable m) {
        if (this.length == m.length && this.width == m.width) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "Length: " + this.length + ", width: " + this.width;
    }

    public int calcArea() {
        return Math.multiplyExact(this.length, this.width);
    }
}
