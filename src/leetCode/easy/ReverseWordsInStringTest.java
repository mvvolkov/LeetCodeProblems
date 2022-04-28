package leetCode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "God Ding"
 * Output: "doG gniD"
 */
public class ReverseWordsInStringTest {

    @Test
    public void test1() {
        String input = "Let's take LeetCode contest";
        String expected = "s'teL ekat edoCteeL tsetnoc";
        test(input, expected);
    }

    @Test
    public void test2() {
        String input = "God Ding";
        String expected = "doG gniD";
        test(input, expected);
    }

    private static void test(String input, String expected) {
        System.out.println("input: " + input);
        System.out.println("expected: " + expected);
        String actual = reverseWords(input);
        System.out.println("  actual: " + actual);
        assert expected.equals(actual);

    }

    private static String reverseWords(String s) {
        int left = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseString(chars, left, i - 1);
                left = i + 1;
            }
        }
        reverseString(chars, left, chars.length - 1);
        return new String(chars);
    }

    private static void reverseString(char[] s, int left, int right) {
        while (left < right) {
            char rightValue = s[right];
            s[right--] = s[left];
            s[left++] = rightValue;
        }
    }
}
