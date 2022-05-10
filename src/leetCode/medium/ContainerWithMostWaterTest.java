package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">11. Container With Most Water</a>
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class ContainerWithMostWaterTest {

    @Test
    public void test1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;
        test(height, expected);
    }

    @Test
    public void test2() {
        int[] height = {1, 1};
        int expected = 1;
        test(height, expected);
    }

    @Test
    public void test3() {
        int[] height = {1, 2, 3, 4, 5, 6, 7};
        int expected = 12;
        test(height, expected);
    }

    @Test
    public void test5() {
        int[] height = {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1};
        int expected = 24;
        test(height, expected);
    }

    @Test
    public void test6() {
        int[] height = {7, 6, 5, 4, 3, 2, 1};
        int expected = 12;
        test(height, expected);
    }

    @Test
    public void test7() {
        int[] height = {1, 2, 3, 4, 5, 5, 5, 5, 5};
        int expected = 20;
        test(height, expected);
    }

    @Test
    public void test8() {
        int[] height = {20, 1, 4, 3};
        int expected = 9;
        test(height, expected);
    }

    @Test
    public void test9() {
        int[] height = {20, 1, 4, 3, 2};
        int expected = 9;
        test(height, expected);
    }

    @Test
    public void test10() {
        int[] height = {20, 1, 4, 3, 2, 2};
        int expected = 10;
        test(height, expected);
    }

    @Test
    public void test11() {
        int[] height = {20, 1, 4, 3, 2, 1};
        int expected = 9;
        test(height, expected);
    }

    @Test
    public void test12() {
        int[] height = {1, 2, 3, 20, 2, 1, 3};
        int expected = 12;
        test(height, expected);
    }

    @Test
    public void test13() {
        int[] height = {1, 2, 3, 20, 2, 1, 3, 2, 10};
        int expected = 50;
        test(height, expected);
    }

    @Test
    public void test14() {
        int[] height = {1, 2, 5, 13, 14, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int expected = 16;
        test(height, expected);
    }

    @Test
    public void test15() {
        int[] height = {1, 3, 2, 5, 25, 24, 5};
        int expected = 24;
        test(height, expected);
    }

    @Test
    public void test16() {
        int[] height = {1, 3, 2, 5, 25, 26, 24, 5};
        int expected = 48;
        test(height, expected);
    }

    @Test
    public void test17() {
        int[] height = {1, 3, 10, 5, 25, 24, 5};
        int expected = 30;
        test(height, expected);
    }

    private static void test(int[] height, int expected) {
        int actual = maxArea(height);
        Assert.assertEquals(expected, actual);
    }

    public static int maxArea(int[] height) {
        int result = 0;
        int i1 = 0;
        int i2 = height.length - 1;
        int h1 = height[i1];
        int h2 = height[i2];
        while (i1 < i2) {
            int s = i2 - i1;
            if (h2 > h1) {
                s *= h1;
                h1 = height[++i1];
            } else {
                s *= h2;
                h2 = height[--i2];
            }
            if (s > result) {
                result = s;
            }
        }
        return result;
    }
}
