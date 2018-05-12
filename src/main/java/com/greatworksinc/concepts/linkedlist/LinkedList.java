package com.greatworksinc.concepts.linkedlist;

import com.google.common.base.Preconditions;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class LinkedList {

    private Node root;
    private int size;

    public void addAt(String content, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index (%d) must be zero or greater.", index));
        }
        if (index > size) {
            throw new IndexOutOfBoundsException(String.format("Index (%d) must be less than or equal to size (%d).", index, size));
        }
        size++;
        if (index == 0) {
            root = new Node(content, root);
            return;
        }
        Node selectedNode = root;
        for (int i = 1; i < index; i++) {
            selectedNode = selectedNode.getNextItem();
        }
        selectedNode.setNextItem(new Node(content, selectedNode.getNextItem()));
    }

    public String getAt(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index (%d) must be zero or greater.", index));
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index (%d) must be less than or equal to size (%d).", index, size));
        }
        Node selected = root;
        while (index > 0) {
            selected = selected.getNextItem();
            index--;
        }
        return selected.getContent();
    }

    public @Nullable String getEnd() {
        if (isCircular()) {return null;}
        Node node = root;
        while (node.getNextItem() != null) {
            node = node.getNextItem();
        }
        return node.getContent();
    }
    public @Nullable String getFront() {
        if (root == null) {
            return null;
        }
        return root.getContent();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isCircular() {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node selectedNode = root;
        while (true) {
            nodes.add(selectedNode);
            selectedNode = selectedNode.getNextItem();
            if (selectedNode.getNextItem() == null) {
                return false;
            }
            if (nodes.contains(selectedNode.getNextItem())) {
                return true;
            }
        }
    }
    public void delete(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index (%d) must be zero or greater.", index));
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index (%d) must be less than or equal to size (%d).", index, size));
        }
        size--;
        if (index == 0) {
            root = root.getNextItem();
            return;
        }
        Node selectedNode = root;
        for (int i = 1; i < index; i++) {
            selectedNode = selectedNode.getNextItem();
        }
        selectedNode.setNextItem(selectedNode.getNextItem().getNextItem());
    }
    public void deleteAll() {
        root = null;
        size = 0;
    }
    // FindDuplicates
    public boolean contains(String str) {
        Node node = root;
        while (node.getNextItem() != null && !node.getContent().equals(str)) {
            node = node.getNextItem();
        }
        return node.getContent().equals(str);
    }
    public int getSize() {
        return size;
    }

    private static class Node {
        private String content;
        private @Nullable
        Node nextItem;

        public Node(String content, @Nullable Node nextItem) {
            this.content = Preconditions.checkNotNull(content);
            this.nextItem = nextItem;
        }

        public String getContent() {
            return content;
        }

        public Node getNextItem() {
            return nextItem;
        }

        public void setNextItem(@Nullable Node nextItem) {
            this.nextItem = nextItem;
        }
    }



}
