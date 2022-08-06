package com.tree.redblack;

public class RedBlackTree {
    private RedBlackTreeNode root;

    public RedBlackTree(RedBlackTreeNode root) {
        this.root = root;
    }

    public RedBlackTree() {
//        this.root = new RedBlackTreeNode(6);
//        RedBlackTreeNode leftRoot = new RedBlackTreeNode(4);
//        RedBlackTreeNode rightRoot = new RedBlackTreeNode(9);
//        RedBlackTreeNode leftLeftRoot = new RedBlackTreeNode(2);
//        RedBlackTreeNode rightLeftRoot = new RedBlackTreeNode(5);
//        RedBlackTreeNode rightRightRoot = new RedBlackTreeNode(10);
//        RedBlackTreeNode leftRightRoot = new RedBlackTreeNode(7);
//
//        link(this.root, leftRoot, rightRoot);
//        link(leftRoot, leftLeftRoot, rightLeftRoot);
//        link(rightRoot, leftRightRoot, rightRightRoot);
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
                if (node.parent.right.equals(node)) {
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
            if (node.right != null) node.right.parent = node;
        }
    }

    public void rightRotate(RedBlackTreeNode node) {
        if (node.left != null) {
            if (node.parent != null) {
                node.left.parent = node.parent;
                if (node.parent.right.equals(node)) {
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
            if (node.left != null) {
                node.left.parent = node;
            }
        }
    }

    public void insert(RedBlackTreeNode node) {
        RedBlackTreeNode previousNode = null;
        RedBlackTreeNode currentNode = this.root;

        while (currentNode != null) {
            previousNode = currentNode;
            if (node.key < currentNode.key) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        node.parent = previousNode;

        if (previousNode == null) {
            this.root = node;
        } else if (node.key < previousNode.key) {
            previousNode.left = node;
        } else {
            previousNode.right = node;
        }

        node.color = Color.RED;

        insertFixup(node);
    }

    public void insertFixup(RedBlackTreeNode node) {
        RedBlackTreeNode nodeUncle;

        while (node.parent != null && node.parent.color == Color.RED) {
            if (node.parent.equals(node.parent.parent.left)) {
                nodeUncle = node.parent.parent.right;

                if (nodeUncle != null && nodeUncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    nodeUncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else if (node.equals(node.parent.right)) {
                    node = node.parent;
                    leftRotate(node);
                } else {
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rightRotate(node.parent.parent);
                }
            } else {
                nodeUncle = node.parent.parent.left;

                if (nodeUncle != null && nodeUncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    nodeUncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else if (node.equals(node.parent.left)) {
                    node = node.parent;
                    rightRotate(node);
                } else {
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    leftRotate(node.parent.parent);
                }
            }
        }

        this.root.color = Color.BLACK;
    }
}
