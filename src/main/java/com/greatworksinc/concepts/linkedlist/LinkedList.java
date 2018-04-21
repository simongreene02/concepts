package com.greatworksinc.concepts.linkedlist;

import javax.annotation.Nullable;

public class LinkedList {
    
    private Node root;

    public LinkedList(String content) {
        root = new Node(content, null);
    }


    public void addAt(String content, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index (%d) must be zero or greater.", index));
        }

    }

    public @Nullable Node getEnd() {
        Node node = root;
        while (node.getNextItem() != null) {
            node = node.getNextItem();
        }
        return node;
    }
    public @Nullable Node getFront() {
        return root;
    }
    // IsCircular
    // Delete (Node)
    public void deleteAll() {
        root = null;
    }
    // FindDuplicates
    // Contains (str)
}
