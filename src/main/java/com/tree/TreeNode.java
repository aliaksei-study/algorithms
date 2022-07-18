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
}
