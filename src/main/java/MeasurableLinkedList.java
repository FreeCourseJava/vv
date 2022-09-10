package main.java;

public class MeasurableLinkedList implements MeasurableList {
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


    private boolean increaseSize() {
        if (this.size < Integer.MAX_VALUE) {
            this.size++;
            return true;
        }

        System.err.println("ERROR: List size limit was reached");
        return false;

    }

    private boolean addIfEmpty(Measurable value) {
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

    private int getIndex(Measurable measurable) {
        ListNode node = this.head;
        int i = 0;

        while (node != null) {
            if (measurable.equals(node.value)) {
                return i;
            }

            i++;
            node = node.next;
        }

        return -1;
    }

    @Override
    public Measurable get(int index) {
        ListNode node = findNode(index);
        return node == null ? null : node.value;
    }

    @Override
    public boolean exists(Measurable measurable) {
        return getIndex(measurable) >= 0;
    }

    @Override
    public Measurable remove(int index) {
        ListNode node = findNode(index);

        if (node != null) {

            Measurable deleted = node.value;
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

            return deleted;
        }

        return null;
    }

    @Override
    public Measurable remove(Measurable measurable) {
        // два раза обходим список, что не очень эффективно
        // но допустим в нашей задаче это не критично
        int index = this.getIndex(measurable);
        if (index >= 0) {
            Measurable deleted = this.get(index);
            this.remove(index);
            return deleted;
        }

        return null;
    }

    @Override
    public void add(Measurable measurable) {
        if (!addIfEmpty(measurable) && increaseSize()) {
            ListNode newNode = new ListNode(this.tail, null, measurable);
            this.tail.next = newNode;
            this.tail = newNode;
        }

    }
}
