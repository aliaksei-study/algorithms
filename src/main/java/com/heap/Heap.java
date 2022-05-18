package com.heap;

public class Heap {
    private int[] array;
    private int maxHeapSize;

    public Heap(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public int getMaxHeapSize() {
        return maxHeapSize;
    }

    public void setMaxHeapSize(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
    }

    public int getParent(int index) {
        return index / 2;
    }

    public int getLeftChild(int index) {
        return 2 * index + 1;
    }

    public int getRightChild(int index) {
        return 2 * index + 2;
    }

    public void maxHeapify(int index) {
        int largestElementIndex = index;
        int leftChildIndex = getLeftChild(index);
        int rightChildIndex = getRightChild(index);

        if (leftChildIndex < maxHeapSize && array[leftChildIndex] > array[index]) {
            largestElementIndex = leftChildIndex;
        }

        if (rightChildIndex < maxHeapSize && array[rightChildIndex] > array[index]
                && array[rightChildIndex] > array[leftChildIndex]) {
            largestElementIndex = rightChildIndex;
        }

        if (largestElementIndex != index) {
            swap(index, largestElementIndex);
            maxHeapify(largestElementIndex);
        }
    }

    public void swap(int sourceIndex, int destinationIndex) {
        int temp = array[sourceIndex];
        array[sourceIndex] = array[destinationIndex];
        array[destinationIndex] = temp;
    }

    public void buildMaxHeap() {
        this.maxHeapSize = this.array.length;
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }
}
