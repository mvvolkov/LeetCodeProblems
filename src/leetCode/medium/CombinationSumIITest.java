package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/">40. Combination Sum II</a>
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSumIITest {

    @Test
    public void test1() {
        int[] input = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        int[][] expected = {{1, 1, 6}, {1, 2, 5}, {1, 7}, {2, 6}};
        test(input, target, expected);
    }

    @Test
    public void test2() {
        int[] input = {2, 5, 2, 1, 2};
        int target = 5;
        int[][] expected = {{1, 2, 2}, {5}};
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

        List<List<Integer>> actualList = combinationSum2(candidates, target);
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

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, result, List.of(), 0, 0);
        return result;
    }

    private static void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentList, int index, int sum) {
        int prevValue = -1;
        for (int i = index; i < candidates.length; i++) {
            int value = candidates[i];
            if (prevValue == value) {
                continue;
            }
            prevValue = value;
            int s = sum + value;
            if (s > target) {
                break;
            }
            List<Integer> list = new ArrayList<>(currentList);
            list.add(value);
            if (s == target) {
                result.add(list);
            } else {
                combinationSum(candidates, target, result, list, i + 1, s);
            }
        }
    }
}
