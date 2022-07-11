package com.tree;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.insert(5);
        tree.insert(6);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(20);

        tree.printRecursive(tree.getRoot());
    }
}
