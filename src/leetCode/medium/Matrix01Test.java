package leetCode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * Example 2:
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */
public class Matrix01Test {

    @Test
    public void test1() {
        int[][] input = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        test(input, expected);
    }

    @Test
    public void test2() {
        int[][] input = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};
        test(input, expected);
    }

    @Test
    public void test3() {

        int[][] input = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
        };

        int[][] expected = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 2, 1, 1, 0, 1},
                {2, 1, 1, 1, 1, 2, 1, 0, 1, 0},
                {3, 2, 2, 1, 0, 1, 0, 0, 1, 1}
        };
        test(input, expected);
    }


    @Test
    public void test4() {

        int[][] input = {
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}
        };
        int[][] expected = {
                {0, 0, 1, 0, 1, 2, 1, 0, 1, 2},
                {1, 1, 2, 1, 0, 1, 1, 1, 2, 3},
                {2, 1, 2, 1, 1, 0, 0, 0, 1, 2},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 2},
                {0, 0, 1, 1, 1, 0, 1, 1, 2, 3},
                {1, 0, 1, 2, 1, 1, 1, 2, 1, 2},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 1, 2},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 2, 1, 0}
        };
        test(input, expected);
    }

    @Test
    public void test5() {

        int[][] input = {
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 1},
        };

        int[][] expected = {
                {2, 2, 1, 1, 1, 1, 0, 1, 2, 2},
                {1, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 2, 2},
                {2, 1, 0, 0, 1, 0, 1, 2, 1, 2},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {2, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                {3, 2, 1, 1, 0, 0, 0, 1, 1, 0},
                {3, 2, 1, 0, 1, 1, 0, 1, 2, 1}
        };
        test(input, expected);
    }


    @Test
    public void test6() {

        int[][] input = {
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0},
                {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0}
        };

        int[][] expected = {
                {4, 3, 2, 1, 0, 1, 0, 1, 0, 1, 2, 1, 0, 0, 0, 0, 1, 0, 1, 2, 2, 1, 1, 0, 0, 1, 0, 1, 2, 2},
                {3, 2, 2, 1, 1, 1, 0, 1, 0, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 2, 1, 0, 1, 0, 1, 1, 1, 2, 1, 1},
                {2, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 2, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 1, 1, 2, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 2, 1, 1, 2, 1, 2, 1, 1, 0, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 0, 0, 1, 1, 1, 1},
                {0, 1, 1, 1, 2, 1, 2, 2, 2, 1, 1, 0, 1, 1, 0, 0, 1, 2, 1, 2, 1, 2, 2, 1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 1, 2, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 2, 1, 1, 2, 1, 0, 1, 0, 1, 1, 2, 1, 1, 0, 1, 0, 1, 1, 2, 1, 1, 0, 1, 1, 2, 1, 0, 0, 1},
                {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 2, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 2, 2, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 2, 1, 0, 0, 0, 1, 1, 2},
                {2, 1, 1, 1, 0, 0, 1, 2, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 2, 1},
                {1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 2, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 2, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 2, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 2, 1, 0, 0, 0, 1, 1, 2, 1, 1, 1, 2, 1, 0, 1, 2, 2, 1, 1},
                {1, 2, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 2, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 2, 1, 1, 2, 1, 2, 1},
                {0, 1, 0, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 0, 0, 1, 1, 2, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 2, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 0, 1},
                {2, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 2},
                {3, 2, 1, 0, 0, 1, 1, 0, 1, 1, 2, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1},
                {2, 1, 2, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0},
                {1, 0, 1, 1, 0, 1, 1, 2, 2, 1, 1, 0, 1, 1, 2, 1, 0, 1, 1, 0, 0, 0, 1, 1, 2, 2, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 0, 1, 2, 1, 0, 1, 2, 2, 2, 1, 1, 0, 1, 1, 1, 0, 1, 2, 2, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 2, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 2},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 2, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 2, 3},
                {0, 1, 1, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 2, 1, 0, 1, 1, 1, 0, 1, 0, 1, 2},
                {1, 0, 1, 2, 2, 1, 2, 1, 1, 1, 1, 0, 1, 1, 2, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 2, 2},
                {1, 1, 0, 1, 2, 2, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 2, 1, 0, 1, 1},
                {0, 1, 0, 1, 2, 1, 2, 1, 1, 1, 0, 1, 2, 1, 1, 0, 1, 0, 0, 1, 2, 1, 0, 1, 1, 2, 2, 1, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 2, 1, 0, 0, 1, 2, 2, 2, 1, 2, 1, 1, 2, 3, 2, 1, 0, 0, 1, 1, 0, 0, 0}
        };
        test(input, expected);
    }

    @Test
    public void test7() {

        int[][] input = {
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1}
        };

        int[][] expected = {
                {0, 1, 2, 1, 2, 3, 3, 2, 2, 2, 1, 2, 1, 0, 0, 1, 2, 1, 0, 1, 1, 0, 1, 2, 1, 1, 1, 0, 0, 1},
                {1, 2, 1, 0, 1, 2, 2, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 2, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 2, 2, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 2, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 2},
                {1, 0, 1, 1, 2, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 2},
                {2, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 2, 1, 0, 0},
                {2, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 2, 1, 1, 0, 1, 2, 1, 0, 1, 0, 0, 1, 1},
                {2, 1, 0, 1, 1, 1, 0, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 0, 1, 2, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 2, 1, 1},
                {0, 1, 0, 1, 0, 0, 1, 2, 2, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0},
                {1, 2, 1, 0, 1, 0, 1, 2, 1, 1, 2, 2, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 2, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 2, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 2, 2, 1, 0, 1, 1, 2, 1, 1, 2, 1, 2},
                {0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 2, 2, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                {0, 0, 1, 2, 2, 2, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 2},
                {1, 1, 2, 2, 1, 1, 2, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 1, 0, 1, 2},
                {2, 1, 2, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 2, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 2, 1, 1, 1, 0, 1, 0, 1, 1, 2, 1, 0, 0, 1, 1, 0, 1, 1, 1, 2, 1, 2, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 2, 2, 1, 2, 2, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 2, 1, 1, 0, 0, 0, 1, 0},
                {1, 1, 2, 3, 2, 2, 2, 1, 2, 1, 1, 1, 0, 0, 1, 2, 1, 1, 2, 1, 1, 0, 1, 2, 2, 1, 1, 1, 2, 1},
                {1, 0, 1, 2, 1, 2, 1, 0, 1, 2, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 2, 1, 1, 2, 2, 1, 0, 1, 2, 2},
                {1, 0, 0, 1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 2, 1, 2, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
                {1, 2, 1, 0, 1, 1, 2, 3, 2, 1, 0, 1, 1, 1, 0, 1, 2, 1, 1, 1, 2, 1, 2, 1, 0, 1, 2, 1, 0, 1},
                {2, 1, 1, 0, 1, 0, 1, 2, 1, 0, 1, 2, 1, 1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0, 1, 0, 1, 2, 1, 2},
                {1, 0, 1, 1, 0, 1, 2, 3, 2, 1, 2, 1, 0, 1, 1, 2, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 2, 3, 2, 3},
                {2, 1, 2, 2, 1, 2, 3, 2, 1, 0, 1, 1, 0, 1, 0, 1, 2, 1, 0, 1, 0, 0, 1, 0, 1, 2, 1, 2, 3, 4},
                {3, 2, 2, 1, 0, 1, 2, 3, 2, 1, 0, 0, 1, 0, 1, 2, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 2, 3}
        };
        test(input, expected);
    }


    private static void test(int[][] input, int[][] expected) {
        System.out.println("input array: " + Arrays.deepToString(input));
        System.out.println("expected: " + Arrays.deepToString(expected));
        int[][] actual = updateMatrix(input);
        System.out.println("  actual: " + Arrays.deepToString(actual));
        assert Arrays.deepEquals(expected, actual);
    }

    public static int[][] updateMatrix(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;
        int max = h + w;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (mat[i][j] != 0) {
                    int up = i > 0 ? mat[i - 1][j] : max;
                    int left = j > 0 ? mat[i][j - 1] : max;
                    mat[i][j] = Math.min(up, left) + 1;
                }
            }
        }
        for (int i = h - 1; i >= 0; i--) {
            for (int j = w - 1; j >= 0; j--) {
                int value = mat[i][j];
                int down = i < h-1 ? mat[i + 1][j] : max;
                int right = j < w-1 ? mat[i][j + 1] : max;
                if (value != 0) {
                    mat[i][j] = Math.min(value, Math.min(down, right) + 1);
                }
            }
        }
        return mat;
    }
}