package main.java;

public class ListNode {
    ListNode prev;
    ListNode next;
    Measurable value;

    public ListNode(ListNode prev, ListNode next, Measurable value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }


}