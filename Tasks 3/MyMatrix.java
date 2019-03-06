package epamhw3;

import java.util.Random;

public class MyMatrix {
    private double[][] matrix;
    boolean isNotEmpty;

    MyMatrix () {
        matrix = new double[0][0];
        isNotEmpty = false;
    }

    MyMatrix (final int DIMENSION) {
        matrix = new double[DIMENSION][DIMENSION];
        isNotEmpty = true;
    }

    MyMatrix (final int ROW_NUMBER, final int COLUMN_NUMBER) {                       //проверить M и N
        matrix = new double[ROW_NUMBER][COLUMN_NUMBER];
        isNotEmpty = true;
    }

    public double findMaxElement () {
        double maxElement = matrix[0][0];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (maxElement < matrix[i][j]){
                    maxElement = matrix[i][j];
                }
            }
        }
        return maxElement;
    }

    public double findMinElement () {
        double minElement = matrix[0][0];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (minElement > matrix[i][j]){
                    minElement = matrix[i][j];
                }
            }
        }
        return minElement;
    }

    public double findArithmeticAverage () {
        double sumOfElements = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                sumOfElements += matrix[i][j];
            }
        }
        return sumOfElements / (matrix.length * matrix[0].length);
    }

    public double findGeometricAverage () {
        double compositionOfElements = 1;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                compositionOfElements *= matrix[i][j];
            }
        }
        return Math.pow(compositionOfElements, 1./(matrix.length * matrix[0].length));
    }

    public double findLocalMax () {
        double localMax = -1;
        boolean isNotLocalMax = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length && isNotLocalMax; j++) {
                localMax = matrix[i][j];
                if (i + 1 < matrix.length && matrix[i + 1][j] > localMax ||
                    i > 0 && matrix[i - 1][j] > localMax ||
                    j + 1 < matrix[0].length && matrix[i][j + 1] > localMax||
                    j > 0 && matrix[i][j - 1] > localMax) {
                }
                else {
                    isNotLocalMax = false;
                }
            }
        }
        return localMax;
    }

    public double findLocalMin () {
        double localMin = -1;
        boolean isNotLocalMin = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length && isNotLocalMin; j++) {
                localMin = matrix[i][j];
                if (i + 1 < matrix.length && matrix[i + 1][j] < localMin ||
                        i > 0 && matrix[i - 1][j] < localMin ||
                        j + 1 < matrix[0].length && matrix[i][j + 1] < localMin||
                        j > 0 && matrix[i][j - 1] < localMin) {
                }
                else {
                    isNotLocalMin = false;
                }
            }
        }
        return localMin;
    }

    public void fillMatrixRandom() {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = -10 + 20 * random.nextDouble();
            }
        }
    }

    public void showMatrix() {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(String.format("%.6g ", matrix[i][j]) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void transposeMatrix(){
        double[][] transposedMatrix = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length; j++){
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        matrix = new double[matrix[0].length][matrix.length];
        matrix = transposedMatrix;
    }
}
