package com.tree;

import java.util.Stack;

public class TreeUtils {
    static Stack<TreeNode> stack = new Stack<>();

    public static void inorderWalk(TreeNode root) {
        boolean poppedFromStack = false;
        TreeNode nextNode;

        if (root.leftChild == null) {
            System.out.println(root.key);
            nextNode = root.rightChild != null ? root.rightChild : null;
        } else {
            stack.push(root);
            nextNode = root.leftChild != null ? root.leftChild : null;
        }

        while (nextNode != null) {
            if (nextNode.leftChild != null && !poppedFromStack) {
                stack.push(nextNode);
                nextNode = nextNode.leftChild;
            } else if (nextNode.rightChild != null) {
                poppedFromStack = false;
                System.out.println(nextNode.key);
                nextNode = nextNode.rightChild;
            } else {
                System.out.println(nextNode.key);
                if (!stack.isEmpty()) {
                    nextNode = stack.pop();
                    poppedFromStack = true;
                } else {
                    nextNode = null;
                }
            }
        }
    }

    public static void insert(TreeNode root, TreeNode newNode) {
        TreeNode newNodeParent = root;
        TreeNode currentNode = root;

        while (currentNode != null) {
            newNodeParent = currentNode;
            if (newNode.key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }

        newNode.parent = newNodeParent;
        if (newNode.key < newNodeParent.key) {
            newNodeParent.leftChild = newNode;
        } else {
            newNodeParent.rightChild = newNode;
        }
    }

    public static TreeNode search(TreeNode root, int key) {
        if (root == null || key == root.key) {
            return root;
        }

        if (key < root.key) {
            return search(root.leftChild, key);
        } else {
            return search(root.rightChild, key);
        }
    }

    public static TreeNode treeMinimum(TreeNode root) {
        TreeNode currentElement = root;
        while(currentElement.leftChild != null) {
            currentElement = currentElement.leftChild;
        }
        return currentElement;
    }

    public static TreeNode treeMaximum(TreeNode root) {
        TreeNode currentElement = root;
        while(currentElement.rightChild != null) {
            currentElement = currentElement.rightChild;
        }
        return currentElement;
    }
}
