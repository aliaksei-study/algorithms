package com.tree;

public class Main {

    public static void main(String[] args) {
//        Tree<Integer> tree = new Tree<>();
//
//        tree.insert(5);
//        tree.insert(6);
//        tree.insert(4);
//        tree.insert(5);
//        tree.insert(6);
//        tree.insert(10);
//        tree.insert(14);
//        tree.insert(20);
//
//        tree.printRecursive(tree.getRoot());

        TreeNode treeNode1 = new TreeNode(2, null, null, null);
        TreeNode treeNode2 = new TreeNode(5, null, null, null);
        TreeNode treeNode3 = new TreeNode(7, null, null, null);
        TreeNode treeNode4 = new TreeNode(6, null, null, null);
        TreeNode treeNode5 = new TreeNode(8, null, null, null);
        TreeNode treeNode6 = new TreeNode(5, null, null, null);

        treeNode1.rightChild = treeNode2;

        treeNode2.rightChild = treeNode3;
        treeNode2.parent = treeNode1;

        treeNode3.parent = treeNode2;
        treeNode3.rightChild = treeNode5;
        treeNode3.leftChild = treeNode4;

        treeNode4.parent = treeNode3;
        treeNode4.leftChild = treeNode6;

        treeNode5.parent = treeNode3;

        treeNode6.parent = treeNode4;

        TreeUtils.inorderWalk(treeNode1);
    }
}
