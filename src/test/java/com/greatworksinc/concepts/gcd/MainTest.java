package com.greatworksinc.concepts.gcd;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void gcdIterative_negativeA() {
    assertThrows(IllegalArgumentException.class, () -> Main.gcdIterative(-1, 9));
  }

  @Test
  void gcdIterative_negativeB() {
    assertThrows(IllegalArgumentException.class, () -> Main.gcdIterative(9, -1));
  }

  @Test
  void gcdIterative_zeroA() {
    assertThat(Main.gcdIterative(0, 10)).isEqualTo(10);
  }

  @Test
  void gcdIterative_zeroB() {
    assertThat(Main.gcdIterative(10, 0)).isEqualTo(10);
  }

  @Test
  void gcdIterative_zeroes() {
    assertThat(Main.gcdIterative(0, 0)).isEqualTo(0);
  }

  @Test
  void gcdIterative_54and24() {
    assertThat(Main.gcdIterative(54, 24)).isEqualTo(6);
  }

  @Test
  void gcdIterative_bigNumbers() {
    assertThat(Main.gcdIterative(1000000409, 1000000411)).isEqualTo(1);
  }

  @Test
  void gcdEuclidean_negativeA() {
    assertThrows(IllegalArgumentException.class, () -> Main.gcdEuclidean(-1, 9));
  }

  @Test
  void gcdEuclidean_negativeB() {
    assertThrows(IllegalArgumentException.class, () -> Main.gcdEuclidean(9, -1));
  }

  @Test
  void gcdEuclidean_zeroA() {
    assertThat(Main.gcdEuclidean(0, 10)).isEqualTo(10);
  }

  @Test
  void gcdEuclidean_zeroB() {
    assertThat(Main.gcdEuclidean(10, 0)).isEqualTo(10);
  }

  @Test
  void gcdEuclidean_zeroes() {
    assertThat(Main.gcdEuclidean(0, 0)).isEqualTo(0);
  }

  @Test
  void gcdEuclidean_54and24() {
    assertThat(Main.gcdEuclidean(54, 24)).isEqualTo(6);
  }

  @Test
  void gcdEuclidean_bigNumbers() {
    assertThat(Main.gcdEuclidean(1000000409, 1000000411)).isEqualTo(1);
  }
}
