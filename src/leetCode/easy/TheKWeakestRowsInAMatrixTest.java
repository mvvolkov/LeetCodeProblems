package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/">https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/</a>
 * <p>
 * 1337. The K Weakest Rows in a Matrix
 * <p>
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
 * The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all
 * the 0's in each row.
 * <p>
 * A row i is weaker than a row j if one of the following is true:
 * <p>
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * <p>
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * <p>
 * Example 1:
 * <p>
 * Input: mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * <p>
 * Example 2:
 * <p>
 * Input: mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 1
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 1
 * The rows ordered from weakest to strongest are [0,2,3,1].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 */
public class TheKWeakestRowsInAMatrixTest {

    @Test
    public void test1() {
        int[][] input = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 3;
        int[] expected = {2, 0, 3};
        test(input, k, expected);
    }

    @Test
    public void test2() {
        int[][] input = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int k = 2;
        int[] expected = {0, 2};
        test(input, k, expected);
    }

    private static void test(int[][] input, int k, int[] expected) {
        int[] actual = kWeakestRows(input, k);
        Assert.assertArrayEquals(expected, actual);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {

        assert k >= 0;
        if (k == 0) {
            return new int[0];
        }
        int h = mat.length;
        int w = mat[0].length;
        PriorityQueue<Row> queue = new PriorityQueue<>(k);
        for (int i = 0; i < mat.length; i++) {
            int j = 0;
            for (; j < w; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
            }
            Row row = new Row(i, j);
            if (queue.size() < k) {
                queue.add(row);
                continue;
            }
            Row minRow = queue.peek();
            if (row.compareTo(minRow) > 0) {
                queue.poll();
                queue.add(row);
            }
        }
        int[] result = new int[k];
        int index = k - 1;
        while (!queue.isEmpty()) {
            result[index--] = queue.poll().i;
        }
        return result;
    }

    private static class Row implements Comparable<Row> {
        private final int i;
        private final int w;

        private Row(int i, int w) {
            this.i = i;
            this.w = w;
        }

        @Override
        public int compareTo(Row o) {
            if (o.w == w) {
                return i > o.i ? -1 : 1;
            }
            return w > o.w ? -1 : 1;
        }
    }
}
