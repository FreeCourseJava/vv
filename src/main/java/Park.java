package main.java;

import static java.lang.Math.multiplyExact;

public class Park extends Measurable{
    public String name;

    public Park (String name, int length, int width ) {
        super(length,width);
        this.name = name;
    }



}
