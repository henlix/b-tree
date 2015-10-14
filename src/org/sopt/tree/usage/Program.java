package org.sopt.tree.usage;

import org.sopt.tree.model.Data;
import org.sopt.tree.tree.impl.Tree;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        ArrayList<Data> sample = Util.sample(false);

        Tree tree = new Tree();

        tree.insert(sample.get(0));     // 1
        tree.insert(sample.get(1));     // 38
        tree.insert(sample.get(2));     // 14
        tree.insert(sample.get(3));     // 48
        tree.insert(sample.get(4));     // 11

        tree.insert(sample.get(5));     // 49 : Split - Level 1

        tree.insert(sample.get(6));     // 42
        tree.insert(sample.get(7));     // 26

        tree.insert(sample.get(8));     // 27 : Pass Key to Left Sibling
        tree.insert(sample.get(9));     // 28

        tree.insert(sample.get(10));    // 24

        tree.insert(sample.get(11));    // 29 : Split - Level 2


        tree.insert(sample.get(12));    // 25 : Pass Key to Right Sibling
        tree.insert(sample.get(13));    // 2
        tree.insert(sample.get(14));    // 4

        tree.insert(sample.get(15));    // 8 : Split - Level 2

        tree.insert(sample.get(16));    // 5
        tree.insert(sample.get(17));    // 3
        tree.insert(sample.get(18));    // 6

        tree.insert(sample.get(19));    // 12 : Pass Key to Left Sibling
        tree.insert(sample.get(20));    // 13

        tree.insert(sample.get(21));    // 100
        tree.insert(sample.get(22));    // 92

        tree.insert(sample.get(23));    // 70 : Split - Level 2

        tree.insert(sample.get(24));    // 50
        tree.insert(sample.get(25));    // 51
        tree.insert(sample.get(26));    // 52

        tree.insert(sample.get(27));    // 61 : Pass Key to Left Sibling
        tree.insert(sample.get(28));    // 75

        tree.insert(sample.get(29));    // 110 : Split - Level 2

        tree.insert(sample.get(30));    // 78
        tree.insert(sample.get(31));    // 79
        tree.insert(sample.get(32));    // 74

        tree.insert(sample.get(33));    // 76 : Pass Key to Left Sibling

        tree.insert(sample.get(34));    // 73

        tree.insert(sample.get(35));    // 55 : Split - Level 3

        tree.display();


        tree.delete(sample.get(22));    // 92
        tree.display();

        tree.delete(sample.get(21));    // 100
        tree.display();

        tree.delete(sample.get(29));    // 110
        tree.display();

        tree.delete(sample.get(30));    // 78 : Pass Key to Right Sibling
        tree.display();

        tree.delete(sample.get(32));    // 74 : Merge
        tree.display();


        System.out.println(">> " + tree.search(15));
    }
}
