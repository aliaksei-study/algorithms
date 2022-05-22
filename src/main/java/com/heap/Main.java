package com.heap;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] testArray = new int[]{15, 8, 2, 4, 10, 11, 18};
        MaxPriorityQueue priorityQueue = new MaxPriorityQueue(testArray);
        System.out.println(Arrays.toString(Arrays.stream(testArray).toArray()));
        System.out.println(priorityQueue.heapExtractMax());
        System.out.println(Arrays.toString(Arrays.stream(testArray).toArray()));

        priorityQueue.maxHeapInsert(20);
        priorityQueue.maxHeapDelete(3);
        System.out.println(Arrays.toString(Arrays.stream(testArray).toArray()));
    }
}
