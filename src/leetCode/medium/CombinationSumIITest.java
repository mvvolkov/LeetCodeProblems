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

    @Test
    public void test4() {
        int[] input = {3, 1, 3, 5, 1, 1};
        int target = 8;
        int[][] expected = {{1, 1, 1, 5}, {1, 1, 3, 3}, {3, 5}};
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
        int[] stack = new int[candidates.length];
        int size = 0;
        int index = -1;
        int sum = 0;
        int prevValue = -1;
        while (index + 1 < candidates.length || size > 0) {
            if (index + 1 == candidates.length) {
                index = stack[--size];
                prevValue = candidates[index];
                sum -= prevValue;
                continue;
            }
            int value = candidates[index + 1];
            if (value == prevValue) {
                index++;
                continue;
            }
            int newSum = sum + value;
            if (newSum < target) {
                index++;
                stack[size++] = index;
                sum = newSum;
                prevValue = -1;
            } else {
                if (newSum == target) {
                    List<Integer> list = new ArrayList<>(size);
                    for (int i = 0; i < size; i++) {
                        list.add(candidates[stack[i]]);
                    }
                    list.add(value);
                    result.add(list);
                }
                if (size == 0) {
                    break;
                }
                index = stack[--size];
                prevValue = candidates[index];
                sum -= prevValue;
            }
        }
        return result;
    }
}
