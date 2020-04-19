package com.greatworksinc.concepts.binarysearchtree;

import java.util.List;

public interface DepthFirstSearch<T extends Comparable<T>> {
    List<T> traverse(Node<T> rootNode);
}
