package org.sopt.tree.tree.impl;

import org.sopt.tree.tree.base.Element;
import org.sopt.tree.tree.base.Header;
import org.sopt.tree.tree.base.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    Node root = new Node();

    public void insert(Element e) {

        Node node = root.findNodeToInsert(e);
        node.insert(e);

        if (node.overflow())
            node.cleanOverflow();
    }

    public void delete(Element e) {

        Node node = root.findNodeToDelete(e);

        if (node == null)
            throw new NullPointerException();

        if (!node.leaf())
            node = node.exchangeWithLeafElement(e);

        node.delete(e);

        if (node.underflow())
            node.cleanUnderflow();
    }

    public Element search(int key) {

        return search(key, root);
    }

    private Element search(int key, Node node) {

        if (node == null)
            return null;

        Element pointer = node.header();

        while (pointer != null) {

            if (pointer.compareTo(key) == Element.CRITERION_EQ)
                return pointer;

            if (pointer.right() == null ||
                pointer.right().compareTo(key) == Element.CRITERION_GT)
                return search(key, pointer.child());

            else
                pointer = pointer.right();

        }

        return null;
    }

    public void display() {

        display(root.header(), 0);
        System.out.println("\n========================================");
    }

    private void display(Element e, int level) {

        if (!(e instanceof Header)) {

            for (int i = 0; i < level; i++)
                System.out.printf("%6s", " ");
        }

        System.out.printf("%6s", e.key());

        if (e.child() != null) {

            display(e.child().header(), level + 1);
            System.out.println();
        }

        if (e.right() != null) {

            System.out.println();
            display(e.right(), level);
        }
    }
}
