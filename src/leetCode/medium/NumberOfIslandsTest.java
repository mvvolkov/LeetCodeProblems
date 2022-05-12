package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">200. Number of Islands</a>
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslandsTest {

    @Test
    public void test1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expected = 1;
        test(grid, expected);
    }

    @Test
    public void test2() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        test(grid, expected);
    }

    @Test
    public void test3() {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        int expected = 1;
        test(grid, expected);
    }

    @Test
    public void test4() {
        char[][] grid = {
                {'1', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '0', '0'}
        };
        int expected = 1;
        test(grid, expected);
    }

    @Test
    public void test5() {
        char[][] grid = {
                {'0', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '1', '1'}
        };
        int expected = 2;
        test(grid, expected);
    }

    private static void test(char[][] grid, int expected) {
        int actual = numIslands(grid);
        Assert.assertEquals(expected, actual);
    }

    public static int numIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    markIsland(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void markIsland(char[][] grid, int i, int j) {
        int h = grid.length;
        int w = grid[0].length;
        grid[i][j] = '2';
        if (i > 0 && grid[i - 1][j] == '1') {
            markIsland(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            markIsland(grid, i, j - 1);
        }
        if (i < h - 1 && grid[i + 1][j] == '1') {
            markIsland(grid, i + 1, j);
        }
        if (j < w - 1 && grid[i][j + 1] == '1') {
            markIsland(grid, i, j + 1);
        }
    }

}
