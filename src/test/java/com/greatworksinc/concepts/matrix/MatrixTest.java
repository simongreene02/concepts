package com.greatworksinc.concepts.matrix;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MatrixTest {
    Matrix matrix1;
    @Before
    public void setUp() {
        matrix1 = new Matrix(new int[][]{{1, 1, 1}, {1, 2, 1}, {1, 1, 1}});
    }

    @Test
    public void getValue_positive() {
        assertThat(matrix1.getValue(1, 1)).isEqualTo(2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getValue_negative() {
        matrix1.getValue(10, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getValue_negative2() {
        matrix1.getValue(3, 1);
    }

    @Test
    public void add_positive() {
        Matrix matrix2 = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertThat(Matrix.add(matrix1, matrix2)).isEqualTo(new Matrix(new int[][]{{2, 3, 4}, {5, 7, 7}, {8, 9, 10}}));
    }

    @Test
    public void multiply_positive() {
        Matrix matrix2 = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertThat(Matrix.multiply(matrix1, matrix2)).isEqualTo(new Matrix(new int[][]{{12, 15, 18}, {16, 20, 24}, {12, 15, 18}}));
    }

    @Test
    public void tanspose_positive() {
        Matrix matrix2 = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertThat(Matrix.transpose(matrix2)).isEqualTo(new Matrix(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}));
    }

}