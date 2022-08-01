package com.tree.redblack;

public class RedBlackTree {
    private RedBlackTreeNode root;

    public RedBlackTree(RedBlackTreeNode root) {
        this.root = root;
    }

    public RedBlackTree() {
        this.root = new RedBlackTreeNode(6);
        RedBlackTreeNode leftRoot = new RedBlackTreeNode(4);
        RedBlackTreeNode rightRoot = new RedBlackTreeNode(9);
        RedBlackTreeNode leftLeftRoot = new RedBlackTreeNode(2);
        RedBlackTreeNode rightLeftRoot = new RedBlackTreeNode(5);
        RedBlackTreeNode rightRightRoot = new RedBlackTreeNode(10);
        RedBlackTreeNode leftRightRoot = new RedBlackTreeNode(7);

        link(this.root, leftRoot, rightRoot);
        link(leftRoot, leftLeftRoot, rightLeftRoot);
        link(rightRoot, leftRightRoot, rightRightRoot);
    }

    public RedBlackTreeNode getRoot() {
        return root;
    }

    private void link(RedBlackTreeNode parent, RedBlackTreeNode leftChild, RedBlackTreeNode rightChild) {
        parent.left = leftChild;
        parent.right = rightChild;

        if (leftChild != null)
            leftChild.parent = parent;

        if (rightChild != null)
            rightChild.parent = parent;
    }

    public void leftRotate(RedBlackTreeNode node) {
        if (node.right != null) {
            if (node.parent != null) {
                node.right.parent = node.parent;
                if(node.parent.right.equals(node)) {
                    node.parent.right = node.right;
                } else {
                    node.parent.left = node.right;
                }
                node.parent = node.right;
            } else {
                node.right.parent = null;
                this.root = node.right;
            }

            RedBlackTreeNode leftChildOfRightNode = node.right.left;
            node.right.left = node;
            node.right = leftChildOfRightNode;
            node.right.parent = node;
        }
    }

    public void rightRotate(RedBlackTreeNode node) {
        if(node.left != null) {
            if(node.parent != null) {
                node.left.parent = node.parent;
                if(node.parent.right.equals(node)) {
                    node.parent.right = node.left;
                } else {
                    node.parent.left = node.left;
                }
            } else {
                node.left.parent = null;
                this.root = node.left;
            }
            node.parent = node.left;

            RedBlackTreeNode rightChildOfLeftNode = node.left.right;
            node.left.right = node;
            node.left = rightChildOfLeftNode;
            if(node.left != null) {
                node.left.parent = node;
            }
        }
    }
}
