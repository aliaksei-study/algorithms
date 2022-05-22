package com.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static List<Integer> mergeKSortedArrays(List<LinkedList<Integer>> arrays) {
        int k = arrays.size();

        Pair[] firstElementsPairs = new Pair[k];

        for(int i = 0; i < k; i++) {
            firstElementsPairs[i] = new Pair(arrays.get(i).getFirst(), i);
            arrays.get(i).removeFirst();
        }

        MinPriorityQueue queue = new MinPriorityQueue(firstElementsPairs);
        List<Integer> mergedLists = new ArrayList<>();

        while(!queue.isEmpty()) {
            Pair pair = queue.heapExtractMin();
            mergedLists.add(pair.value);
            if(arrays.get(pair.arrayIndex).size() > 0) {
                queue.minHeapInsert(new Pair(arrays.get(pair.arrayIndex).getFirst(), pair.arrayIndex));
                arrays.get(pair.arrayIndex).removeFirst();
            }
        }

        return mergedLists;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{15, 8, 2, 4, 10, 11, 18};
        MaxPriorityQueue priorityQueue = new MaxPriorityQueue(testArray);
        System.out.println(Arrays.toString(Arrays.stream(testArray).toArray()));
        System.out.println(priorityQueue.heapExtractMax());
        System.out.println(Arrays.toString(Arrays.stream(testArray).toArray()));

        priorityQueue.maxHeapInsert(20);
        priorityQueue.maxHeapDelete(3);
        System.out.println(Arrays.toString(Arrays.stream(testArray).toArray()));

        List<LinkedList<Integer>> arrays = new ArrayList<>();
        arrays.add(new LinkedList<>(Arrays.asList(1, 5, 9, 11)));
        arrays.add(new LinkedList<>(Arrays.asList(0, 2, 6)));
        arrays.add(new LinkedList<>(Arrays.asList(3, 7, 8, 20)));
        arrays.add(new LinkedList<>(List.of(4)));
        System.out.println(Arrays.toString(mergeKSortedArrays(arrays).toArray()));
    }
}
