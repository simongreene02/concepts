package com.greatworksinc.concepts.sorting;


import com.google.common.annotations.VisibleForTesting;

public class QuickSort {
    public static void sort(int[] data) {
        if (data.length > 1) {
            quickSort(data, 0, data.length - 1);
        }
    }

    @VisibleForTesting
    static void quickSort(int[] data, int startIdx, int endIdx) {
        int partitionIdx = partition(data, startIdx, endIdx);
        if (startIdx < partitionIdx - 1) {
            quickSort(data, startIdx, partitionIdx - 1);
        }
        if (endIdx > partitionIdx + 1) {
            quickSort(data, partitionIdx + 1, endIdx);
        }
    }

    /**
     * @return position of the pivot location
     */
    @VisibleForTesting
    static int partition(int[] data, int startIdx, int endIdx) {
        int pivot = data[endIdx];
        int partitionIdx = startIdx;
        for (int i = startIdx; i < endIdx; i++) {
            if (data[i] < pivot) {
                swap(data, i, partitionIdx);
                partitionIdx++;
            }
        }
        swap(data, endIdx, partitionIdx);
        return partitionIdx;
    }

    @VisibleForTesting
    static void swap(int[] data, int fromIdx, int toIdx) {
        int temp = data[fromIdx];
        data[fromIdx] = data[toIdx];
        data[toIdx] = temp;
    }
}
