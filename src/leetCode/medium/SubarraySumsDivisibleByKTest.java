package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">https://leetcode.com/problems/subarray-sums-divisible-by-k/</a>
 * <p>
 * Given an integer array nums and an integer k, return the number of non-empty subarrays
 * that have a sum divisible by k.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [5], k = 9
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 */
public class SubarraySumsDivisibleByKTest {

    @Test
    public void test1() {
        int[] input = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int expected = 7;
        test(input, k, expected);
    }

    @Test
    public void test2() {
        int[] input = {5};
        int k = 9;
        int expected = 0;
        test(input, k, expected);
    }

    @Test
    public void test3() {
        int[] input = {-1, 2, 9};
        int k = 2;
        int expected = 2;
        test(input, k, expected);
    }

    @Test
    public void test4() {
        int[] input = {2, -2, 2, -4};
        int k = 6;
        int expected = 2;
        test(input, k, expected);
    }

    @Test
    public void test5() {
        int[] input = {7, -5, 5, -8, -6, 6, -4, 7, -8, -7};
        int k = 7;
        int expected = 11;
        test(input, k, expected);
        /*
          7 = 7
          7, -5, 5 = 7
             -5, 5 = 0
          7, -5, 5, -8, -6 = -7
             -5, 5, -8, -6 = -14
                    -8, -6 = -14
                        -6, 6 = 0
                 5, -8, -6, 6, -4 = -7
                 5, -8, -6, 6, -4, 7 = 0
                                   7 = 7
                                      -7 = -7
         */
    }

    public static int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int key = sum % k;
            if (key < 0) {
                key = key + k;
            }
            int value = map.getOrDefault(key, 0);
            if (value != 0) {
                count += value++;
                map.put(key, value);
            } else {
                map.put(key, 1);
            }
        }
        return count;
    }

    private static void test(int[] input, int k, int expected) {
        int actual = subarraysDivByK(input, k);
        Assert.assertEquals(expected, actual);
    }
}
