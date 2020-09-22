package com.greatworksinc.concepts.sorting;

public class MergeSort {
  public static void mergeSort(int[] numbers) {
    int n = numbers.length;

    if (n < 2) {
      return;
    }

    int mid = n / 2;
    int[] left = new int[mid];
    int[] right = new int[n - mid];

    for (int i = 0; i < mid; i++) {
      left[i] = numbers[i];
    }
    for (int i = 0; i < n - mid; i++) {
      right[i] = numbers[mid + i];
    }

    mergeSort(left);
    mergeSort(right);

    merge(numbers, left, right);
  }

  private static void merge(int[] numbers, int[] left, int[] right) {
    if (left.length + right.length != numbers.length) {
      throw new IllegalArgumentException(
          "The left and right arrays must add up to be the same length at the main array.");
    }

    int leftPointer = 0;
    int rightPointer = 0;

    while (leftPointer + rightPointer < numbers.length) {
      if (rightPointer >= right.length
          || (leftPointer < left.length && left[leftPointer] < right[rightPointer])) {
        numbers[leftPointer + rightPointer] = left[leftPointer];
        leftPointer++;
      } else {
        numbers[leftPointer + rightPointer] = right[rightPointer];
        rightPointer++;
      }
    }
  }
}
