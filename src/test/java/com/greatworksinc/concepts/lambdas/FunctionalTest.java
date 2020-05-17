package com.greatworksinc.concepts.lambdas;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FunctionalTest {

  @ParameterizedTest
  @MethodSource("arguments")
  void exampleMethod(List<String> values, List<String> expectedOutput) {
    // assertThat(Example.exampleMethod(values)).containsExactlyElementsIn(expectedOutput);
  }

  private static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.arguments(
            List.of("Apple", "Banana", "Cherry", "Dates", "Elderberry", "Fig"),
            List.of("APPLE", "DATES")),
        Arguments.arguments(
            List.of("Apple", "Banana", "Cherry", "Dates", "Elderberry", "Fig", "Grapefruit"),
            List.of("APPLE", "DATES", "GRAPEFRUIT")),
        Arguments.arguments(List.of("Banana", "Cherry", "Elderberry", "Fig"), List.of()));
  }
}
