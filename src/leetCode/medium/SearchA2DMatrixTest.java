package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">https://leetcode.com/problems/search-a-2d-matrix/</a>
 * <p>
 * 74. Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class SearchA2DMatrixTest {

    @Test
    public void test1() {
        int[][] input = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        boolean expected = true;
        test(input, target, expected);
    }

    @Test
    public void test2() {
        int[][] input = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;
        boolean expected = false;
        test(input, target, expected);
    }


    private static void test(int[][] input, int target, boolean expected) {
        boolean actual = searchMatrix(input, target);
        Assert.assertEquals(expected, actual);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int h = matrix.length;
        int w = matrix[0].length;
        int start = 0;
        int end = h * w - 1;
        while (start <= end) {
            int m = (start + end) / 2;
            int mv = matrix[m / w][m % w];
            if (mv > target) {
                end = m - 1;
            } else if (mv < target) {
                start = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
