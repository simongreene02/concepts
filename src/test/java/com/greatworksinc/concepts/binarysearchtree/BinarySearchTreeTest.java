package com.greatworksinc.concepts.binarysearchtree;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
  private BinarySearchTree<Integer> bst;

  @BeforeEach
  void setUp() {
    bst = new BinarySearchTree<>();
  }

  @Test
  void insert() {
    Node<Integer> node = bst.insert(0);
    assertThat(node.getValue()).isEqualTo(0);
    assertThat(node.getLeft()).isNull();
    assertThat(node.getRight()).isNull();
  }

  @Test
  void insert_twoItems_symmetrical() {
    Node<Integer> nodeZero = bst.insert(0);
    Node<Integer> nodeNegative = bst.insert(-1);
    Node<Integer> nodePositive = bst.insert(1);
    assertThat(nodeZero.getLeft()).isEqualTo(nodeNegative);
    assertThat(nodeZero.getRight()).isEqualTo(nodePositive);
    assertThat(nodeNegative.getLeft()).isNull();
    assertThat(nodeNegative.getRight()).isNull();
    assertThat(nodePositive.getLeft()).isNull();
    assertThat(nodePositive.getRight()).isNull();
  }

  @Test
  void insert_twoItems_asymmetrical() {
    Node<Integer> nodeZero = bst.insert(0);
    Node<Integer> nodeTwo = bst.insert(2);
    Node<Integer> nodeOne = bst.insert(1);
    assertThat(nodeZero.getLeft()).isNull();
    assertThat(nodeZero.getRight()).isEqualTo(nodeTwo);
    assertThat(nodeTwo.getLeft()).isEqualTo(nodeOne);
    assertThat(nodeTwo.getRight()).isNull();
    assertThat(nodeOne.getLeft()).isNull();
    assertThat(nodeOne.getRight()).isNull();
  }

  @Test
  void insertRecursive() {
    Node<Integer> node = bst.insertRecursive(0);
    assertThat(node.getValue()).isEqualTo(0);
    assertThat(node.getLeft()).isNull();
    assertThat(node.getRight()).isNull();
  }

  @Test
  void insertRecursive_twoItems_symmetrical() {
    Node<Integer> nodeZero = bst.insertRecursive(0);
    Node<Integer> nodeNegative = bst.insertRecursive(-1);
    Node<Integer> nodePositive = bst.insertRecursive(1);
    assertThat(nodeZero.getLeft()).isEqualTo(nodeNegative);
    assertThat(nodeZero.getRight()).isEqualTo(nodePositive);
    assertThat(nodeNegative.getLeft()).isNull();
    assertThat(nodeNegative.getRight()).isNull();
    assertThat(nodePositive.getLeft()).isNull();
    assertThat(nodePositive.getRight()).isNull();
  }

  /*

       0
      /. \
     ^    2
         / \
        1.  ^

  */

  @Test
  void insertRecursive_twoItems_asymmetrical() {
    bst.insertRecursive(0);
    bst.insertRecursive(2);
    bst.insertRecursive(1);
    Node<Integer> rootNode = bst.getRootNode();
    assertThat(rootNode.getValue()).isEqualTo(0);
    assertThat(rootNode.getLeft()).isNull();
    assertThat(rootNode.getRight().getValue()).isEqualTo(2);
    assertThat(rootNode.getRight().getLeft().getValue()).isEqualTo(1);
    assertThat(rootNode.getRight().getRight()).isNull();
    assertThat(rootNode.getRight().getLeft().getLeft()).isNull();
    assertThat(rootNode.getRight().getLeft().getRight()).isNull();
  }
}
