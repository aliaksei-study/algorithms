package com.heap;

public class MaxPriorityQueue extends Heap {
    public MaxPriorityQueue(int[] array) {
        super(array);
        super.buildMaxHeap();
    }

    public int heapMaximum() {
        return super.getArray()[0];
    }

    public int heapExtractMax() {
        int max = heapMaximum();
        super.getArray()[0] = super.getArray()[super.getMaxHeapSize() - 1];
        super.setMaxHeapSize(super.getMaxHeapSize() - 1);
        super.maxHeapify(0);
        return max;
    }

    public void heapIncreaseKey(int index, int updatedValue) {
        super.getArray()[index] = updatedValue;
        while(index > 0 && super.getArray()[super.getParent(index)] < super.getArray()[index]) {
            super.swap(index, super.getParent(index));
            index = super.getParent(index);
        }
    }

    public void maxHeapInsert(int value) {
        super.setMaxHeapSize(super.getMaxHeapSize() + 1);
        super.getArray()[super.getMaxHeapSize() - 1] = value;
        heapIncreaseKey(super.getMaxHeapSize() - 1, value);
    }
}
