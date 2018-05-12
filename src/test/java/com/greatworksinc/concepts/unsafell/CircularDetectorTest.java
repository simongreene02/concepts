package com.greatworksinc.concepts.unsafell;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class CircularDetectorTest {
    @Test
    public void isCircular_nullCase() {
        assertThat(CircularDetector.isCircular(null)).isFalse();
    }
    @Test
    public void isCircular_oneCase() {
        assertThat(CircularDetector.isCircular(new UnSafeNode("one", null))).isFalse();
    }
    @Test
    public void isCircular_oneCaseCircular() {
        UnSafeNode node = new UnSafeNode("one", null);
        node.setNextItem(node);
        assertThat(CircularDetector.isCircular(node)).isTrue();
    }
    @Test
    public void isCircular_twoCase() {
        assertThat(CircularDetector.isCircular(new UnSafeNode("one", new UnSafeNode("two", null)))).isFalse();
    }
    @Test
    public void isCircular_twoCaseCircular() {
        UnSafeNode node1 = new UnSafeNode("one", null);
        UnSafeNode node2 = new UnSafeNode("two", null);
        node1.setNextItem(node2);
        node2.setNextItem(node1);
        assertThat(CircularDetector.isCircular(node1)).isTrue();
    }

}