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

    public static TreeNode insert(TreeNode root, TreeNode newNode) {
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

        return newNode;
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
        while (currentElement.leftChild != null) {
            currentElement = currentElement.leftChild;
        }
        return currentElement;
    }

    public static TreeNode treeMaximum(TreeNode root) {
        TreeNode currentElement = root;
        while (currentElement.rightChild != null) {
            currentElement = currentElement.rightChild;
        }
        return currentElement;
    }

    public static TreeNode successor(TreeNode element) {
        if (element.rightChild != null) {
            return treeMinimum(element.rightChild);
        }

        TreeNode elementParent = element.parent;
        while (elementParent != null && elementParent.rightChild == element) {
            element = elementParent;
            elementParent = elementParent.parent;
        }
        return elementParent;
    }

    public static TreeNode predecessor(TreeNode element) {
        return treeMaximum(element.leftChild);
    }

    public static void delete(TreeNode element) {
        TreeNode parent = element.parent;

        if (element.rightChild == null && element.leftChild == null) {
            if (parent.leftChild != null && parent.leftChild.equals(element)) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (element.rightChild == null) {
            if (parent.leftChild != null && parent.leftChild.equals(element)) {
                parent.leftChild = element.leftChild;
                element.leftChild.parent = parent;
            } else if (parent.rightChild != null) {
                parent.rightChild = element.leftChild;
            }
        } else if (element.leftChild == null) {
            if (parent.leftChild != null && parent.leftChild.equals(element)) {
                parent.leftChild = element.rightChild;
            } else {
                parent.rightChild = element.rightChild;
                element.rightChild.parent = parent;
            }
        } else {
            TreeNode successor = successor(element);
            if (!successor.parent.equals(element) && successor.rightChild != null) {
                successor.parent.leftChild = successor.rightChild;
                successor.rightChild.parent = successor.parent;
            }
            successor.rightChild = element.rightChild;
            successor.leftChild = element.leftChild;
            if (parent.leftChild != null && parent.leftChild.equals(element)) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.parent = parent;
        }
    }
}
