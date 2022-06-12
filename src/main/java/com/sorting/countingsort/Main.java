package com.sorting.countingsort;

import java.util.Arrays;

public class Main {

    public static int[] countingSort(int[] array, int maxElement) {
     int[] sortedArray = new int[array.length];
     int[] elementPositions = new int[maxElement + 1];

     for(int i = 0; i < array.length; i++) {
         elementPositions[array[i]] += 1;
     }

     for(int i = 1; i < elementPositions.length; i++) {
         elementPositions[i] += elementPositions[i - 1];
     }

     for(int i = array.length - 1; i >= 0; i--) {
         sortedArray[elementPositions[array[i]] - 1] = array[i];
         elementPositions[array[i]] -= 1;
     }

     return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        System.out.println(Arrays.toString(Arrays.stream(countingSort(array, 5)).toArray()));
    }
}
