package leetCode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combinations/">77. Combinations</a>
 * <p>
 * 77. Combinations
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1, k = 1
 * Output: [[1]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class CombinationsTest {

    @Test
    public void test1() {
        int n = 5;
        int k = 5;
        test(n, k);
    }

    private static void test(int n, int k) {
        List<List<Integer>> actual = combine(n, k);
        System.out.println(actual);
    }


    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>(k);
        for (int i = 1; i <= k; i++) {
            combination.add(i);
        }
        int offset = n - k + 1;
        while (combination != null) {
            result.add(combination);
            combination = getNextCombination(combination, k, offset);
        }
        return result;
    }


    private static List<Integer> getNextCombination(List<Integer> current, int k, int offset) {
        int m = -1;
        int lastValue = -1;
        for (int i = k - 1; i >= 0; i--) {
            lastValue = current.get(i);
            if (lastValue != offset + i) {
                m = i;
                break;
            }
        }
        if (m == -1) {
            return null;
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < m; i++) {
            result.add(current.get(i));
        }
        lastValue++;
        for (int i = m; i < k; i++) {
            result.add(lastValue++);
        }
        return result;
    }
}
