package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/power-of-two/">https://leetcode.com/problems/power-of-two/</a>
 * <p>
 * 231. Power of Two
 * <p>
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * <p>
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 * <p>
 * Example 2:
 * <p>
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: false
 */
public class PowerOfTwoTest {

    @Test
    public void test1() {
        int n = 1;
        boolean expected = true;
        test(n, expected);
    }

    @Test
    public void test2() {
        int n = 16;
        boolean expected = true;
        test(n, expected);
    }

    @Test
    public void test3() {
        int n = 3;
        boolean expected = false;
        test(n, expected);
    }

    @Test
    public void test4() {
        int n = 0;
        boolean expected = false;
        test(n, expected);
    }

    private static void test(int n, boolean expected) {
        boolean actual = isPowerOfTwo(n);
        Assert.assertEquals(expected, actual);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while ((n & 1) != 1) {
            n >>= 1;
        }
        return n == 1;
    }

}
