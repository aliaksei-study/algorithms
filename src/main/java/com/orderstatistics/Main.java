package com.orderstatistics;

public class Main {

    public static int randomizedSelect(int[] array, int leftIndex, int rightIndex, int order) {
        if (leftIndex == rightIndex) {
            return array[leftIndex];
        }

        int q = com.sorting.quicksort.Main.randomizedPartition(array, leftIndex, rightIndex);

        int numberOfLowSideElements = q - leftIndex + 1;

        if (order == numberOfLowSideElements) {
            return array[q];
        } else if (order < numberOfLowSideElements) {
            return randomizedSelect(array, leftIndex, q - 1, order);
        } else {
            return randomizedSelect(array, q + 1, rightIndex, order - numberOfLowSideElements);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 9, 1, 7, 3, 0, 4, 6};

        System.out.println(randomizedSelect(array, 0, array.length - 1, 6));
    }
}
