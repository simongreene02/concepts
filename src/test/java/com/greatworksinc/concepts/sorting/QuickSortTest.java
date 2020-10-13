package com.greatworksinc.concepts.sorting;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void sort() {
        int[] data = {4, 5, 2, 1, 3};
        QuickSort.sort(data);
        assertThat(data).asList().containsExactly(1, 2, 3, 4, 5).inOrder();
    }

    @Test
    void sort_2items() {
        int[] data = {8, 7};
        QuickSort.sort(data);
        assertThat(data).asList().containsExactly(7, 8).inOrder();
    }

    @Test
    void sort_empty() {
        int[] data = {};
        QuickSort.sort(data);
        assertThat(data).isEmpty();
    }

    @Test
    void partition() {
        int[] data = {5, 6, 1, 0, 8, 2, 4};
        int partitionIdx = QuickSort.partition(data, 0, 6);
        assertThat(partitionIdx).isEqualTo(3);
    }

    @Test
    void swap() {
        int[] data = {5, 6};
        QuickSort.swap(data, 0, 1);
        assertThat(data).asList().containsExactly(6, 5).inOrder();
    }
}
