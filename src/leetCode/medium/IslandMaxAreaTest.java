package leetCode.medium;

import org.junit.Test;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid
 * are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class IslandMaxAreaTest {


    @Test
    public void test1() {
        int[][] input = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int expected = 6;
        test(input, expected);
    }

    @Test
    public void test2() {
        int[][] input = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int expected = 0;
        test(input, expected);
    }

    @Test
    public void test3() {
        int[][] input = {
                {1, 1, 1},
                {1, 0, 0},
        };
        int expected = 4;
        test(input, expected);
    }

    @Test
    public void test4() {
        int[][] input = {
                {0, 1},
                {1, 0},
        };
        int expected = 1;
        test(input, expected);
    }

    @Test
    public void test5() {
        int[][] input = {
                {0, 1},
                {1, 1},
                {1, 0}
        };
        int expected = 4;
        test(input, expected);
    }

    @Test
    public void test6() {
        int[][] input = {
                {0, 1},
                {1, 1},
        };
        int expected = 3;
        test(input, expected);
    }

    private static void test(int[][] input, int expected) {
        printGrid(input);
        int actual = maxAreaOfIsland(input);
        System.out.println("expected: " + expected);
        System.out.println("  actual: " + actual);
        assert expected == actual;
    }

    private static void printGrid(int[][] input) {
        System.out.println("Input grid:");
        for (int[] row : input) {
            StringBuilder sb = new StringBuilder();
            for (int x : row) {
                sb.append(x == 1 ? " * " : "   ");
            }
            System.out.println(sb);
        }
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int size = dfs(grid, i, j);
                if (size > result) {
                    result = size;
                }
            }
        }
        return result;
    }


    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return dfs(grid, i + 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j - 1) + 1;
    }
}
