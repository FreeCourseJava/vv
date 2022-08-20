package main.java;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public String toString() {

        if (this.size == 0) {
            return "List is empty";
        }

        String res = "List size is " + this.size + ". ";
        res += "head ";
        ListNode node = this.head;
        for (int i = 0; i < this.size; i++) {
            res += "-> " + node.value.toString();
            node = node.next;
        }

        res += "--->tail>---";

        node = this.tail;
        for (int i = 0; i < this.size; i++) {
            res += "-> " + node.value.toString();
            node = node.prev;
        }

        res += "-> head";
        return res;
    }

    public int getSize() {
        return size;
    }

    private boolean increaseSize() {
        if (this.size < Integer.MAX_VALUE) {
            this.size++;
            return true;
        }

        System.err.println("ERROR: List size limit was reached");
        return false;

    }

    // Adding the first one if the list is empty
    private boolean addIfEmpty(Object value) {
        if (this.size == 0) {
            this.size++;
            ListNode newNode = new ListNode(null, null, value);
            this.head = newNode;
            this.tail = newNode;
            return true;
        }

        return false;
    }

    private ListNode findNode(int index) {
        if (index >= 0 && index < this.size) {
            ListNode node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        return null;
    }

    public boolean addToHead(Object value) {

        if (addIfEmpty(value)) {
            return true;
        }

        if (increaseSize()) {
            ListNode newNode = new ListNode(null, this.head, value);
            this.head.prev = newNode;
            this.head = newNode;

            return true;
        }
        return false;
    }

    public boolean addToTail(Object value) {

        if (addIfEmpty(value)) {
            return true;
        }

        if (increaseSize()) {
            ListNode newNode = new ListNode(this.tail, null, value);
            this.tail.next = newNode;
            this.tail = newNode;

            return true;
        }
        return false;
    }

    public int getIndex(Object obj) {
        ListNode node = this.head;
        int i = 0;

        while (node != null) {
            if (obj.equals(node.value)) {
                return i;
            }

            i++;
            node = node.next;
        }

        return -1;
    }

    public Object getValue(int index) {
        ListNode node = findNode(index);
        return node == null ? null : node.value;
    }

    public boolean remove(int index) {

        ListNode node = findNode(index);

        if (node != null) {
            if (node.prev == null) {
                this.head = node.next;
            } else {
                node.prev.next = node.next;
            }

            if (node.next == null) {
                this.tail = node.prev;
            } else {
                node.next.prev = node.prev;
            }

            size--;

            return true;
        }

        return false;

    }


    public boolean addAfter(Object value, int index) {

        ListNode node = this.findNode(index);

        if (node != null && increaseSize()) {
            ListNode newNode = new ListNode(node, node.next, value);

            if (node.next == null) {
                this.tail = newNode;
            } else {
                node.next.prev = newNode;
            }

            node.next = newNode;

            return true;
        }

        return false;

    }

    public boolean addBefore(Object value, int index) {

        ListNode node = this.findNode(index);

        if (node != null && increaseSize()) {
            ListNode newNode = new ListNode(node.prev, node, value);

            if (node.prev == null) {
                this.head = newNode;
            } else {
                node.prev.next = newNode;
            }

            node.prev = newNode;

            return true;
        }

        return false;

    }

    public Object getHead() {
        return this.head.value;
    }

    public Object getTail() {
        return this.tail.value;
    }

}
