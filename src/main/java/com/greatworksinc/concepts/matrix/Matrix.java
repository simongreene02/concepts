package com.greatworksinc.concepts.matrix;

import com.google.common.base.MoreObjects;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private final int[][] values;
    private final int col;
    private final int row;

    public Matrix(int[][] values) {
        this.values = values.clone();
        row = values.length;
        col = row == 0 ? 0 : values[0].length;
    }

    public int getValue(int row, int col) {
        if (col >= this.col || row >= this.row) {
            throw new IllegalArgumentException("The row and column values must be smaller than the matrix size.");
        }
        return values[row][col];
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        if (matrix1.col == matrix2.col && matrix1.row == matrix2.row) {
            int[][] sumValues = new int[matrix1.row][matrix1.col];
            for (int i = 0; i < matrix1.row; i++) {
                for (int j = 0; j < matrix1.col; j++) {
                    sumValues[i][j] = matrix1.getValue(i, j) + matrix2.getValue(i, j);
                }
            }
            return new Matrix(sumValues);
        }
        throw new IllegalArgumentException("Matrixes must be the same size.");
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.col != matrix2.row) {
            throw new IllegalArgumentException("The Y value of the first matrix must be the same as the X value of the second.");
        }
        int[][] output = new int[matrix1.row][matrix2.col];
        if (output.length == 0) {
            return new Matrix(output);
        }
        for (int i = 0; i < matrix1.row; i++) {
            for (int j = 0; j < matrix2.col; j++) {
                for (int k = 0; k < matrix1.col; k++) {
                    output[i][j] += (matrix1.getValue(i, k) * matrix2.getValue(k, j));
                }
            }
        }
        return new Matrix(output);
    }

    public static Matrix transpose(Matrix matrix) {
        int[][] output = new int[matrix.col][matrix.row];
        for (int i = 0; i < matrix.col; i++) {
            for (int j = 0; j < matrix.row; j++) {
                output[i][j] += matrix.getValue(j, i);
            }
        }
        return new Matrix(output);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return col == matrix.col &&
                row == matrix.row &&
                valuesEqual(matrix);
    }

    private boolean valuesEqual(Matrix other) {
        for (int i = 0; i < row; i++) {
            if (!Arrays.equals(values[i], other.values[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(col, row);
        result = 31 * result + valuesHashCode();
        return result;
    }

    private int valuesHashCode() {
        int output = 0;
        for (int i = 0; i < row; i++) {
            output += Arrays.hashCode(values[i]);
        }
        return output;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("values", Arrays.toString(values))
                .add("row", row)
                .add("col", col)
                .toString();
    }
}
