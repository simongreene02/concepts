package com.greatworksinc.concepts.measurer;

import com.google.common.collect.ImmutableList;
import com.greatworksinc.concepts.linkedlist.LinkedList;
import java.util.ArrayList;
import java.util.UUID;

public class Initalizer {

  public static ImmutableList<String> createImmutableList(int length) {
    ImmutableList.Builder<String> unbuiltList = new ImmutableList.Builder<String>();
    for (int i = 0; i < length; i++) {
      unbuiltList.add(UUID.randomUUID().toString());
    }
    return unbuiltList.build();
  }

  public static ArrayList<String> cloneArrayList(ImmutableList<String> inputList) {
    ArrayList<String> outputList = new ArrayList<String>();
    for (String element : inputList) {
      outputList.add(element);
    }
    return outputList;
  }

  public static LinkedList cloneLinkedList(ImmutableList<String> inputList) {
    LinkedList outputList = new LinkedList();
    for (String element : inputList) {
      outputList.add(element);
    }
    return outputList;
  }
}
