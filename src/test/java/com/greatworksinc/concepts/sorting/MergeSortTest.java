package com.greatworksinc.concepts.sorting;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class MergeSortTest {
  @Test
  void mergeSort() {
    int[] numbers = {7, 9, 4, 3, 1, 2, 2, 8, 6, 10};
    MergeSort.mergeSort(numbers);
    assertThat(numbers).asList().containsExactly(1, 2, 2, 3, 4, 6, 7, 8, 9, 10).inOrder();
  }
}
