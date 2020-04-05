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
}
