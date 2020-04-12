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

  public Node<T> insertRecursive(T value) {
    if (rootNode == null) {
      rootNode = new Node<T>(value);
      return rootNode;
    }
    return insertRecursion(value, rootNode);
  }

  //  private Node insertRec(Node root, int key) {
  //    if (root == null) {
  //      root = new Node(key);
  //      return root;
  //    }
  //    if (key < root.key) {
  //      root.left = insertRec(root.left, key);
  //    } else if (key > root.key) {
  //      root.right = insertRec(root.right, key);
  //    }
  //    return root;
  //  }

  private Node<T> insertRecursion(T value, Node<T> node) {
    if (node == null) {
      return new Node<T>(value);
    }
    int valueComparison = value.compareTo(node.getValue());
    if (valueComparison < 0) {
      node.setLeft(insertRecursion(value, node.getLeft()));
    } else if (valueComparison > 0) {
      node.setRight(insertRecursion(value, node.getRight()));
    }
    return node;
  }

  public Node<T> getRootNode() {
    return rootNode;
  }
}
