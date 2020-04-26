package com.greatworksinc.concepts.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class InOrderDFS<T extends Comparable<T>> implements DepthFirstSearch<T> {

  @Override
  public List<T> traverse(Node<T> rootNode) {
    if (rootNode.isLeafNode()) {
      return List.of(rootNode.getValue());
    } else {
      List<T> valuesList = new ArrayList<>();
      if (rootNode.getLeft() != null) {
        valuesList.addAll(traverse(rootNode.getLeft()));
      }
      valuesList.add(rootNode.getValue());
      if (rootNode.getRight() != null) {
        valuesList.addAll(traverse(rootNode.getRight()));
      }
      return valuesList;
    }
  }
}
