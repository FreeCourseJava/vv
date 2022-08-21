package main.java;

import java.util.Arrays;

public class DynamicArray {

    private Measurable[] list;

    public DynamicArray() {
        this.list = new Measurable[]{};
    }

    public int getSize() {
        return this.list.length;
    }

    public void add(Measurable item) {
        this.list = Arrays.copyOf(this.list, this.getSize()+1);
        this.list[this.getSize() - 1] = item;

    }

    public Measurable getItem(int index) {
        if (index >= 0 &&  index < this.getSize()) {
            return this.list[index];
        }
        else {
            return null;
        }

    }
}
