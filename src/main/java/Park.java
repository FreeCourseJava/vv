package main.java;

import static java.lang.Math.multiplyExact;

public class Park {
    public String name;
    public int length;
    public int width;

    public Park (String name, int length, int width ) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public int calcArea () {
        return multiplyExact(this.length, this.width);
    }

}
