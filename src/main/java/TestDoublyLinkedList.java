package main.java;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList a = new DoublyLinkedList();
        System.out.println("-----Checking the list right after its creation: ");
        System.out.println(a);

        System.out.println("-----adding 1 at the head");
        a.addToHead("1");
        System.out.println(a);

        System.out.println("-----adding 2 at the tail");
        a.addToTail("2");
        System.out.println(a);

        System.out.println("-----adding 3 at the head");
        a.addToHead("3");
        System.out.println(a);

        System.out.println("-----Index of first occurrence of \"1\"");
        System.out.println(a.getIndex("1"));

        System.out.println("-----Index of first occurrence of \"3\"");
        System.out.println(a.getIndex("3"));

        System.out.println("-----adding \"4\" after the index 1");
        a.addAfter("4", 1);
        System.out.println(a);

        System.out.println("-----adding \"5\" before the index 1");
        a.addBefore("5", 1);
        System.out.println(a);

        System.out.println("-----checking value at the index 3");
        System.out.println(a.getValue(3));

        System.out.println("-----remove value at index 2");
        a.remove(2);
        System.out.println(a);

        System.out.println("-----remove value at index 0");
        a.remove(0);
        System.out.println(a);

        System.out.println("-----remove value at index 2");
        a.remove(2);
        System.out.println(a);

        System.out.println("-----Index of first occurrence of \"5\"");
        System.out.println(a.getIndex("5"));

        System.out.println("-----Index of first occurrence of \"6\"");
        System.out.println(a.getIndex("6"));

        System.out.println("-----Value of the first item");
        System.out.println(a.getHead());

        System.out.println("-----Value of the last item");
        System.out.println(a.getTail());

        System.out.println("-----remove value at index 0");
        a.remove(0);
        System.out.println(a);

        System.out.println("-----Value of the first item");
        System.out.println(a.getHead());

        System.out.println("-----Value of the last item");
        System.out.println(a.getTail());
    }



}

