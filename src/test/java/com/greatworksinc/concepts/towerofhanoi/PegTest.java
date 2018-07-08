package com.greatworksinc.concepts.towerofhanoi;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class PegTest {

    private Peg peg;

    //TODO: Finish other tests.

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
    public void removeDisc() {
    }

    @Test
    public void getSize() {
    }
}