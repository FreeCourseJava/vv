package main.java;

public class TestMeasurableLists {
    public static void main(String[] args) {
        MeasurableList a = new MeasurableArray();

        a.add(new Measurable(1,2));
        a.add(new Measurable(3,4));
        a.add(new Measurable(5,6));
        a.add(new Measurable(7,8));

        System.out.println(a.exists(new Measurable(3,4)));
        System.out.println(a.exists(new Measurable(3,5)));

        System.out.println(a.get(5));
        System.out.println(a.get(3));

        System.out.println(a.remove(1));
        System.out.println(a.remove(1));
        System.out.println(a.remove(new Measurable(7,8)));
        System.out.println(a.remove(0));
        System.out.println(a.remove(0));

        System.out.println("================================");
        a = new MeasurableLinkedList();

        a.add(new Measurable(1,2));
        a.add(new Measurable(3,4));
        a.add(new Measurable(5,6));
        a.add(new Measurable(7,8));

        System.out.println(a.exists(new Measurable(3,4)));
        System.out.println(a.exists(new Measurable(3,5)));

        System.out.println(a.get(5));
        System.out.println(a.get(3));

        System.out.println(a.remove(1));
        System.out.println(a.remove(1));
        System.out.println(a.remove(new Measurable(7,8)));
        System.out.println(a.remove(0));
        System.out.println(a.remove(0));
    }


}
