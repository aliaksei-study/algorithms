package com.orderstatistics;

import java.util.Arrays;

public class MedianOfTwoArraysMain {

    public static int median(int[] firstArray, int[] secondArray, int n) {
        if (n == 1) {
            return Math.min(firstArray[0], secondArray[0]);
        }

        if (firstArray[n / 2] < secondArray[n / 2]) {
            return median(Arrays.copyOfRange(firstArray, n / 2, n), Arrays.copyOfRange(secondArray, 0, n / 2), n / 2);
        }

        return median(Arrays.copyOfRange(firstArray, 0, n / 2), Arrays.copyOfRange(secondArray, n / 2, n), n / 2);
    }

    public static void main(String[] args) {
        int[] firstArray = new int[]{1, 5, 9, 13, 16, 18};
        int[] secondArray = new int[]{0, 3, 4, 8, 15, 17};

        System.out.println(median(firstArray, secondArray, firstArray.length));
    }
}
