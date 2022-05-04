package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/reverse-bits/">https://leetcode.com/problems/reverse-bits/</a>
 * <p>
 * 190. Reverse Bits
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case,
 * both input and output will be given as a signed integer type. They should not affect your
 * implementation, as the integer's internal binary representation is the same, whether it is
 * signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 2 above, the input represents the signed integer -3 and the output
 * represents the signed integer -1073741825.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents
 * the unsigned integer 43261596, so return 964176192 which its binary representation
 * is 00111001011110000010100101000000.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned
 * integer 4294967293, so return 3221225471 which its binary representation
 * is 10111111111111111111111111111111.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The input must be a binary string of length 32
 * <p>
 * <p>
 * <p>
 * Follow up: If this function is called many times, how would you optimize it?
 */
public class ReverseBitsTest {

    @Test
    public void test1() {
        int n = 0b00000010100101000001111010011100;
        int expected = 964176192;
        test(n, expected);
    }

    @Test
    public void test2() {
        int n = 0b11111111111111111111111111111101;
        int expected = -1073741825;
        test(n, expected);
    }

    private static void test(int n, int expected) {
        int actual = reverseBits(n);
        Assert.assertEquals(expected, actual);
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {

        int result = 0;
        int k = 32;
        while (k > 0) {
            result <<= 1;
            if ((n & 1) == 1) {
                result++;
            }
            n >>>= 1;
            k--;
        }
        return result;
    }
}
