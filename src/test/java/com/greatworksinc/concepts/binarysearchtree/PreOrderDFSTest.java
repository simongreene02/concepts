package com.greatworksinc.concepts.binarysearchtree;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreOrderDFSTest {
  private DepthFirstSearch<Integer> depthFirstSearch;

  @BeforeEach
  void setUp() {
    depthFirstSearch = new PreOrderDFS<>();
  }

  @Test
  void traverse_3nodes() {
    Node<Integer> rootNode = new Node<>(1);
    Node<Integer> leftNode = new Node<>(2);
    Node<Integer> rightNode = new Node<>(3);
    rootNode.setLeft(leftNode);
    rootNode.setRight(rightNode);
    assertThat(depthFirstSearch.traverse(rootNode)).containsExactly(1, 2, 3).inOrder();
  }

  @Test
  void traverse_7nodes() {
    Node<Integer> rootNode = createNode(1);
    Node<Integer> twoNode = createNode(2);
    Node<Integer> threeNode = createNode(3);
    Node<Integer> fourNode = createNode(4);
    Node<Integer> fiveNode = createNode(5);
    Node<Integer> sixNode = createNode(6);
    Node<Integer> sevenNode = createNode(7);
    setChildren(rootNode, twoNode, threeNode);
    setChildren(twoNode, fourNode, fiveNode);
    setChildren(threeNode, sixNode, sevenNode);
    assertThat(depthFirstSearch.traverse(rootNode)).containsExactly(1, 2, 4, 5, 3, 6, 7).inOrder();
  }

  private static Node<Integer> createNode(int number) {
    return new Node<>(number);
  }

  private static void setChildren(
      Node<Integer> rootNode, Node<Integer> leftNode, Node<Integer> rightNode) {
    rootNode.setLeft(leftNode);
    rootNode.setRight(rightNode);
  }
}
