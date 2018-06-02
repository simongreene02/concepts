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
        list.add(0, "blank");
        assertThat(list.size()).isEqualTo(1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void addAt_indexTooLow() {
        list.add(-1, "blank");
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void addAt_indexTooHigh() {
        list.add(1, "blank");
    }
    @Test
    public void getAt_positiveCase() {
        list.add(0, "blank");
        assertThat(list.get(0)).isEqualTo("blank");
    }
    @Test
    public void getAt_positiveCase_twoItems() {
        list.add(0, "one");
        list.add(1, "two");
        assertThat(list.get(1)).isEqualTo("two");
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void getAt_indexTooLow() {
        list.get(-1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void getAt_indexTooHigh() {
        list.get(1);
    }
//    @Test
//    public void getEnd() {
//        list.add("one", 0);
//        list.add("two", 1);
//        list.add("three", 2);
//        assertThat(list.getEnd()).isEqualTo("three");
//    }
//    @Test
//    public void getFront() {
//        list.add("one", 0);
//        list.add("two", 1);
//        list.add("three", 2);
//        assertThat(list.getFront()).isEqualTo("one");
//    }
//    @Test
//    public void getFront_empty() {
//        assertThat(list.getFront()).isNull();
//    }
    @Test
    public void delete_positiveCase() {
        list.add(0, "one");
        list.add(1, "two");
        list.add(2, "three");
        list.remove(1);
        assertThat(list.get(0)).isEqualTo("one");
        assertThat(list.get(1)).isEqualTo("three");
        assertThat(list.size()).isEqualTo(2);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void delete_indexTooLow() {
        list.add(0, "one");
        list.add(1, "two");
        list.add(2, "three");
        list.remove(-1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void delete_indexTooHigh() {
        list.add(0, "one");
        list.add(1, "two");
        list.add(2, "three");
        list.remove(3);
    }
    @Test
    public void deleteAll() {
        list.add(0, "one");
        list.add(1, "two");
        list.add(2, "three");
        list.clear();
        assertThat(list.isEmpty()).isTrue();
    }
    @Test
    public void contains_positiveCase() {
        list.add(0, "one");
        list.add(1, "two");
        list.add(2, "three");
        assertThat(list.contains("one")).isTrue();
    }
    @Test
    public void contains_negativeCase() {
        list.add(0, "one");
        list.add(1, "two");
        list.add(2, "three");
        assertThat(list.contains("four")).isFalse();
    }
    @Test
    public void getSize() {
        list.add(0, "one");
        list.add(1, "two");
        list.add(2, "three");
        assertThat(list.size()).isEqualTo(3);
    }
    @Test
    public void isEmpty() {
        assertThat(list.isEmpty()).isTrue();
    }
    @Test
    public void isEmpty_false() {
        list.add(0, "blank");
        assertThat(list.isEmpty()).isFalse();
    }
}