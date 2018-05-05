package com.greatworksinc.concepts.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class LinkedListTest {
    private LinkedList list;
    @Before
    public void setUp() {
        list = new LinkedList();
    }
    @Test
    public void addAt_positiveCase() {
        list.addAt("blank", 0);
        assertThat(list.getSize()).isEqualTo(1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void addAt_indexTooLow() {
        list.addAt("blank", -1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void addAt_indexTooHigh() {
        list.addAt("blank", 1);
    }
}