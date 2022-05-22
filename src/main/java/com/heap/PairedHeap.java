package com.heap;

public class PairedHeap {
    private Pair[] array;
    private int maxHeapSize;

    public PairedHeap(Pair[] array) {
        this.array = array;
    }

    public Pair[] getArray() {
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


    public void minHeapify(int index) {
        int smallestElementIndex = index;
        int leftChildIndex = getLeftChild(index);
        int rightChildIndex = getRightChild(index);

        if (leftChildIndex < maxHeapSize && array[leftChildIndex].value < array[index].value) {
            smallestElementIndex = leftChildIndex;
        }

        if (rightChildIndex < maxHeapSize && array[rightChildIndex].value < array[index].value
                && array[rightChildIndex].value < array[leftChildIndex].value) {
            smallestElementIndex = rightChildIndex;
        }

        if (smallestElementIndex != index) {
            swap(index, smallestElementIndex);
            minHeapify(smallestElementIndex);
        }
    }

    public void buildMinHeap() {
        this.maxHeapSize = this.array.length;
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public void swap(int sourceIndex, int destinationIndex) {
        Pair temp = array[sourceIndex];
        array[sourceIndex] = array[destinationIndex];
        array[destinationIndex] = temp;
    }
}
