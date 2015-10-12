package org.sopt.tree.tree.base;

import java.io.Serializable;
import java.util.ArrayList;

public class Node implements Serializable {

    public static final int NODE_LIMIT = 5;

    private Header header;
    private int size = 0;

    public Node() {

        header = new Header();
        header.container(this);
    }

    public Element first() {

        return header.right();
    }
    public Element last() {

        Element pointer = header;

        while (pointer.right() != null)
            pointer = pointer.right();

        return pointer != header ? pointer : null;
    }
    public ArrayList<Element> elements() {

        ArrayList<Element> elements = new ArrayList<>();

        Element pointer = header;

        while (pointer != null) {

            elements.add(pointer);
            pointer = pointer.right();
        }

        return elements;
    }

    public boolean leaf() {

        Element pointer = header;

        while (pointer != null) {

            if (pointer.child() != null)
                return false;

            pointer = pointer.right();
        }

        return true;
    }

    public void insert(Element e) {

        e.container(this);
        size++;

        Element pointer = header;

        while (pointer.right() != null) {

            pointer = pointer.right();

            if (pointer.compareTo(e) == Element.CRITERION_LT)
                continue;

            e.left(pointer.left());
            e.right(pointer);

            pointer.left().right(e);
            pointer.left(e);

            return;
        }

        pointer.right(e);
        e.left(pointer);

        if (pointer.compareTo(e) == Element.CRITERION_GT)
            pointer.exchange(e);

    }
    public void delete(Element e) {

        Element pointer = header;

        while (pointer.right() != null) {

            pointer = pointer.right();

            if (pointer.compareTo(e) == Element.CRITERION_EQ) {

                if (pointer.right() == null) {

                    pointer.left().right(null);
                }
                else {

                    pointer.right().left(pointer.left());
                    pointer.left().right(pointer.right());
                }

                pointer.clear();
                size--;

                break;
            }
        }
    }

    private boolean contains(Element e) {

        Element pointer = header.right();

        while (pointer != null) {

            if (e.equals(pointer))
                return true;

            pointer = pointer.right();
        }

        return false;
    }



    public Header header() { return header; }
    private Element pop() {

        Element pointer = header;

        while (pointer.right() != null)
            pointer = pointer.right();

        pointer.left().right(null);

        pointer.clear();
        size--;

        return pointer;
    }
    private Element dequeue() {

        if (size < 1)
            return null;

        Element element = header.right();

        if (element.right() != null)
            element.right().left(element.left());

        element.left().right(element.right());

        element.clear();
        size--;

        return element;
    }

    private Element remove(Element e) {

        Element pointer = header;

        while (pointer.right() != null) {

            pointer = pointer.right();

            if (pointer.equals(e)) {

                if (pointer.right() == null) {

                    pointer.left().right(null);
                }
                else {

                    pointer.right().left(pointer.left());
                    pointer.left().right(pointer.right());
                }

                pointer.clear();
                size--;

                return pointer;
            }
        }

        return null;
    }


    public Node findNodeToInsert(Element e) {

        if (leaf())
            return this;

        Element pointer = header;

        while (pointer.right() != null) {

            if (pointer.right().compareTo(e) == Element.CRITERION_GT)
                return pointer.child().findNodeToInsert(e);

            pointer = pointer.right();
        }

        return pointer.child().findNodeToInsert(e);
    }
    public Node findNodeToDelete(Element e) {

        if (leaf() && contains(e))
            return this;

        Element pointer = header.right();

        while (pointer.right() != null) {

            if (pointer.right().compareTo(e) == Element.CRITERION_GT)
                return pointer.child().findNodeToInsert(e);

            pointer = pointer.right();
        }

        return pointer.child().findNodeToInsert(e);
    }

    public Node exchangeWithLeafElement(Element e) {

        Node pointer = e.child();

        while (!pointer.leaf())
            pointer = pointer.header.child();

        Element target = pointer.first();
        e.exchange(target);

        return pointer;
    }


    public boolean overflow() { return NODE_LIMIT < size; }
    public void cleanOverflow() {

        Element parent = header.parent();

        if (parent == null) {

            split();
        }
        else {

            Node leftSibling = header.leftSibling();
            Node rightSibling = header.rightSibling();

            if (leftSibling != null && leftSibling.canAccept()) {

                first().exchange(parent);
                leftSibling.insert(dequeue());
            }
            else if (rightSibling != null && rightSibling.canAccept()) {

                last().exchange(parent.right());
                rightSibling.insert(pop());
            }
            else {

                split();
            }
        }
    }

    private boolean canAccept() { return size < NODE_LIMIT; }
    private void split() {

        Node left = new Node();
        for (int i = 0; i < NODE_LIMIT / 2; i++)
            left.insert(dequeue());

        left.header.child(header.child());

        Element pivot = dequeue();

        Node right = new Node();
        for (int i = 0; i < NODE_LIMIT / 2 + 1; i++)
            right.insert(dequeue());


        if (pivot == null)
            throw new UnsupportedOperationException();


        Node merger = (header.parent() != null) ? header.parent().container() : this;
        merger.insert(pivot);

        if (pivot.child() != null)
            right.header.child(pivot.child());

        pivot.left().child(left);
        pivot.child(right);

        left.header.parent(pivot.left());
        right.header.parent(pivot);


        if (merger.overflow())
            merger.cleanOverflow();
    }


    public boolean underflow() { return NODE_LIMIT / 2 > size; }
    public void cleanUnderflow() {

        Element parent = header.parent();

        if (parent == null)
            throw new UnsupportedOperationException();

        Node leftSibling = header.leftSibling();
        Node rightSibling = header.rightSibling();

        if (leftSibling != null && leftSibling.canHandover()) {

            leftSibling.last().exchange(parent);
            insert(leftSibling.pop());
        }
        else if (rightSibling != null && rightSibling.canHandover()) {

            rightSibling.first().exchange(parent.right());
            insert(rightSibling.dequeue());
        }
        else {

            merge();
        }
    }

    private boolean canHandover() { return NODE_LIMIT / 2 < size; }
    private void merge() {

        Element precedence = header.rightSibling() != null ? header.parent().right() : header.parent();
        Node container = precedence.container();

        Node src = precedence.child();
        Node dst = precedence.left().child();

        precedence.child(src.header.child());
        container.remove(precedence);
        dst.insert(precedence);

        Element pointer = src.dequeue();

        while (pointer != null) {

            dst.insert(pointer);
            pointer = src.dequeue();
        }
    }
}