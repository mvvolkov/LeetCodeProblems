package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/">15. 3Sum</a>
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such
 * that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSumTest {

    @Test
    public void test1() {
        int[] nums = {-1, 0, 1, 2, -1, -4, -1};
        int[][] expected = {{-1, -1, 2}, {-1, 0, 1}};
        test(nums, expected);
    }

    @Test
    public void test2() {
        int[] nums = {};
        int[][] expected = {};
        test(nums, expected);
    }

    @Test
    public void test3() {
        int[] nums = {0};
        int[][] expected = {};
        test(nums, expected);
    }

    @Test
    public void test4() {
        int[] nums = {3, -2, 1, 0};
        int[][] expected = {};
        test(nums, expected);
    }

    @Test
    public void test5() {
        int[] nums = {-2, 0, 1, 1, 2};
        int[][] expected = {{-2, 0, 2}, {-2, 1, 1}};
        test(nums, expected);
    }

    @Test
    public void test6() {
        int[] nums = {3, 0, -2, -1, 1, 2};
        int[][] expected = {{-2, -1, 3}, {-2, 0, 2}, {-1, 0, 1}};
        test(nums, expected);
    }

    @Test
    public void test7() {
        int[] nums = {0, 0, 0, 0, 0, 0};
        int[][] expected = {{0, 0, 0}};
        test(nums, expected);
    }


    @Test
    public void test8() {
        int[] nums = {0, 1, 2, 0, -3, -2};
        int[][] expected = {{1, 2, -3}, {-2, 0, 2}};
        test(nums, expected);
    }

    @Test
    public void test9() {
        int[] nums = {-1, 0, 1, 2, -1, -4, -1, -3, 3, 5, 7};
        int[][] expected = {{-1, -1, 2}, {-1, 0, 1}, {-3, 0, 3}, {-4, 3, 1}, {-3, 1, 2}, {-4, -3, 7}, {-4, 5, -1}};
        test(nums, expected);
    }

    @Test
    public void test10() {
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        int[][] expected = {{-4, 0, 4}, {-4, 1, 3}, {-3, -1, 4}, {-3, 0, 3}, {-3, 1, 2}, {-2, -1, 3}, {-2, 0, 2}, {-1, -1, 2}, {-1, 0, 1}};
        test(nums, expected);
    }

    @Test
    public void test11() {
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4, 1};
        int[][] expected = {{-4, 0, 4}, {-4, 1, 3}, {-3, -1, 4}, {-3, 0, 3}, {-3, 1, 2}, {-2, -1, 3}, {-2, 0, 2}, {-1, -1, 2}, {-1, 0, 1}, {-2, 1, 1}};
        test(nums, expected);
    }

    private static void test(int[] nums, int[][] expected) {
        List<List<Integer>> actual = threeSum(nums);
        for (int[] e : expected) {
            List<Integer> foundList = null;
            for (List<Integer> list : actual) {
                if (intListEqualsToArray(list, e)) {
                    foundList = list;
                    break;
                }
            }
            Assert.assertNotNull(foundList);
            actual.remove(foundList);
        }
        Assert.assertTrue(actual.isEmpty());
    }

    private static boolean intListEqualsToArray(List<Integer> list, int[] expected) {
        List<Integer> copy = new ArrayList<>(list);
        for (int i : expected) {
            int k = copy.indexOf(i);
            if (k == -1) {
                return false;
            }
            copy.remove(k);
        }
        return copy.isEmpty();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int i1 = 0;
        int maxI1 = nums.length - 2;
        int v1 = nums[0];
        while (v1 <= 0 && i1 < maxI1) {
            int i2 = nums.length - 1;
            int v2 = nums[nums.length - 1];
            int v3 = -(v1 + v2);
            int k = i1;
            while (v3 <= v2 && i2 >= k + 2 && v2 >= 0) {
                k = Arrays.binarySearch(nums, k + 1, i2, v3);
                if (k >= 0) {
                    result.add(Arrays.asList(v1, v3, v2));
                } else {
                    k = -k - 2;
                }
                int next2 = nums[--i2];
                while (next2 == v2 && i2 > 0) {
                    next2 = nums[--i2];
                }
                v2 = next2;
                v3 = -(v1 + v2);
            }
            int next1 = nums[++i1];
            while (next1 == v1 && i1 < maxI1) {
                next1 = nums[++i1];
            }
            v1 = next1;
        }
        return result;
    }
}
