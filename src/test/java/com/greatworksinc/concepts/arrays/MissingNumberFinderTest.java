package com.greatworksinc.concepts.arrays;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MissingNumberFinderTest {

  @ParameterizedTest
  @MethodSource("singleArguments")
  void findMissingNumber(List<Integer> numbers, int expectedValue) {
    assertThat(MissingNumberFinder.findMissingNumber(numbers)).isEqualTo(expectedValue);
  }

  @ParameterizedTest
  @MethodSource("singleArguments")
  void findMissingNumbers_singleArguments(List<Integer> numbers, int expectedValue) {
    assertThat(MissingNumberFinder.findMissingNumbers(numbers)).containsExactly(expectedValue);
  }

  private static Stream<Arguments> singleArguments() {
    return Stream.of(
        Arguments.arguments(List.of(1, 2, 2, 4, 5), 3),
        Arguments.arguments(List.of(1, 2, 3, 3, 4), 5),
        Arguments.arguments(List.of(2, 3, 4, 4, 5), 1));
  }

  @ParameterizedTest
  @MethodSource("multipleArguments")
  void findMissingNumbers_multipleArguments(List<Integer> numbers, List<Integer> expectedValues) {
    assertThat(MissingNumberFinder.findMissingNumbers(numbers))
        .containsExactlyElementsIn(expectedValues);
  }

  private static Stream<Arguments> multipleArguments() {
    return Stream.of(
        Arguments.arguments(List.of(4, 4, 5, 5, 5), List.of(1, 2, 3)),
        Arguments.arguments(List.of(1, 1, 2, 3, 3), List.of(4, 5)),
        Arguments.arguments(List.of(6, 6, 6, 6, 6, 6), List.of(1, 2, 3, 4, 5)));
  }
}
