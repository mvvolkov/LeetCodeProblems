package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">547. Number of Provinces</a>
 * <p>
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly
 * with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city
 * are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class NumberOfProvincesTest {

    @Test
    public void test1() {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int expected = 2;
        test(isConnected, expected);
    }

    @Test
    public void test2() {
        int[][] isConnected = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        int expected = 3;
        test(isConnected, expected);
    }

    @Test
    public void test3() {
        int[][] isConnected = {
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };
        int expected = 2;
        test(isConnected, expected);
    }

    private static void test(int[][] isConnected, int expected) {
        int actual = findCircleNum(isConnected);
        Assert.assertEquals(expected, actual);
    }

    public static int findCircleNum(int[][] isConnected) {
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] == 1) {
                addToProvince(i, isConnected);
                result++;
            }
        }
        return result;
    }

    private static void addToProvince(int i, int[][] isConnected) {
        isConnected[i][i] = 0;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[j][j] == 1 && isConnected[i][j] == 1) {
                addToProvince(j, isConnected);
            }
        }
    }
}
