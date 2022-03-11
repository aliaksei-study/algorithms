package com.sorting.insertionsort;

import java.util.Arrays;

public class Main {

    public static void sortDescending(int[] array) {
        int i, value;
        for (int j = array.length - 2; j >= 0; j--) {
            value = array[j];
            i = j + 1;
            while (i < array.length && array[i] > value) {
                array[i - 1] = array[i];
                i++;
            }
            array[i - 1] = value;
        }
    }

    public static void sort(int[] array) {
        int i, value;
        for (int j = 1; j < array.length; j++) {
            value = array[j];
            i = j - 1;
            while (i >= 0 && array[i] > value) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{6, 8, 15, 2, 4, 9, 10, 1, 14, 11, 10};
        sortDescending(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}
