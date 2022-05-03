package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/letter-case-permutation/">https://leetcode.com/problems/letter-case-permutation/</a>
 * <p>
 * 784. Letter Case Permutation
 * <p>
 * Given a string s, you can transform every letter individually to be lowercase or uppercase
 * to create another string.
 * <p>
 * Return a list of all possible strings we could create. Return the output in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 12
 * s consists of lowercase English letters, uppercase English letters, and digits.
 */
public class LetterCasePermutationTest {

    @Test
    public void test1() {
        String input = "a1b2";
        List<String> expected = Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2");
        test(input, expected);
    }

    @Test
    public void test2() {
        String input = "3z4";
        List<String> expected = Arrays.asList("3z4", "3Z4");
        test(input, expected);
    }

    private static void test(String input, List<String> expected) {
        List<String> actual = letterCasePermutation(input);
        Assert.assertEquals(new HashSet<>(actual).size(), actual.size());
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.size(), actual.size());
        for (String a : actual) {
            Assert.assertTrue(expected.contains(a));
        }
    }

    public static List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        List<String> result = new ArrayList<>();
        result.add(s);
        permute(result, chars, 0);
        return result;
    }

    private static void permute(List<String> result, char[] chars, int start) {
        while (start < chars.length) {
            char c = chars[start];
            if (flipAndPermute(result, chars, start, c, false)) {
                break;
            }
            if (flipAndPermute(result, chars, start, c, true)) {
                break;
            }
            start++;
        }
    }

    private static boolean flipAndPermute(List<String> result, char[] chars, int start, char c, boolean lower) {
        char oldChar = lower ? 'a' : 'A';
        int index = c - oldChar;
        if (index < 0 || index >= 26) {
            return false;
        }
        permute(result, chars, start + 1);
        char[] chars1 = Arrays.copyOf(chars, chars.length);
        char newChar = lower ? (char) ('A' + index) : (char) ('a' + index);
        chars1[start] = newChar;
        result.add(new String(chars1));
        permute(result, chars1, start + 1);
        return true;
    }
}
