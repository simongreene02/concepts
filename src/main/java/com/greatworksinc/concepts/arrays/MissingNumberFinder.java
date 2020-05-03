package com.greatworksinc.concepts.arrays;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class MissingNumberFinder {
  /*
  Approach 1:
  * Create "full" array, containing all values from 1 to N.
  * The value of N can be discovered by finding the length of the input array, and adding one.
  * Iterating through the input array, every value in the input array will be removed from the full array.
  * The only value left in the full array is the missing value.
   */
  public static int findMissingNumber(List<Integer> numbers) {
    ArrayList<Integer> fullValues = new ArrayList<>();
    for (int i = 1; i <= numbers.size() + 1; i++) {
      fullValues.add(i);
    }
    fullValues.removeAll(numbers);
    return fullValues.get(0);
  }

  /**
   * Approach 2: Finds any positive integers missing from a list.
   *
   * <ul>
   *   <li>The list must contain only positive integers.
   *   <li>The array may contain duplicates.
   *   <li>No value may be greater than the array length.
   * </ul>
   *
   * @param numbers The input list
   * @return {@link List} of missing numbers
   */
  public static List<Integer> findMissingNumbers(List<Integer> numbers) {
    BitSet bits = new BitSet();
    for (int number : numbers) {
      bits.set(number - 1, true);
    }
    List<Integer> missingNumbers = new ArrayList<>();
    for (int i = 0; i < numbers.size(); i++) {
      if (!bits.get(i)) {
        missingNumbers.add(i + 1);
      }
    }
    return missingNumbers;
  }
}
