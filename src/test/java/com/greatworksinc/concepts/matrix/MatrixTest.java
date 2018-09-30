package com.greatworksinc.concepts.matrix;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MatrixTest {
    public static final Matrix MATRIX_1 = new Matrix(new int[][]{{1, 1, 1}, {1, 2, 1}, {1, 1, 1}});
    public static final Matrix MATRIX_2 = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    public static final Matrix MATRIX_3 = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}});

    @Before
    public void setUp() {
    }

    @Test
    public void getValue_positive() {
        assertThat(MATRIX_1.getValue(1, 1)).isEqualTo(2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getValue_negative() {
        MATRIX_1.getValue(10, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getValue_negative2() {
        MATRIX_1.getValue(3, 1);
    }

    @Test
    public void add_positive() {
        assertThat(Matrix.add(MATRIX_1, MATRIX_2)).isEqualTo(new Matrix(new int[][]{{2, 3, 4}, {5, 7, 7}, {8, 9, 10}}));
    }

    @Test
    public void multiply_positive_3x3() {
        assertThat(Matrix.multiply(MATRIX_1, MATRIX_2)).isEqualTo(new Matrix(new int[][]{{12, 15, 18}, {16, 20, 24}, {12, 15, 18}}));
    }

    @Test (expected = IllegalArgumentException.class)
    public void multiply_negative() {
        Matrix.multiply(MATRIX_1, MATRIX_3);
    }

    @Test
    public void multiply_positive_differentDimensions() {
        assertThat(Matrix.multiply(MATRIX_3, MATRIX_1)).isEqualTo(new Matrix(new int[][]{{6, 8, 6}, {15, 20, 15}, {24, 32, 24}, {33, 44, 33}}));
    }

    @Test
    public void tanspose_positive3x3_result3x3() {
        assertThat(Matrix.transpose(MATRIX_2)).isEqualTo(new Matrix(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}));
    }

    @Test
    public void tanspose_positive4x3_result3x4() {
        assertThat(Matrix.transpose(MATRIX_3)).isEqualTo(new Matrix(new int[][]{{1, 4, 7, 10}, {2, 5, 8, 11}, {3, 6, 9, 12}}));
    }

}