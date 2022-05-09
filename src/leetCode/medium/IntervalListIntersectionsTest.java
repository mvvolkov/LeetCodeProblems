package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/interval-list-intersections/">986. Interval List Intersections</a>
 * <p>
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi]
 * and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 * <p>
 * Return the intersection of these two interval lists.
 * <p>
 * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * <p>
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented
 * as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * <p>
 * Example 2:
 * <p>
 * Input: firstList = [[1,3],[5,9]], secondList = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= firstList.length, secondList.length <= 1000
 * firstList.length + secondList.length >= 1
 * 0 <= starti < endi <= 109
 * endi < starti+1
 * 0 <= startj < endj <= 109
 * endj < startj+1
 */
public class IntervalListIntersectionsTest {

    @Test
    public void test1() {
        int[][] first = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] second = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] expected = {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}};
        test(first, second, expected);
    }

    @Test
    public void test2() {
        int[][] first = {{1, 3}, {5, 9}};
        int[][] second = {};
        int[][] expected = {};
        test(first, second, expected);
    }

    @Test
    public void test3() {
        int[][] first = {{1, 1}, {2, 5}, {7, 9}};
        int[][] second = {{2, 5}};
        int[][] expected = {{2, 5}};
        test(first, second, expected);
    }

    private static void test(int[][] firstList, int[][] secondList, int[][] expected) {
        int[][] actual = intervalIntersection(firstList, secondList);
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i]);
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }
        int[] result = new int[2 * (firstList.length + secondList.length)];
        int k = 0;
        int i2 = 0;
        int start2 = secondList[i2][0];
        int end2 = secondList[i2][1];
        for (int[] ints : firstList) {
            int start1 = ints[0];
            int end1 = ints[1];
            while (start2 <= end1) {
                if (end2 >= start1) {
                    result[k++] = Math.max(start1, start2);
                    result[k++] = Math.min(end1, end2);
                    if (end1 < end2) {
                        break;
                    }
                }
                i2++;
                if (i2 >= secondList.length) {
                    break;
                }
                start2 = secondList[i2][0];
                end2 = secondList[i2][1];
            }
        }
        int[][] res = new int[k/2][2];
        for (int i = res.length-1; i >=0; i--) {
            res[i][1] = result[--k];
            res[i][0] = result[--k];
        }
        return res;
    }
}
