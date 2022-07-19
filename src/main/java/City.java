package main.java;

public class City {
    public String name;
    public int maxWidth;
    public int maxLength;
    public Street[] streets;

    public City (String name, int maxWidth, int maxLength, Street[] streets) {
        this(name, maxWidth, maxLength);
    }

    public City(String name, int maxWidth, int maxLength) {
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
    }


}
