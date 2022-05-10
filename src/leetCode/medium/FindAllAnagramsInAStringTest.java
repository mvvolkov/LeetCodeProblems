package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">438. Find All Anagrams in a String</a>
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
public class FindAllAnagramsInAStringTest {

    @Test
    public void test1() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> expected = Arrays.asList(0, 6);
        test(s, p, expected);
    }

    @Test
    public void test2() {
        String s = "abab";
        String p = "ab";
        List<Integer> expected = Arrays.asList(0, 1, 2);
        test(s, p, expected);
    }

    private static void test(String s, String p, List<Integer> expected) {
        List<Integer> actual = findAnagrams(s, p);
        Assert.assertEquals(expected, actual);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        char[] pChars = p.toCharArray();
        char[] sChars = s.toCharArray();
        int[] pattern = new int[26];
        for (char c : pChars) {
            pattern[c - 'a']++;
        }
        int[] sample = new int[26];
        for (int i = 0; i < pChars.length; i++) {
            sample[sChars[i] - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        boolean match = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] != sample[i]) {
                match = false;
                break;
            }
        }
        if (match) {
            result.add(0);
        }
        int j = 0;
        for (int i = pChars.length; i < sChars.length; i++) {
            sample[sChars[i] - 'a']++;
            sample[sChars[j++] - 'a']--;
            match = true;
            for (int k = 0; k < pattern.length; k++) {
                if (pattern[k] != sample[k]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result.add(j);
            }
        }
        return result;
    }
}
