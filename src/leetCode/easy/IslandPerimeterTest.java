package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/island-perimeter/">https://leetcode.com/problems/island-perimeter/</a>
 * <p>
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0
 * represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[1]]
 * Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: grid = [[1,0]]
 * Output: 4
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] is 0 or 1.
 * There is exactly one island in grid.
 */
public class IslandPerimeterTest {

    @Test
    public void test1() {
        int[][] input = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int expected = 16;
        test(input, expected);
    }

    @Test
    public void test2() {
        int[][] input = {{1}};
        int expected = 4;
        test(input, expected);
    }

    @Test
    public void test3() {
        int[][] input = {{1, 0}};
        int expected = 4;
        test(input, expected);
    }

    private static void test(int[][] input, int expected) {
        int actual = islandPerimeter(input);
        Assert.assertEquals(expected, actual);
    }


    public static int islandPerimeter(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int result = 0;
        for (int i = 0; i < h; i++) {
            boolean leftIsZero = true;
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 0) {
                    if (!leftIsZero) {
                        result++;
                    }
                    leftIsZero = true;
                    continue;
                }
                if (leftIsZero) {
                    result++;
                }
                result += 2;
                if (i > 0) {
                    result -= grid[i - 1][j];
                }
                if (i < h - 1) {
                    result -= grid[i + 1][j];
                }
                leftIsZero = false;
            }
            if (!leftIsZero) {
                result++;
            }
        }
        return result;
    }
}
