package leetCode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">https://leetcode.com/problems/longest-substring-without-repeating-characters/</a>
 */
public class LongestSubstringTest {

    @Test
    public void test1() {
        String input = "abcabcbb";
        int expected = 3;
        test(input, expected);
    }

    @Test
    public void test2() {
        String input = "bbbbb";
        int expected = 1;
        test(input, expected);
    }

    @Test
    public void test3() {
        String input = "pwwkew";
        int expected = 3;
        test(input, expected);
    }

    private static void test(String input, int expected) {
        System.out.println("   input: " + input);
        System.out.println("expected: " + expected);
        int actual = lengthOfLongestSubstring(input);
        System.out.println("  actual: " + actual);
        assert expected == actual;
    }

    public static int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end = 0;

        char[] chars = s.toCharArray();

        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            boolean found = false;
            for (int j = start; j < end; j++) {
                if (chars[j] == c) {
                    found = true;
                    start = j + 1;
                    end = i + 1;
                    break;
                }
            }
            if (!found) {
                end = i + 1;
                int length = end - start;
                if (length > result) {
                    result = length;
                }
            }
        }

        return result;
    }


}
