package com.sorting.quicksort;

import java.util.Arrays;

public class Main {

    public static int partition(int[] array, int left, int right) {
        int lastElement = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= lastElement) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    public static int hoarePartition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left;
        int j = right + 1;

        while (i < j) {
            do {
                i++;
            } while (pivot >= array[i]);

            do {
                j--;
            } while (pivot < array[j]);

            if(i < j) {
                swap(array, i, j);
            }
        }

        swap(array, left, j);
        return j;
    }

    public static void swap(int[] array, int sourceIndex, int destinationIndex) {
        int temp = array[sourceIndex];
        array[sourceIndex] = array[destinationIndex];
        array[destinationIndex] = temp;
    }

    public static void quicksort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = hoarePartition(array, left, right);
            quicksort(array, left, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{13, 19, 9, 5, 12, 8, 7, 4, 21, 26, 11};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
