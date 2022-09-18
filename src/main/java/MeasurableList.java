package main.java;

public interface MeasurableList {

    Measurable get (int index);

    boolean exists(Measurable measurable);

    Measurable remove (int index);

    Measurable remove (Measurable measurable);

    void add (Measurable measurable);


}
