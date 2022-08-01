package com.tree.redblack;

public class Main {

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.leftRotate(tree.getRoot());
        tree.rightRotate(tree.getRoot().right);
    }
}
