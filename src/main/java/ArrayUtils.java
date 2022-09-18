package main.java;

import static java.lang.System.arraycopy;

public final class ArrayUtils {
    private ArrayUtils() {

    }

    public static boolean isEmpty(int[] array) {
        return (array != null) && (array.length == 0);
    }

    public static int[] bubbleSort(int[] array) {
        int[] sortedArray = array.clone();
        for (int i = 1; i < sortedArray.length; i++) {
            for (int j = 1; j <= sortedArray.length - i; j++) {
                if (sortedArray[j - 1] > sortedArray[j]) {
                    int tmp = sortedArray[j - 1];
                    sortedArray[j - 1] = sortedArray[j];
                    sortedArray[j] = tmp;
                }
            }
        }
        return sortedArray;
    }

    public static int[] cocktailShakerSort(int[] array) {
        int[] sortedArray = array.clone();
        int first = 0;
        int last = sortedArray.length - 1;
        int swapped = sortedArray.length - 1;

        do {
            for (int i = first; i < last; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    swap(sortedArray, i, i + 1);
                    swapped = i;
                }
            }
            last = swapped;

            for (int i = last; i > first; i--) {
                if (sortedArray[i - 1] > sortedArray[i]) {
                    swap(sortedArray, i, i - 1);
                    swapped = i;
                }
            }
            first = swapped;

        } while (last > first);

        return sortedArray;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static boolean isElement(int[] array, int element) {
        int first = 0;
        int last = array.length - 1;

        if (first <= last) {
            int mid = first + (last - first) / 2;
            if (array[mid] == element) {
                return true;
            }
            if (array[mid] > element) {
                int newArrayLen = mid - first;
                int[] newArray = new int[newArrayLen];
                arraycopy(array, first, newArray, 0, newArrayLen);
                return isElement(newArray, element);
            } else {
                int newArrayLen = last - mid;
                int[] newArray = new int[newArrayLen];
                arraycopy(array, mid + 1, newArray, 0, newArrayLen);
                return isElement(newArray, element);
            }
        } else {
            return false;
        }
    }
}
