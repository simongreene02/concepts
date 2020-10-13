package com.greatworksinc.concepts.searching;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LowestNumbersSearchTest {
  @ParameterizedTest
  @MethodSource
  void sort(int[] data, int n, int expectedValue) {
    assertThat(LowestNumbersSearch.findNthLowestNumber(data, n)).isEqualTo(expectedValue);
  }

  private static Stream<Arguments> sort() {
    return Stream.of(
        Arguments.of(new int[] {4, 5, 2, 1, 3}, 1, 1),
        Arguments.of(new int[] {7, 2, 3}, 1, 2),
        Arguments.of(new int[] {100}, 1, 100));
  }

    @ParameterizedTest
    @MethodSource
    void sort_invalidInput_error(int[] data, int n) {
        assertThrows(IllegalArgumentException.class, () -> LowestNumbersSearch.findNthLowestNumber(data, n));
    }

    private static Stream<Arguments> sort_invalidInput_error() {
        return Stream.of(
                Arguments.of(new int[] {4, 5, 2, 1, 3}, 0),
                Arguments.of(new int[] {7, 2, 3}, -1),
                Arguments.of(new int[] {100}, 2));
    }
}
