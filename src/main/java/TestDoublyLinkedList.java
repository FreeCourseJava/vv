package main.java;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList a = new DoublyLinkedList();
        System.out.println(a);
        a.addToHead("1");
        a.addToTail("2");
        a.addToHead("3");
        System.out.println(a.getIndex("1"));
        System.out.println(a.getIndex("2"));
        System.out.println(a.getSize());

        System.out.println(a);
        a.addAfter("4", 1);
        System.out.println(a);

        a.addBefore("5", 1);
        System.out.println(a);

        a.remove(2);
        System.out.println(a);
        a.remove(0);
        System.out.println(a);
        a.remove(2);
        System.out.println(a);

        System.out.println(a.getIndex("5"));
        System.out.println(a.getIndex("6"));
    }



}

