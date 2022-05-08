package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/backspace-string-compare/">844. Backspace String Compare</a>
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * <p>
 * Example 3:
 * <p>
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 * <p>
 * <p>
 * <p>
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackspaceStringCompareTest {

    @Test
    public void test1() {
        String s = "ab#c";
        String t = "ad#c";
        boolean expected = true;
        test(s, t, expected);
    }

    @Test
    public void test2() {
        String s = "ab##";
        String t = "c#d#";
        boolean expected = true;
        test(s, t, expected);
    }

    @Test
    public void test3() {
        String s = "a#c";
        String t = "b";
        boolean expected = false;
        test(s, t, expected);
    }

    @Test
    public void test4() {
        String s = "a###c";
        String t = "b#c";
        boolean expected = true;
        test(s, t, expected);
    }

    @Test
    public void test5() {
        String s = "baaa###c";
        String t = "bd#c";
        boolean expected = true;
        test(s, t, expected);
    }

    @Test
    public void test6() {
        String s = "abc#de###f";
        String t = "af";
        boolean expected = true;
        test(s, t, expected);
    }

    @Test
    public void test7() {
        String s = "xywrrmp";
        String t = "xywrrmu#p";
        boolean expected = true;
        test(s, t, expected);
    }


    @Test
    public void test8() {
        String s = "bxj##tw";
        String t = "bxj###tw";
        boolean expected = false;
        test(s, t, expected);
    }

    @Test
    public void test9() {
        String s = "nzp#o#g";
        String t = "b#nzp#o#g";
        boolean expected = true;
        test(s, t, expected);
    }


    @Test
    public void test10() {
        String s = "bbbextm";
        String t = "bbb#extm";
        boolean expected = false;
        test(s, t, expected);
    }


    private static void test(String s, String t, boolean expected) {
        boolean actual = backspaceCompare(s, t);
        Assert.assertEquals(expected, actual);
    }

    public static boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int ps = sChars.length - 1;
        int pt = tChars.length - 1;
        while (ps >= -1 && pt >= -1) {
            ps = getNextChar(sChars, ps);
            pt = getNextChar(tChars, pt);
            if (ps == -1 || pt == -1) {
                return ps == pt;
            }
            if (sChars[ps] != tChars[pt]) {
                return false;
            }
            ps--;
            pt--;
        }
        return ps == pt;
    }

    private static int getNextChar(char[] chars, int p) {
        if (p == -1) {
            return p;
        }
        char c = chars[p];
        int bs = 0;
        while (c == '#') {
            bs++;
            if (p == 0) {
                return -1;
            }
            c = chars[--p];
        }
        while (bs > 0) {
            if (p == 0) {
                return -1;
            }
            c = chars[--p];
            if (c == '#') {
                bs++;
            } else {
                bs--;
            }
        }
        return p;
    }

}
