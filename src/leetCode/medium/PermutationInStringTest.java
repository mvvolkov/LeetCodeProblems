package leetCode.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class PermutationInStringTest {

    @Test
    public void test1() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean expected = true;
        test(s1, s2, expected);
    }

    @Test
    public void test2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean expected = false;
        test(s1, s2, expected);
    }


    @Test
    public void test3() {
        String s1 = "adc";
        String s2 = "dcda";
        boolean expected = true;
        test(s1, s2, expected);
    }


    private static void test(String s1, String s2, boolean expected) {
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("expected: " + expected);
        boolean actual = checkInclusion(s1, s2);
        System.out.println("  actual: " + actual);
        assert expected == actual;
    }

    public static boolean checkInclusion(String s1, String s2) {

        int patternSize = s1.length();
        int inputSize = s2.length();
        int diff = inputSize - patternSize;
        if (diff < 0) {
            return false;
        }
        int[] pattern = new int[26];
        int[] current = new int[26];
        for (int i = 0; i < patternSize; i++) {
            pattern[s1.charAt(i) - 'a']++;
            current[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pattern, current)) {
            return true;
        }
        for (int i = 0; i < diff; i++) {
            char first = s2.charAt(i);
            char next = s2.charAt(i + patternSize);
            if (first == next) {
                continue;
            }
            current[next - 'a']++;
            current[first - 'a']--;
            if (Arrays.equals(pattern, current)) {
                return true;
            }
        }
        return false;
    }
}
