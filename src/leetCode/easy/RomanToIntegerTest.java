package leetCode.easy;

import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/">https://leetcode.com/problems/roman-to-integer/</a>
 * <p>
 * 13. Roman to Integer
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies
 * to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToIntegerTest {


    @Test
    public void test1() {
        String input = "III";
        int expectedOutput = 3;
        test(input, expectedOutput);
    }

    @Test
    public void test2() {
        String input = "LVIII";
        int expectedOutput = 58;
        test(input, expectedOutput);
    }

    @Test
    public void test3() {
        String input = "MCMXCIV";
        int expectedOutput = 1994;
        test(input, expectedOutput);
    }

    @Test
    public void test4() {
        String input = "MCMXCVI";
        int expectedOutput = 1996;
        test(input, expectedOutput);
    }


    private void test(String input, int expectedOutput) {
        System.out.println("expected: " + input + " -> " + expectedOutput);
        int actual = romanToInt(input);
        System.out.println("  actual: " + input + " -> " + actual);
        assert actual == expectedOutput;
    }


    public static int romanToInt(String s) {

        int result = 0;
        int i = s.length() - 1;
        char prevChar = s.charAt(i);
        while (i > 0) {
            char charValue = prevChar;
            i--;
            prevChar = s.charAt(i);
            int replacement = getReplacement(prevChar, charValue);
            if (replacement == -1) {
                result += getValue(charValue);
                continue;
            }
            result += replacement;
            i--;
            if (i >= 0) {
                prevChar = s.charAt(i);
            }
        }
        if (i == 0) {
            result += getValue(prevChar);
        }
        return result;
    }

    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    private static int getReplacement(char leftChar, char rightChar) {
        if (leftChar == 'I') {
            if (rightChar == 'V') {
                return 4;
            }
            if (rightChar == 'X') {
                return 9;
            }
        }
        if (leftChar == 'X') {
            if (rightChar == 'L') {
                return 40;
            }
            if (rightChar == 'C') {
                return 90;
            }
        }
        if (leftChar == 'C') {
            if (rightChar == 'D') {
                return 400;
            }
            if (rightChar == 'M') {
                return 900;
            }
        }
        return -1;
    }
}
