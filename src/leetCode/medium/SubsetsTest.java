package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/">78. Subsets</a>
 * <p>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class SubsetsTest {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        int[][] expected = {{}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {1, 2, 3}};
        test(nums, expected);
    }

    @Test
    public void test2() {
        int[] nums = {0};
        int[][] expected = {{}, {0}};
        test(nums, expected);
    }

    @Test
    public void test3() {
        int[] nums = {};
        int[][] expected = {{}};
        test(nums, expected);
    }


    private static void test(int[] nums, int[][] expected) {
        List<List<Integer>> actualList = subsets(nums);
        Assert.assertNotNull(actualList);
        Assert.assertEquals(expected.length, actualList.size());
        for (int i = 0; i < expected.length; i++) {
            List<Integer> list = actualList.get(i);
            for (int j = 0; j < expected[i].length; j++) {
                Assert.assertEquals(expected[i][j], (int) list.get(j));
            }
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(1 << nums.length);
        result.add(List.of());
        for (int num : nums) {
            addSubsets(result, num);
        }
        return result;
    }

    private static void addSubsets(List<List<Integer>> result, int next) {
        List<List<Integer>> newSubsets = new ArrayList<>(result.size());
        for (List<Integer> list : result) {
            List<Integer> newList = new ArrayList<>(list.size() + 1);
            newList.addAll(list);
            newList.add(next);
            newSubsets.add(newList);
        }
        result.addAll(newSubsets);
    }
}
