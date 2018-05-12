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
    @Test
    public void getAt_positiveCase() {
        list.addAt("blank", 0);
        assertThat(list.getAt(0)).isEqualTo("blank");
    }
    @Test
    public void getAt_positiveCase_twoItems() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        assertThat(list.getAt(1)).isEqualTo("two");
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void getAt_indexTooLow() {
        list.getAt(-1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void getAt_indexTooHigh() {
        list.getAt(1);
    }
    @Test
    public void getEnd() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        list.addAt("three", 2);
        assertThat(list.getEnd()).isEqualTo("three");
    }
    @Test
    public void getFront() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        list.addAt("three", 2);
        assertThat(list.getFront()).isEqualTo("one");
    }
    @Test
    public void getFront_empty() {
        assertThat(list.getFront()).isNull();
    }
    @Test
    public void delete_positiveCase() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        list.addAt("three", 2);
        list.delete(1);
        assertThat(list.getFront()).isEqualTo("one");
        assertThat(list.getEnd()).isEqualTo("three");
        assertThat(list.getSize()).isEqualTo(2);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void delete_indexTooLow() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        list.addAt("three", 2);
        list.delete(-1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void delete_indexTooHigh() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        list.addAt("three", 2);
        list.delete(3);
    }
    @Test
    public void deleteAll() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        list.addAt("three", 2);
        list.deleteAll();
        assertThat(list.isEmpty()).isTrue();
    }
    @Test
    public void contains_positiveCase() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        list.addAt("three", 2);
        assertThat(list.contains("one")).isTrue();
    }
    @Test
    public void contains_negativeCase() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        list.addAt("three", 2);
        assertThat(list.contains("four")).isFalse();
    }
    @Test
    public void getSize() {
        list.addAt("one", 0);
        list.addAt("two", 1);
        list.addAt("three", 2);
        assertThat(list.getSize()).isEqualTo(3);
    }
    @Test
    public void isEmpty() {
        assertThat(list.isEmpty()).isTrue();
    }
    @Test
    public void isEmpty_false() {
        list.addAt("blank", 0);
        assertThat(list.isEmpty()).isFalse();
    }
}