package main.java;

import java.util.Arrays;

public class TestArrayUtils {
    public static void main(String[] args) {
        int a[] = null;
        System.out.println(ArrayUtils.isEmpty(a));

        a = new int[] {7,2,3,4,6};
        System.out.println(Arrays.toString(ArrayUtils.bubbleSort(a)));
        System.out.println(Arrays.toString(ArrayUtils.cocktailShakerSort(a)));
        System.out.println(ArrayUtils.isElement(a,5));
        System.out.println(ArrayUtils.isElement(a,6));
    }

}
