package main.java;

import java.util.Arrays;

public class DynamicArray {

    private int size;
    private Object[] list;

    public DynamicArray() {
        this.list = new Object[]{};
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void add(Object item) {
        this.size ++;
        this.list = Arrays.copyOf(this.list, this.size);
        this.list[this.size - 1] = item;

    }

    public Object getItem(int index) {
        if (index >= 0 &&  index < this.size) {
            return this.list[index];
        }
        else {
            return null;
        }

    }
}
