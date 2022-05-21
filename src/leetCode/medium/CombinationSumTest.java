package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">39. Combination Sum</a>
 * <p>
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations in any
 * order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique
 * if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations
 * for the given input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * <p>
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * Example 3:
 * <p>
 * Input: candidates = [2], target = 1
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 */
public class CombinationSumTest {

    @Test
    public void test1() {
        int[] input = {2, 3, 6, 7};
        int target = 7;
        int[][] expected = {{2, 2, 3}, {7}};
        test(input, target, expected);
    }

    @Test
    public void test2() {
        int[] input = {2, 3, 5};
        int target = 8;
        int[][] expected = {{2, 2, 2, 2}, {2, 3, 3}, {3, 5}};
        test(input, target, expected);
    }

    @Test
    public void test3() {
        int[] input = {2};
        int target = 1;
        int[][] expected = {};
        test(input, target, expected);
    }

    private static void test(int[] candidates, int target, int[][] expected) {

        List<List<Integer>> actualList = combinationSum(candidates, target);
        Assert.assertNotNull(actualList);
        Assert.assertEquals(expected.length, actualList.size());
        for (int[] array : expected) {
            boolean found = false;
            for (List<Integer> list : actualList) {
                if (compareListAndArray(list, array)) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue("not found " + Arrays.toString(array), found);
        }
    }

    private static boolean compareListAndArray(List<Integer> list, int[] array) {
        HashMap<Integer, Integer> result1 = new HashMap<>(list.size());
        for (Integer i : list) {
            Integer n = result1.get(i);
            if (n == null) {
                n = 0;
            }
            result1.put(i, n + 1);
        }
        HashMap<Integer, Integer> result2 = new HashMap<>(list.size());
        for (int i : array) {
            Integer n = result2.get(i);
            if (n == null) {
                n = 0;
            }
            result2.put(i, n + 1);
        }
        return result1.equals(result2);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, result, List.of(), 0, 0);
        return result;
    }

    private static void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentList, int index, int sum) {
        for (int i = index; i < candidates.length; i++) {
            int value = candidates[i];
            int s = sum + value;
            if (s > target) {
                continue;
            }
            List<Integer> list = new ArrayList<>(currentList);
            list.add(value);
            if (s == target) {
                result.add(list);
            } else {
                combinationSum(candidates, target, result, list, i, s);
            }
        }
    }
}
