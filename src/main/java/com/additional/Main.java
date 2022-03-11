package com.additional;

public class Main {

    public static boolean isSumOfTwoElementsEqualToGivenNumber(int[] arr, int requiredSum) {
        int i = 0;
        int j = arr.length - 1;
        int sum;

        while (i <= j) {
            if (arr[j] >= requiredSum) {
                j--;
            } else {
                sum = arr[i] + arr[j];
                if (sum == requiredSum) {
                    return true;
                } else if (sum > requiredSum) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{-1, 1, 3, 3, 4, 5, 7, 8, 9, 11}; // merge sort O(nlgn)
        int requiredSum = 7;
        System.out.println(isSumOfTwoElementsEqualToGivenNumber(testArray, requiredSum));
    }
}
