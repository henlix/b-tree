package org.sopt.tree.tree.base;

/**
 * Created by callisto on 9/28/15.
 */

import java.io.Serializable;

public abstract class Element implements Serializable {

    public static final int CRITERION_LT = -1;
    public static final int CRITERION_EQ =  0;
    public static final int CRITERION_GT = +1;

    public abstract String key();

    private Element left;
    private Element right;

    public Element left()    { return left; }
    public Element right()   { return right; }

    public void left(Element left)       { this.left = left; }
    public void right(Element right)     { this.right = right; }


    private Node child;
    private Node container;

    public Node child() { return child; }
    public Node container() { return container; }

    public void child(Node child) { this.child = child; }
    public void container(Node container) { this.container = container; }


    public int compareTo(Object obj) { return CRITERION_EQ; }
    public void exchange(Object obj) { }


    public void clear() {

        container(null);
        left(null);
        right(null);
    }
}