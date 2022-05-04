package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">https://leetcode.com/problems/climbing-stairs/</a>
 * <p>
 * 70. Climbing Stairs
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
public class ClimbingStairsTest {

    @Test
    public void test1() {
        int n = 2;
        int expected = 2;
        test(n, expected);
    }

    @Test
    public void test2() {
        int n = 3;
        int expected = 3;
        test(n, expected);
    }

    @Test
    public void test3() {
        int n = 4;
        int expected = 5;
        test(n, expected);
    }

    @Test
    public void test5() {
        int n = 5;
        int expected = 8;
        test(n, expected);
    }

    @Test
    public void test6() {
        int n = 6;
        int expected = 13;
        test(n, expected);
    }

    @Test
    public void test7() {
        int n = 1;
        int expected = 1;
        test(n, expected);
    }

    @Test
    public void test8() {
        int n = 0;
        int expected = 0;
        test(n, expected);
    }

    private static void test(int n, int expected) {
        int actual = climbStairs(n);
        Assert.assertEquals(expected, actual);
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int i1 = 0;
        int i2 = 1;
        while (n-- > 0) {
            int i3 = i1 + i2;
            i1 = i2;
            i2 = i3;
        }
        return i2;
    }
}
