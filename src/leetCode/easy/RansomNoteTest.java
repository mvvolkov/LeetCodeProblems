package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/ransom-note/">https://leetcode.com/problems/ransom-note/</a>
 * <p>
 * 383. Ransom Note
 * <p>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed
 * from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * <p>
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNoteTest {

    @Test
    public void test1() {
        String ransomNote = "a";
        String magazine = "b";
        boolean canConstruct = false;
        test(ransomNote, magazine, canConstruct);
    }

    @Test
    public void test2() {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean canConstruct = false;
        test(ransomNote, magazine, canConstruct);
    }

    @Test
    public void test3() {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean canConstruct = true;
        test(ransomNote, magazine, canConstruct);
    }

    private void test(String ransomNote, String magazine, boolean expected) {
        System.out.println("ransomNote = " + ransomNote);
        System.out.println("magazine = " + magazine);
        System.out.println("expected: " + expected);
        boolean actual = canConstruct(ransomNote, magazine);
        System.out.println("  actual: " + actual);
        Assert.assertEquals(expected, actual);
    }

    private static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (char c : magazine.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (chars[c - 'a']-- == 0) {
                return false;
            }
        }
        return true;
    }
}
