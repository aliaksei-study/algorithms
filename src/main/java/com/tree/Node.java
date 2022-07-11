package com.tree;

public class Node<T> {
    T value;
    Node<T> leftChild;
    Node<T> rightChild;

    public Node(T value) {
        this.value = value;
    }
}
