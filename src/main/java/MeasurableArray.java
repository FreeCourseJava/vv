package main.java;

import java.util.Arrays;

public class MeasurableArray implements MeasurableList {

    private Measurable[] list;

    public MeasurableArray() {
        this.list = new Measurable[]{};
    }

    public int getSize() {
        return (this.list == null) ? 0 : this.list.length;
    }

    @Override
    public Measurable get(int index) {
        if (index >= 0 && index < this.getSize()) {
            return this.list[index];
        } else {
            return null;
        }

    }

    private int getIndex(Measurable measurable) {
        if (this.getSize() != 0) {
            for (int i = 0; i < this.getSize(); i++) {
                if (measurable.equals(this.list[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Measurable measurable) {
        return this.getIndex(measurable) >= 0;
    }

    @Override
    public Measurable remove(int index) {
        if (index >= 0 && index < this.getSize()) {
            Measurable newList[] = new Measurable[this.getSize() - 1];
            System.arraycopy(this.list, 0, newList, 0, index);

            System.arraycopy(this.list, index + 1, newList, index, this.getSize() - index - 1);

            Measurable deleted = this.list[index];
            this.list = newList;
            return deleted;
        } else {
            return null;
        }
    }

    @Override
    public Measurable remove(Measurable measurable) {
        int index = this.getIndex(measurable);
        if (index >= 0) {
            return this.remove(index);
        } else {
            return null;
        }
    }

    @Override
    public void add(Measurable measurable) {
        this.list = Arrays.copyOf(this.list, this.getSize() + 1);
        this.list[this.getSize() - 1] = measurable;
    }
}
