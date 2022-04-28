package leetCode.medium;

import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">https://leetcode.com/problems/longest-substring-without-repeating-characters/</a>
 * <p>
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharactersTest {

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

        char[] chars = s.toCharArray();
        int result = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (int j = start; j < i; j++) {
                if (chars[j] == c) {
                    int length = i - start;
                    if (length > result) {
                        result = length;
                    }
                    start = j + 1;
                    break;
                }
            }
        }
        int length = chars.length - start;
        return Math.max(length, result);
    }


}
