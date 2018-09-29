package com.greatworksinc.concepts.matrix;

import com.google.common.base.MoreObjects;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private final int [][] values;
    private final int x;
    private final int y;

    public Matrix(int[][] values) {
        this.values = values.clone();
        y = values.length;
        x = y==0 ? 0 : values[0].length;
    }

    public int getValue(int x, int y) {
        if (x >= this.x || y >= this.y) {
            throw new IllegalArgumentException("The X and Y values must be smaller than the matrix size.");
        }
        return values[y][x];
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        if (matrix1.x == matrix2.x && matrix1.y == matrix2.y) {
            int[][] sumValues = new int[matrix1.y][matrix1.x];
            for (int i = 0; i < matrix1.y; i++) {
                for (int j = 0; j < matrix1.x; j++) {
                    sumValues[i][j] = matrix1.getValue(j, i) + matrix2.getValue(j, i);
                }
            }
            return new Matrix(sumValues);
        }
        throw new IllegalArgumentException("Matrixes must be the same size.");
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.y != matrix2.x) {
            throw new IllegalArgumentException("The Y value of the first matrix must be the same as the X value of the second.");
        }
        int[][] output = new int[matrix2.y][matrix1.x];
        if (output.length == 0) {
            return new Matrix(output);
        }
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                for (int k = 0; k < matrix1.y; k++) {
                    output[i][j] += (matrix1.getValue(k, i)*matrix2.getValue(j, k));
                }
            }
        }
        return new Matrix(output);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return x == matrix.x &&
                y == matrix.y &&
                valuesEqual(matrix);
    }

    private boolean valuesEqual(Matrix other) {
        for (int i = 0; i < y; i++) {
            if (!Arrays.equals(values[i], other.values[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(x, y);
        result = 31 * result + valuesHashCode();
        return result;
    }

    private int valuesHashCode() {
        int output = 0;
        for (int i = 0; i < y; i++) {
            output += Arrays.hashCode(values[i]);
        }
        return output;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("values", Arrays.toString(values))
                .add("x", x)
                .add("y", y)
                .toString();
    }
}
