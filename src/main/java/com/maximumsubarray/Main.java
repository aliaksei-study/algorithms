package com.maximumsubarray;

import java.util.Arrays;

public class Main {

    public static int[] findMaxCrossingSubarray(int[] array, int low, int middle, int high) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int maxLeftIndex = 0, maxRightIndex = 0;
        int sum = 0;

        for (int i = middle; i >= low; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeftIndex = i;
            }
        }

        sum = 0;

        for (int i = middle + 1; i <= high; i++) {
            sum += array[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRightIndex = i;
            }
        }

        return new int[]{maxLeftIndex, maxRightIndex, leftSum + rightSum};
    }

    public static int[] findMaximumSubarray(int[] array, int low, int high) {
        int lowSubarrayTupleIndex = 0;
        int highSubarrayTupleIndex = 1;
        int sumTupleIndex = 2;

        if (low == high) {
            return new int[]{low, high, array[low]};
        }

        int middle = (low + high) / 2;

        int[] leftSubarrayTuple = findMaximumSubarray(array, low, middle);
        int[] rightSubarrayTuple = findMaximumSubarray(array, middle + 1, high);
        int[] crossSubarrayTuple = findMaxCrossingSubarray(array, low, middle, high);

        if (leftSubarrayTuple[sumTupleIndex] >= rightSubarrayTuple[sumTupleIndex] &&
                leftSubarrayTuple[sumTupleIndex] >= crossSubarrayTuple[sumTupleIndex]) {
            return new int[]{leftSubarrayTuple[lowSubarrayTupleIndex], leftSubarrayTuple[highSubarrayTupleIndex],
                    leftSubarrayTuple[sumTupleIndex]};
        } else if (rightSubarrayTuple[sumTupleIndex] >= leftSubarrayTuple[sumTupleIndex] &&
                rightSubarrayTuple[sumTupleIndex] >= crossSubarrayTuple[sumTupleIndex]) {
            return new int[]{rightSubarrayTuple[lowSubarrayTupleIndex], rightSubarrayTuple[highSubarrayTupleIndex],
                    rightSubarrayTuple[sumTupleIndex]};
        } else {
            return new int[]{crossSubarrayTuple[lowSubarrayTupleIndex], crossSubarrayTuple[highSubarrayTupleIndex],
                    crossSubarrayTuple[sumTupleIndex]};
        }
    }

    public static int[] findMaximumSubarrayNonRecursively(int[] array) {
        int lowSubarrayIndex = -1;
        int highSubarrayIndex = -1;
        int maxSubarraySum = 0;
        int currentSumFromMaxSubarrayStart = 0;

        for (int i = 0; i < array.length; i++) {
            if (currentSumFromMaxSubarrayStart <= 0 && array[i] > 0) {
                currentSumFromMaxSubarrayStart = array[i];
            } else {
                currentSumFromMaxSubarrayStart += array[i];
            }
            if (array[i] > 0) {
                if (currentSumFromMaxSubarrayStart > 0) {
                    if (lowSubarrayIndex == -1) {
                        lowSubarrayIndex = i;
                    }
                    highSubarrayIndex = i;
                    maxSubarraySum = currentSumFromMaxSubarrayStart;
                }
            }
        }

        return new int[]{lowSubarrayIndex, highSubarrayIndex, maxSubarraySum};
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(Arrays.toString(findMaximumSubarray(array, 0, array.length - 1)));
        System.out.println(Arrays.toString(findMaximumSubarrayNonRecursively(array)));
    }
}
