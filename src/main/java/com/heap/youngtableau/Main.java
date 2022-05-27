package com.heap.youngtableau;

public class Main {

    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {1, 2, 7},
                {4, 6, Integer.MAX_VALUE},
                {5, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

        YoungTableau youngTableau = new YoungTableau(matrix);
        youngTableau.printMatrix();

        System.out.println(youngTableau.extractMin());
        youngTableau.printMatrix();

        youngTableau.insert(1);
        youngTableau.printMatrix();

        youngTableau.insert(3);
        youngTableau.printMatrix();
    }
}
