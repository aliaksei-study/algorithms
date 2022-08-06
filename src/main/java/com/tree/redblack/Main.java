package com.tree.redblack;

public class Main {

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
//        tree.leftRotate(tree.getRoot());
//        tree.rightRotate(tree.getRoot().right);

        tree.insert(new RedBlackTreeNode(3));
        tree.insert(new RedBlackTreeNode(21));
        tree.insert(new RedBlackTreeNode(32));
        System.out.println(tree.getRoot());
    }
}
