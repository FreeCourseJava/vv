package main.java;

import static java.lang.System.*;

//Переписать поиск числа в отсортированном массиве интов алгоритмом binary search используя рекурсию и копирование массива.

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[] {0,4,6,1,2,72134,123,2,42134,621,1,34234};
        CocktailShaker.sort(array);
        // next ones should return true;
        out.println(isElement(array,123));
        out.println(isElement(array,0));
        out.println(isElement(array,2));
        out.println(isElement(array,6));
        out.println(isElement(array,34234));
        // next ones should return false;
        out.println(isElement(array,3));
        out.println(isElement(array,5));
        out.println(isElement(array,342343));
        out.println(isElement(array,34233));

    }

    public static boolean isElement(int[] array, int element) {
        int first = 0;
        int last = array.length -1;

        if (first <= last) {
            int mid = first + (last - first) / 2;
            if (array[mid] == element) {
               return true;
            }
            if (array[mid] > element) {
                int newArrayLen = mid-first;
                int[] newArray = new int[newArrayLen];
                arraycopy(array,first, newArray,0,newArrayLen);
                return isElement(newArray, element);
            } else {
                int newArrayLen = last-mid;
                int[] newArray = new int[newArrayLen];
                arraycopy(array,mid+1, newArray,0,newArrayLen);
                return isElement(newArray, element);
            }
        }
        else {
            return false;
        }
    }
}
