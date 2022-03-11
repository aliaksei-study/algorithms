package com.searching.binarysearch;

public class Main {

    public static int binarySearch(int[] arr, int leftIndex, int rightIndex, int value) {
        if (rightIndex >= leftIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (arr[middleIndex] == value) {
                return middleIndex;
            } else if (arr[middleIndex] > value) {
                return binarySearch(arr, leftIndex, middleIndex - 1, value);
            } else {
                return binarySearch(arr, middleIndex + 1, rightIndex, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{1, 3, 4, 8, 9, 11}; //always sorted array
        int searchingValue = 11;
        System.out.println(binarySearch(testArray, 0, testArray.length, searchingValue));
    }
}
