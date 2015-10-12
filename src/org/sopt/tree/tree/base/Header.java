package org.sopt.tree.tree.base;

/**
 * Created by callisto on 9/29/15.
 */
public class Header extends Element {


    @Override
    public String key() { return "h"; }

    private Element parent;

    public Element parent()  { return parent; }
    public void parent(Element parent)   { this.parent = parent; }

    public Node leftSibling()  { return parent != null && parent.left()  != null ? parent.left().child()  : null; }
    public Node rightSibling() { return parent != null && parent.right() != null ? parent.right().child() : null; }
}
