package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * There is a long table with a line of plates and candles arranged on top of it.
 * You are given a 0-indexed string s consisting of characters '*' and '|' only,
 * where a '*' represents a plate and a '|' represents a candle.
 * <p>
 * You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti]
 * denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the number
 * of plates between candles that are in the substring. A plate is considered between candles
 * if there is at least one candle to its left and at least one candle to its right in the substring.
 * <p>
 * For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|".
 * The number of plates between candles in this substring is 2, as each of the two plates
 * has at least one candle in the substring to its left and right.
 * <p>
 * Return an integer array answer where answer[i] is the answer to the ith query.
 *
 *
 * <a href="https://leetcode.com/problems/plates-between-candles/">https://leetcode.com/problems/plates-between-candles/</a>
 */
public class PlatesBetweenCandlesTest {

    @Test
    public void test1() {
        String s = "***|**|*****|**||**|*";
        int[][] queries = new int[][]{{4, 5}, {14, 17}, {1, 17}, {5, 11}, {15, 16}};
        int[] expected = new int[]{0, 0, 9, 0, 0};
        test(s, queries, expected);
    }

    @Test
    public void test2() {
        String s = "**|**|***|";
        int[][] queries = new int[][]{{2, 5}, {5, 9}};
        int[] expected = new int[]{2, 3};
        test(s, queries, expected);
    }

    @Test
    public void test3() {
        String s = "***************";
        int[][] queries = new int[][]{{4, 5}, {5, 11}};
        int[] expected = new int[]{0, 0};
        test(s, queries, expected);
    }

    @Test
    public void test4() {
        String s = "********|*******";
        int[][] queries = new int[][]{{4, 5}, {11, 13}, {6, 12}};
        int[] expected = new int[]{0, 0, 0};
        test(s, queries, expected);
    }

    @Test
    public void test5() {
        String s = "|***************|";
        int[][] queries = new int[][]{{4, 5}, {11, 13}, {0, 16}};
        int[] expected = new int[]{0, 0, 15};
        test(s, queries, expected);
    }

    @Test
    public void test6() {
        String s = "*|*||||**|||||||*||*||*||**|*|*||*";
        int[][] queries = new int[][]{
                {2, 33}, {2, 32}, {3, 31}, {0, 33}, {1, 24}, {3, 20}, {7, 11}, {5, 32}, {2, 31},
                {5, 31}, {0, 31}, {3, 28}, {4, 33}, {6, 29}, {2, 30}, {2, 28}, {1, 30}, {1, 33},
                {4, 32}, {5, 30}, {4, 23}, {0, 30}, {3, 10}, {5, 28}, {0, 28}, {4, 28}, {3, 33}, {0, 27}};
        int[] expected = new int[]{9, 9, 9, 10, 6, 4, 0, 9, 9, 9, 10, 7, 9, 8, 8, 7, 9, 10, 9, 8, 5, 9, 2, 7, 8, 7, 9, 8};
        test(s, queries, expected);
    }

    private static void test(String s, int[][] queries, int[] expected) {
        System.out.println("expected:" + Arrays.toString(expected));
        int[] actual = platesBetweenCandles(s, queries);
        System.out.println("  actual:" + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }


    public static int[] platesBetweenCandles(String s, int[][] queries) {

        int stringLength = s.length();
        int[] candlesFromStart = new int[stringLength];
        int[] nextCandles = new int[stringLength];
        int[] prevCandles = new int[stringLength];
        int candles = 0;
        int prevCandle = -1;
        for (int i = 0; i < stringLength; i++) {
            if (s.charAt(i) == '|') {
                prevCandle = i;
                candles++;
            }
            prevCandles[i] = prevCandle;
            candlesFromStart[i] = candles;
        }
        int nextCandle = -1;
        for (int i = stringLength - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                nextCandle = i;
            }
            nextCandles[i] = nextCandle;
        }
        int length = queries.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            int firstCandle = nextCandles[query[0]];
            int lastCandle = prevCandles[query[1]];
            if (firstCandle != -1 && lastCandle != -1 && lastCandle > firstCandle) {
                result[i] = (lastCandle - firstCandle) - (candlesFromStart[lastCandle] - candlesFromStart[firstCandle]);
            }
        }
        return result;
    }
}
