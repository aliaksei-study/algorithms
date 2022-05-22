package com.heap;

public class MinPriorityQueue extends PairedHeap {
    public MinPriorityQueue(Pair[] array) {
        super(array);
        super.buildMinHeap();
    }

    public Pair heapMinimum() {
        return super.getArray()[0];
    }

    public Pair heapExtractMin() {
        Pair min = heapMinimum();
        super.getArray()[0] = super.getArray()[super.getMaxHeapSize() - 1];
        super.setMaxHeapSize(super.getMaxHeapSize() - 1);
        super.minHeapify(0);
        return min;
    }

    public void heapIncreaseKey(int index, Pair updatedPair) {
        super.getArray()[index] = updatedPair;
        while(index > 0 && super.getArray()[super.getParent(index)].value > super.getArray()[index].value) {
            super.swap(index, super.getParent(index));
            index = super.getParent(index);
        }
    }

    public boolean isEmpty() {
        return super.getMaxHeapSize() == 0;
    }

    public void minHeapInsert(Pair pair) {
        super.setMaxHeapSize(super.getMaxHeapSize() + 1);
        super.getArray()[super.getMaxHeapSize() - 1] = pair;
        heapIncreaseKey(super.getMaxHeapSize() - 1, pair);
    }
}
