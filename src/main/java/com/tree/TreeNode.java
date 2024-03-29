package com.tree;

public class TreeNode {
    int key;
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode parent;

    public TreeNode(int key, TreeNode leftChild, TreeNode rightChild, TreeNode parent) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.parent = parent;
    }

    public TreeNode(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key + "";
    }
}
