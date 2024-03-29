package main.java;

// Реализовать сортировку массива интов алгоритмом Coctail Shaker Sort

import java.util.Arrays;

public class CocktailShaker {


    public static void main(String[] args) {

        int[] array = new int[] {0,4,6,1,2,72134,123,2,42134,621,1,34234};
        sort(array);

        array = new int[] {};
        sort(array);

        array = new int[] {0};
        sort(array);

        array = new int[] {1,2};
        sort(array);

        array = new int[] {2,1};
        sort(array);

        array = new int[] {1,5,2,9,0};
        sort(array);

    }

    public static void sort(int[] array) {
        System.out.println("Original array: " + Arrays.toString(array));
        int first = 0;
        int last = array.length - 1;
        int swapped = array.length - 1;

        do {
            for (int i = first; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = i;
                }
            }
            last = swapped;

            for (int i = last; i > first; i--) {
                if (array[i - 1] > array[i]) {
                    swap(array, i, i - 1);
                    swapped = i;
                }
            }
            first = swapped;

        } while (last > first);

        System.out.println("Sorted array: " + Arrays.toString(array) + "\n");
    }

    public static void swap(int[] array, int i, int j) {
        int tmp= array[i];
        array[i]= array[j] ;
        array[j] = tmp;
    }
}
