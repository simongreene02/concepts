package com.greatworksinc.concepts.searching;

import java.util.ArrayList;
import java.util.List;

public class LowestNumbersSearch {
  public static int findNthLowestNumber(int[] numbers, int n) {
    if (n <= 0 || n > numbers.length) {
      throw new IllegalArgumentException("The value n must range between 1 and the length of the input array (inclusive).");
    }
    List<Integer> smallestNumbers = new ArrayList<>();
    for (int num : numbers) {
      if (smallestNumbers.isEmpty()) {
        smallestNumbers.add(num);
      } else if (smallestNumbers.size() < n || num < smallestNumbers.get(n - 1)) {
        for (int i = smallestNumbers.size() - 1; i > -1; i--) {
          if (num <= smallestNumbers.get(i)) {
            smallestNumbers.add(i, num);
            break;
          }
        }
        while (smallestNumbers.size() > n) {
          smallestNumbers.remove(n);
        }
      }
    }
    return smallestNumbers.get(n - 1);
  }
}
