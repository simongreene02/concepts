package com.greatworksinc.concepts.linkedlist;

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

    public @Nullable Node getEnd() {
        if (isCircular()) {return null;}
        Node node = root;
        while (node.getNextItem() != null) {
            node = node.getNextItem();
        }
        return node;
    }
    public @Nullable Node getFront() {
        return root;
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
    public void delete(Node targetNode) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node selectedNode = root;
        while (selectedNode.getNextItem() != null && selectedNode.getNextItem() != targetNode) {
            nodes.add(selectedNode);
            selectedNode = selectedNode.getNextItem();
            if (nodes.contains(selectedNode.getNextItem())) {
                return;
            }
        }
        selectedNode.setNextItem(null);

    }
    public void deleteAll() {
        root = null;
    }
    // FindDuplicates
    public boolean contains(String str) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node selectedNode = root;
        while (selectedNode.getNextItem() != null) {
            nodes.add(selectedNode);
            selectedNode = selectedNode.getNextItem();
            if (selectedNode.getContent().equals(str)) {
                return true;
            }
            if (nodes.contains(selectedNode.getNextItem())) {
                return false;
            }
        }
        return false;
    }
    public int getSize() {
        return size;
    }
}
