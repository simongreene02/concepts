package com.greatworksinc.concepts.towerofhanoi;

import static com.google.common.truth.Truth.assertThat;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class PegTest {

  private Peg peg;

  // TODO: Finish other tests.

  @Before
  public void setUp() {
    peg = new Peg();
  }

  @Test
  public void addDisc_unorderedStack_negative() {
    Disc smallDisc = new Disc(1);
    Disc largeDisc = new Disc(2);
    assertThat(peg.addDisc(smallDisc)).isTrue();
    assertThat(peg.addDisc(largeDisc)).isFalse();
  }

  @Test
  public void addDisc_orderedStack_positive() {
    Disc smallDisc = new Disc(1);
    Disc largeDisc = new Disc(2);
    assertThat(peg.addDisc(largeDisc)).isTrue();
    assertThat(peg.addDisc(smallDisc)).isTrue();
  }

  @Test
  public void addDisc_sameSizes_negative() {
    Disc disc1 = new Disc(1);
    Disc disc2 = new Disc(1);
    assertThat(peg.addDisc(disc1)).isTrue();
    assertThat(peg.addDisc(disc2)).isFalse();
  }

  @Test
  public void removeDisc_empty() {
    assertThat(peg.removeDisc()).isEqualTo(Optional.empty());
  }

  @Test
  public void removeDisc_oneDisc() {
    Disc disc = new Disc(1);
    peg.addDisc(disc);
    assertThat(peg.removeDisc().get()).isEqualTo(disc);
  }

  @Test
  public void removeDisc_twoDiscs() {
    Disc smallDisc = new Disc(1);
    Disc largeDisc = new Disc(2);
    peg.addDisc(largeDisc);
    peg.addDisc(smallDisc);
    assertThat(peg.removeDisc().get()).isEqualTo(smallDisc);
    assertThat(peg.removeDisc().get()).isEqualTo(largeDisc);
  }

  @Test
  public void getSize() {
    Disc smallDisc = new Disc(1);
    Disc largeDisc = new Disc(2);
    assertThat(peg.getSize()).isEqualTo(0);
    peg.addDisc(largeDisc);
    assertThat(peg.getSize()).isEqualTo(1);
    peg.addDisc(smallDisc);
    assertThat(peg.getSize()).isEqualTo(2);
  }
}
