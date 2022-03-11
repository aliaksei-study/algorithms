package com.sorting.mergesort;

import java.util.Arrays;

public class Main {

    public static void merge(int[] array, int firstIndex, int middleIndex, int lastIndex) {
        int leftSubArraySize = middleIndex - firstIndex + 1;
        int rightSubArraySize = lastIndex - middleIndex;
        int[] leftSubArray = new int[leftSubArraySize + 1];
        int[] rightSubArray = new int[rightSubArraySize + 1];

        for (int i = 0; i < leftSubArraySize; i++) {
            leftSubArray[i] = array[firstIndex + i];
        }

        for (int i = 0; i < rightSubArraySize; i++) {
            rightSubArray[i] = array[middleIndex + i + 1];
        }

        leftSubArray[leftSubArraySize] = Integer.MAX_VALUE;
        rightSubArray[rightSubArraySize] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = firstIndex; k <= lastIndex; k++) {
            if (leftSubArray[i] <= rightSubArray[j]) {
                array[k] = leftSubArray[i];
                i++;
            } else {
                array[k] = rightSubArray[j];
                j++;
            }
        }
    }

    public static void sort(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            sort(array, firstIndex, middleIndex);
            sort(array, middleIndex + 1, lastIndex);
            merge(array, firstIndex, middleIndex, lastIndex);
        }
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{6, 8, 15, 2, 4, 9, 10, 1, 14, 11, 10};
        sort(testArray, 0, testArray.length - 1);
        System.out.println(Arrays.toString(testArray));
    }
}
