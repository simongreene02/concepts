package com.greatworksinc.concepts.linkedlist;

import com.google.common.base.Preconditions;

import javax.annotation.Nullable;
import java.util.*;

public class LinkedList extends AbstractList<String> {

    private Node root;
    private int size;

    @Override
    public void add(int index, String content) {
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

    @Override
    public String get(int index) {
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

    @Override
    public String remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index (%d) must be zero or greater.", index));
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index (%d) must be less than or equal to size (%d).", index, size));
        }
        size--;
        String removedValue;
        if (index == 0) {
            removedValue = root.getContent();
            root = root.getNextItem();
            return removedValue;
        }
        Node selectedNode = root;
        for (int i = 1; i < index; i++) {
            selectedNode = selectedNode.getNextItem();
        }
        Node itemToDelete = selectedNode.getNextItem();
        removedValue = itemToDelete.getContent();
        selectedNode.setNextItem(itemToDelete.getNextItem());
        return removedValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            throw new NullPointerException("Object must not be null.");
        }
        if (!(o instanceof String)) {
            throw new ClassCastException("Object must be a String.");
        }
        int index = 0;
        Node node = root;
        while (node.getNextItem() != null && !node.getContent().equals(o)) {
            node = node.getNextItem();
            index++;
        }
        if (!node.getContent().equals(o)) {
            return -1;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException("Object must not be null.");
        }
        if (!(o instanceof String)) {
            throw new ClassCastException("Object must be a String.");
        }
        Node node = root;
        while (node.getNextItem() != null && !node.getContent().equals(o)) {
            node = node.getNextItem();
        }
        return node.getContent().equals(o);
    }

    @Override
    public int size() {
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

        public void setContent(String newValue) {
            content = newValue;
        }

        public Node getNextItem() {
            return nextItem;
        }

        public void setNextItem(@Nullable Node nextItem) {
            this.nextItem = nextItem;
        }
    }



}
