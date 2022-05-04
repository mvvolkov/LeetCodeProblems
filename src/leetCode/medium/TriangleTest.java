package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/triangle/">https://leetcode.com/problems/triangle/</a>
 * <p>
 * 120. Triangle
 * <p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent number of the row below. More formally, if you are
 * on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * <p>
 * Example 2:
 * <p>
 * Input: triangle = [[-10]]
 * Output: -10
 */
public class TriangleTest {

    @Test
    public void test1() {
        //   2
        //  3 4
        // 6 5 7
        //4 1 8 3
        int[][] input = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int expected = 11;
        test(input, expected);
    }

    @Test
    public void test2() {
        //    2
        //   3 4
        //  6 5 7
        // 4 1 8 3
        //7 2 5 6 7
        int[][] input = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}, {7, 2, 5, 6, 7}};
        int expected = 13;
        test(input, expected);
    }

    private static void test(int[][] input, int expected) {
        List<List<Integer>> inputList = new ArrayList<>();
        for (int[] row : input) {
            inputList.add(intArrayToList(row));
        }
        int actual = minimumTotal(inputList);
        Assert.assertEquals(expected, actual);
    }

    private static List<Integer> intArrayToList(int[] array) {
        List<Integer> result = new ArrayList<>(array.length);
        for (int i : array) {
            result.add(i);
        }
        return result;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 1) {
            return triangle.get(0).get(0);
        }
        int[] nextRow = new int[size];
        int k = 0;
        for (int el : triangle.get(size - 1)) {
            nextRow[k++] = el;
        }
        size--;
        for (int i = size - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            int right = nextRow[size];
            for (int j = size - 1; j >= 0; j--) {
                int left = nextRow[j];
                nextRow[j] = row.get(j) + Math.min(left, right);
                right = left;
            }
            size--;
        }
        return nextRow[0];
    }
}
