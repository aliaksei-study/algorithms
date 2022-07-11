package com.tree;

public class Tree<T> {
    private Node<T> root;

    public Node<T> insertRecursive(Node<T> current, T value) {
        if(current == null) {
            this.root = new Node<>(value);
            return this.root;
        }

        if(current.leftChild == null) {
            current.leftChild = new Node<>(value);
            return current.leftChild;
        }

        if(current.rightChild == null) {
            current.rightChild = new Node<>(value);
            return current.rightChild;
        }

        return insertRecursive(current.leftChild, value);
    }

    public void insert(T value) {
        insertRecursive(root, value);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void printRecursive(Node<T> node) {
        System.out.println(node.value);

        if(node.leftChild != null) printRecursive(node.leftChild);
        if(node.rightChild!= null) printRecursive(node.rightChild);
    }
}
