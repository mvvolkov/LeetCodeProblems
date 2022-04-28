package leetCode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
public class RottingOrangesTest {


    @Test
    public void test1() {
        int[][] input = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 4;
        test(input, expected);
    }

    @Test
    public void test2() {
        int[][] input = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expected = -1;
        test(input, expected);
    }

    @Test
    public void test3() {
        int[][] input = {{0, 2}};
        int expected = 0;
        test(input, expected);
    }

    @Test
    public void test4() {
        int[][] input = {{1, 2}};
        int expected = 1;
        test(input, expected);
    }

    @Test
    public void test5() {
        int[][] input = {
                {2, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int expected = 58;
        test(input, expected);
    }

    private static void test(int[][] input, int expected) {
        System.out.println("input array: " + Arrays.deepToString(input));
        System.out.println("expected: " + expected);
        int actual = orangesRotting(input);
        System.out.println("  actual: " + actual);
        assert expected == actual;
    }

    public static int orangesRotting(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int maxOranges = h * w;
        int[] freshOranges = new int[maxOranges * 2];
        int[] rottenOranges = new int[maxOranges * 2];
        int freshSize = 0;
        int rottenSize = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int value = grid[i][j];
                if (value == 1) {
                    freshOranges[freshSize++] = i;
                    freshOranges[freshSize++] = j;
                }
                if (value == 2) {
                    rottenOranges[rottenSize++] = i;
                    rottenOranges[rottenSize++] = j;
                }
            }
        }
        for (int k = 0; k < rottenSize; ) {
            int i = rottenOranges[k++];
            int j = rottenOranges[k++];
            if (i > 0) {
                rotten(grid, h, w, i - 1, j, 100);
            }
            if (i < h - 1) {
                rotten(grid, h, w, i + 1, j, 100);
            }
            if (j > 0) {
                rotten(grid, h, w, i, j - 1, 100);
            }
            if (j < w - 1) {
                rotten(grid, h, w, i, j + 1, 100);
            }
        }
        int result = 0;
        for (int k = 0; k < freshSize; ) {
            int i = freshOranges[k++];
            int j = freshOranges[k++];
            int value = grid[i][j];
            if (value == 1) {
                return -1;
            }
            value -= 99;
            if (value > result) {
                result = value;
            }
        }
        return result;
    }

    private static void rotten(int[][] grid, int h, int w, int i, int j, int day) {
        int value = grid[i][j];
        if (value == 0 || value == 2 || (value != 1 && value < day)) {
            return;
        }
        grid[i][j] = day;
        if (i > 0) {
            rotten(grid, h, w, i - 1, j, day + 1);
        }
        if (i < h - 1) {
            rotten(grid, h, w, i + 1, j, day + 1);
        }
        if (j > 0) {
            rotten(grid, h, w, i, j - 1, day + 1);
        }
        if (j < w - 1) {
            rotten(grid, h, w, i, j + 1, day + 1);
        }
    }
}
