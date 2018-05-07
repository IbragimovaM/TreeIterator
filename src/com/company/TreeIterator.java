package com.company;

import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Queue;

public class TreeIterator implements Iterator<Integer> {
    private Queue<Integer> nodes;
    private boolean valid = true;

    public TreeIterator(Node root) {
        root.addIterator(this);

        nodes = new ArrayDeque<>();
        Queue<Node> traversal = new ArrayDeque<>();
        traversal.offer(root);

        while (!traversal.isEmpty()) {
            Node cur = traversal.poll();
            nodes.offer(cur.getValue());

            if (cur.getLeft() != null) {
                traversal.offer(cur.getLeft());
            }

            if (cur.getRight() != null) {
                traversal.offer(cur.getRight());
            }
        }
    }

    public void invalidate() {
        valid = false;
    }

    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public Integer next() {
        if (!valid) {
            throw new ConcurrentModificationException();
        }

        if (nodes.isEmpty()) {
            return null;
        }

        return nodes.poll();
    }
}