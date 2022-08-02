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
        return size;
    }

    public void add(Object item) {
        size ++;
        list = Arrays.copyOf(list, size);
        list[size - 1] = item;

    }

    public Object getItem(int index) {
        if (index >=0 &&  index < size) {
            return list[index];
        }
        else {
            return null;
        }

    }
}
