package main.java;

import java.util.Arrays;

public class DynamicArray {

    private Object[] list;

    public DynamicArray() {
        this.list = new Object[]{};
    }

    public int getSize() {
        return this.list.length;
    }

    public void add(Object item) {
        this.list = Arrays.copyOf(this.list, this.getSize()+1);
        this.list[this.getSize() - 1] = item;

    }

    public Object getItem(int index) {
        if (index >= 0 &&  index < this.getSize()) {
            return this.list[index];
        }
        else {
            return null;
        }

    }
}
