package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 2
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: a = 2, b = 3
 * Output: 5
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -1000 <= a, b <= 1000
 * <p>
 * <a href="https://leetcode.com/problems/sum-of-two-integers/">https://leetcode.com/problems/sum-of-two-integers/</a>
 */
public class SumTwoIntegersTest {

    @Test
    public void test1() {
        int a = 2;
        int b = 3;
        test(a, b, a + b);
    }

    @Test
    public void test2() {
        int a = 1;
        int b = 2;
        test(a, b, a + b);
    }

    @Test
    public void test3() {
        int a = 6;
        int b = -3;
        test(a, b, a + b);
    }

    @Test
    public void test4() {
        int a = 14;
        int b = -7;
        test(a, b, a + b);
    }

    @Test
    public void test5() {
        int a = -1;
        int b = 0;
        test(a, b, a + b);
    }

    private static void test(int a, int b, int expected) {
        int actual = getSum(a, b);
        Assert.assertEquals(expected, actual);
    }

    public static int getSum(int a, int b) {
        int maxValue = Math.max(a, b);
        int minValue = Math.min(a, b);
        if (maxValue <= 0) {
            return -getSum1(-maxValue, -minValue);
        }
        if (minValue < 0) {
            return getDiff(maxValue, -minValue);
        }
        return getSum1(a, b);
    }

    private static int getDiff(int a, int b) {
        int diff = 0;
        int shift = 0;
        boolean nextDegree = false;
        while (a != 0 || b != 0) {
            int a1 = a & 1;
            int b1 = b & 1;
            int result;
            boolean x = false;
            if (a1 == 1) {
                if (b1 == 1) {
                    result = 0;
                } else {
                    result = 1;
                }
            } else {
                if (b1 == 1) {
                    result = 1;
                    x = true;
                } else {
                    result = 0;
                }
            }
            if (nextDegree) {
                if (result == 1) {
                    result = 0;
                    nextDegree = x;
                } else {
                    result = 1;
                }
            } else {
                nextDegree = x;
            }
            diff = diff | (result << shift);
            shift++;
            a >>= 1;
            b >>= 1;
        }
        return diff;
    }

    public static int getSum1(int a, int b) {

        int sum = 0;
        int shift = 0;
        boolean nextDegree = false;
        while (a != 0 || b != 0) {
            int a1 = a & 1;
            int b1 = b & 1;
            int result;
            boolean x = false;
            if (a1 == 1) {
                if (b1 == 1) {
                    result = 0;
                    x = true;
                } else {
                    result = 1;
                }
            } else {
                if (b1 == 1) {
                    result = 1;
                } else {
                    result = 0;
                }
            }
            if (nextDegree) {
                if (result == 1) {
                    result = 0;
                } else {
                    result = 1;
                    nextDegree = x;
                }
            } else {
                nextDegree = x;
            }
            sum = sum | (result << shift);
            shift++;
            a >>= 1;
            b >>= 1;
        }
        if (nextDegree) {
            sum = sum | (1 << shift);
        }
        return sum;
    }
}
