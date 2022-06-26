package com.orderstatistics;

import java.util.Arrays;

public class ElementsClosestToMedianMain {

    public static int[] getKElementsClosestToMedian(int[] array, int k) {
        int[] closestElements = new int[k];
        int[] subtractMedianValues = new int[array.length];

        int medianValue = LinearWorstCaseMain.kthSmallest(Arrays.copyOf(array, array.length), 0, array.length - 1, (array.length / 2) + 1);

        for(int i = 0; i < array.length; i++) {
            subtractMedianValues[i] = Math.abs(medianValue - array[i]);
        }

        int kthSubtracted = LinearWorstCaseMain.kthSmallest(Arrays.copyOf(subtractMedianValues, subtractMedianValues.length), 0, subtractMedianValues.length - 1, k);

        int j = 0;
        for(int i = 0; i < subtractMedianValues.length; i++) {
            if(subtractMedianValues[i] <= kthSubtracted) {
                closestElements[j] = array[i];
                j++;
            }
        }


        return closestElements;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 0, 3, 6, 1, 4, 5};

        System.out.println(Arrays.toString(getKElementsClosestToMedian(array, 3)));
    }
}
