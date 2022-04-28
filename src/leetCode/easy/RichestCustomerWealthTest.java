package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/richest-customer-wealth/">https://leetcode.com/problems/richest-customer-wealth/</a>
 * <p>
 * 1672. Richest Customer Wealth
 * <p>
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money
 * the ith customer has in the jth bank. Return the wealth that the richest customer has.
 * <p>
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: accounts = [[1,2,3],[3,2,1]]
 * Output: 6
 * Explanation:
 * 1st customer has wealth = 1 + 2 + 3 = 6
 * 2nd customer has wealth = 3 + 2 + 1 = 6
 * Both customers are considered the richest with a wealth of 6 each, so return 6.
 * <p>
 * Example 2:
 * <p>
 * Input: accounts = [[1,5],[7,3],[3,5]]
 * Output: 10
 * Explanation:
 * 1st customer has wealth = 6
 * 2nd customer has wealth = 10
 * 3rd customer has wealth = 8
 * The 2nd customer is the richest with a wealth of 10.
 * <p>
 * Example 3:
 * <p>
 * Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * Output: 17
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 */
public class RichestCustomerWealthTest {

    @Test
    public void test1() {
        int[][] input = {{1, 2, 3}, {3, 2, 1}};
        int expected = 6;
        test(input, expected);
    }

    @Test
    public void test2() {
        int[][] input = {{1, 5}, {7, 3}, {3, 5}};
        int expected = 10;
        test(input, expected);
    }

    @Test
    public void test3() {
        int[][] input = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        int expected = 17;
        test(input, expected);
    }

    private static void test(int[][] input, int expected) {
        int actual = maximumWealth(input);
        Assert.assertEquals(expected, actual);
    }

    public static int maximumWealth(int[][] accounts) {

        int maxWealth = 0;
        for (int[] account : accounts) {
            int wealth = 0;
            for (int bank : account) {
                wealth += bank;
            }
            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }
        return maxWealth;
    }
}
