package com.greatworksinc.concepts.towerofhanoi;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DiscTest {

  private Disc disc;

  @Before
  public void setUp() {
    disc = new Disc(3);
  }

  @Test
  public void getSize() {
    assertThat(disc.getSize()).isEqualTo(3);
  }

  @Test
  public void isBigger_negative_smallerThan() {
    assertThat(disc.isBiggerThan(new Disc(4))).isFalse();
  }

  @Test
  public void isBigger_positive_equalTo() {
    assertThat(disc.isBiggerThan(new Disc(3))).isFalse();
  }

  @Test
  public void isBigger_negative_biggerThan() {
    assertThat(disc.isBiggerThan(new Disc(2))).isTrue();
  }
}
