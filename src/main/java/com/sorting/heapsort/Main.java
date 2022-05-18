package com.sorting.heapsort;

import com.heap.Heap;

import java.util.Arrays;

public class Main {

    public static void heapsort(int[] array) {
        Heap heap = new Heap(array);
        heap.buildMaxHeap();

        for(int i = array.length - 1; i > 0; i--) {
            heap.swap(0, i);
            heap.setMaxHeapSize(heap.getMaxHeapSize() - 1);
            heap.maxHeapify(0);
        }
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{15, 8, 2, 4, 10, 11, 18};
        heapsort(testArray);
        System.out.println(Arrays.toString(Arrays.stream(testArray).toArray()));
    }
}
