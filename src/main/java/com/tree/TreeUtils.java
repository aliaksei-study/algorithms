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
            if(nextNode.leftChild != null && !poppedFromStack) {
                stack.push(nextNode);
                nextNode = nextNode.leftChild;
            } else if(nextNode.rightChild != null) {
                poppedFromStack = false;
                System.out.println(nextNode.key);
                nextNode = nextNode.rightChild;
            } else {
                System.out.println(nextNode.key);
                if(!stack.isEmpty()) {
                    nextNode = stack.pop();
                    poppedFromStack = true;
                } else {
                    nextNode = null;
                }
            }
        }
    }
}
