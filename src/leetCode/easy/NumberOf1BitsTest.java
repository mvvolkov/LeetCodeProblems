package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/number-of-1-bits/">https://leetcode.com/problems/number-of-1-bits/</a>
 * <p>
 * Write a function that takes an unsigned integer and returns the number of '1' bits
 * it has (also known as the Hamming weight).
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case,
 * the input will be given as a signed integer type. It should not affect your implementation,
 * as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore,
 * in Example 3, the input represents the signed integer. -3.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * <p>
 * Example 3:
 * <p>
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The input must be a binary string of length 32.
 * <p>
 * <p>
 * Follow up: If this function is called many times, how would you optimize it?
 */
public class NumberOf1BitsTest {

    @Test
    public void test1() {
        int n = 0b0000000000000000000000000001011;
        int expected = 3;
        test(n, expected);
    }

    @Test
    public void test2() {
        int n = 0b00000000000000000000000010000000;
        int expected = 1;
        test(n, expected);
    }

    @Test
    public void test3() {
        int n = 0b11111111111111111111111111111101;
        int expected = 31;
        test(n, expected);
    }

    private static void test(int input, int expected) {
        int actual = hammingWeight(input);
        Assert.assertEquals(expected, actual);
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n >>>= 1;
        }
        return result;
    }
}
