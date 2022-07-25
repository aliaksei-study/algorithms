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

//        TreeNode treeNode1 = new TreeNode(2, null, null, null);
//        TreeNode treeNode2 = new TreeNode(5, null, null, null);
//        TreeNode treeNode3 = new TreeNode(7, null, null, null);
//        TreeNode treeNode4 = new TreeNode(6, null, null, null);
//        TreeNode treeNode5 = new TreeNode(8, null, null, null);
//        TreeNode treeNode6 = new TreeNode(5, null, null, null);
//
//        treeNode1.rightChild = treeNode2;
//
//        treeNode2.rightChild = treeNode3;
//        treeNode2.parent = treeNode1;
//
//        treeNode3.parent = treeNode2;
//        treeNode3.rightChild = treeNode5;
//        treeNode3.leftChild = treeNode4;
//
//        treeNode4.parent = treeNode3;
//        treeNode4.leftChild = treeNode6;
//
//        treeNode5.parent = treeNode3;
//
//        treeNode6.parent = treeNode4;
//
//        TreeUtils.inorderWalk(treeNode1);

        TreeNode root = new TreeNode(12);
        TreeUtils.insert(root, new TreeNode(5));
        TreeUtils.insert(root, new TreeNode(18));
        TreeUtils.insert(root, new TreeNode(2));
        TreeNode successor1 = TreeUtils.insert(root, new TreeNode(9));
        TreeUtils.insert(root, new TreeNode(15));
        TreeUtils.insert(root, new TreeNode(19));
        TreeUtils.insert(root, new TreeNode(13));
        TreeUtils.insert(root, new TreeNode(17));
        TreeUtils.insert(root, new TreeNode(14));
//        System.out.println(TreeUtils.search(root, 6));
//        System.out.println(TreeUtils.successor(successor1));
//        System.out.println(TreeUtils.predecessor(root));

        TreeUtils.delete(successor1);
        System.out.println(1);

    }
}
