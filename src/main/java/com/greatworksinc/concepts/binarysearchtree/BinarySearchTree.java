package com.greatworksinc.concepts.binarysearchtree;

public class BinarySearchTree<T extends Comparable> {
  private Node<T> rootNode;

  public Node<T> insert(T value) {
    if (value == null) {
      throw new IllegalArgumentException("Value cannot be null.");
    }

    Node<T> node = new Node<T>(value);
    if (rootNode == null) {
      rootNode = node;
      return node;
    }

    Node<T> targetNode = rootNode;
    while (true) {
      if (targetNode.getValue().equals(value)) {
        return targetNode;
      }
      int valueComparison = value.compareTo(targetNode.getValue());
      if (valueComparison < 0) {
        if (targetNode.getLeft() == null) {
          targetNode.setLeft(node);
          return node;
        } else {
          targetNode = targetNode.getLeft();
        }
      }
      if (valueComparison > 0) {
        if (targetNode.getRight() == null) {
          targetNode.setRight(node);
          return node;
        } else {
          targetNode = targetNode.getRight();
        }
      }
    }
  }
}
