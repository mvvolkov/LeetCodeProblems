package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">209. Minimum Size Subarray Sum</a>
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
 * subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no
 * such subarray, return 0 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity
 * is O(n log(n)).
 */
public class MinimumSizeSubarraySumTest {

    @Test
    public void test1() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int expected = 2;
        test(target, nums, expected);
    }

    @Test
    public void test2() {
        int target = 4;
        int[] nums = {1, 4, 4};
        int expected = 1;
        test(target, nums, expected);
    }

    @Test
    public void test3() {
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int expected = 0;
        test(target, nums, expected);
    }

    @Test
    public void test4() {
        int target = 9;
        int[] nums = {1, 4, 4};
        int expected = 3;
        test(target, nums, expected);
    }

    @Test
    public void test5() {
        int target = 5;
        int[] nums = {2, 3, 1, 1, 1, 1, 1};
        int expected = 2;
        test(target, nums, expected);
    }


    @Test
    public void test6() {
        int target = 15;
        int[] nums = {2, 14};
        int expected = 2;
        test(target, nums, expected);
    }

    @Test
    public void test7() {
        int target = 15;
        int[] nums = {2, 14, 16};
        int expected = 1;
        test(target, nums, expected);
    }

    @Test
    public void test8() {
        int target = 15;
        int[] nums = {22, 14, 11};
        int expected = 1;
        test(target, nums, expected);
    }


    private static void test(int target, int[] nums, int expected) {
        int actual = minSubArrayLen(target, nums);
        Assert.assertEquals(expected, actual);
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int i1 = 0;
        int i2 = 0;
        int result = nums.length + 1;
        while (i2 < nums.length) {
            while (sum < target && i2 < nums.length) {
                sum += nums[i2++];
            }
            while (sum >= target) {
                int length = i2 - i1;
                if (length < result) {
                    result = length;
                }
                sum -= nums[i1++];
            }
        }
        if (result == nums.length + 1) {
            return 0;
        }
        return result;
    }
}
