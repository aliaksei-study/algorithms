package com.heap.youngtableau;

public class YoungTableau {

    private int[][] matrix;
    private final int infinity = Integer.MAX_VALUE;

    public YoungTableau(int[][] matrix) {
        this.matrix = matrix;
    }

    public void youngify(int i, int j) {
        int rightVal = j + 1 < matrix[0].length ? matrix[i][j + 1] : infinity;
        int downVal = i + 1 < matrix.length ? matrix[i + 1][j] : infinity;

        if (rightVal == infinity && downVal == infinity) {
            return;
        }

        if (downVal > rightVal) {
            matrix[i][j + 1] = matrix[i][j];
            matrix[i][j] = rightVal;
            youngify(i, j + 1);
        } else {
            matrix[i + 1][j] = matrix[i][j];
            matrix[i][j] = downVal;
            youngify(i + 1, j);
        }
    }

    public int extractMin() {
        int min = matrix[0][0];
        matrix[0][0] = infinity;
        youngify(0, 0);
        return min;
    }

    public void insert(int value) {
        matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1] = value;
        reverseYoungify(matrix.length - 1, matrix[matrix.length - 1].length - 1);
    }

    public void reverseYoungify(int i, int j) {
        if (i == 0 && j == 0) {
            return;
        }

        int leftVal = j - 1 >= 0 ? matrix[i][j - 1] : infinity;
        int topVal = i - 1 >= 0 ? matrix[i - 1][j] : infinity;

        if (i > 0 && matrix[i][j] < topVal && topVal >= leftVal) {
            matrix[i - 1][j] = matrix[i][j];
            matrix[i][j] = topVal;
            reverseYoungify(i - 1, j);
        } else if (j > 0 && matrix[i][j] < leftVal) {
            matrix[i][j - 1] = matrix[i][j];
            matrix[i][j] = leftVal;
            reverseYoungify(i, j - 1);
        }
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
