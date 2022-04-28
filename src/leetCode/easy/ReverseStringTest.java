package leetCode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseStringTest {

    @Test
    public void test1() {
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        char[] expected = {'o', 'l', 'l', 'e', 'h'};
        test(input, expected);
    }

    @Test
    public void test2() {
        char[] input = {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] expected = {'h', 'a', 'n', 'n', 'a', 'H'};
        test(input, expected);
    }

    private static void test(char[] input, char[] expected) {
        System.out.println("input: " + Arrays.toString(input));
        System.out.println("expected: " + Arrays.toString(expected));
        reverseString(input);
        System.out.println("  actual: " + Arrays.toString(input));
        assert Arrays.equals(input, expected);

    }

    private static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char rightValue = s[right];
            s[right--] = s[left];
            s[left++] = rightValue;
        }
    }
}
