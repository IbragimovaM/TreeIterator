package com.company;
import java.util.ArrayList;
import java.util.List;

public class Node {

    private int value;
    private Node left;
    private Node right;
    private Node parent;
    private List<TreeIterator> iteratorList;

    public Node(int value) {
        iteratorList = new ArrayList<>();
        this.value = value;
    }

    public Node(int value, Node parent) {
        this(value);
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        left.parent = this;
        invalidateIterators();
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        right.parent = this;
        invalidateIterators();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        invalidateIterators();
    }

    private void invalidateIterators() {
        for (TreeIterator iterator : iteratorList) {
            iterator.invalidate();
        }

        if (parent != null) {
            parent.invalidateIterators();
        }
    }

    void addIterator(TreeIterator iterator) {
        iteratorList.add(iterator);
    }
}