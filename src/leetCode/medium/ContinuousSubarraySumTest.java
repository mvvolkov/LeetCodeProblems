package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size
 * at least two whose elements sum up to a multiple of k, or false otherwise.
 * <p>
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 * <p>
 * <p>
 * <a href="https://leetcode.com/problems/continuous-subarray-sum/">https://leetcode.com/problems/continuous-subarray-sum/</a>
 */
public class ContinuousSubarraySumTest {

    @Test
    public void test1() {
        int[] input = {23, 2, 4, 6, 7};
        int k = 6;
        boolean expected = true;
        test(input, k, expected);
    }

    @Test
    public void test2() {
        int[] input = {23, 2, 6, 4, 7};
        int k = 6;
        boolean expected = true;
        test(input, k, expected);
    }

    @Test
    public void test3() {
        int[] input = {23, 2, 6, 4, 7};
        int k = 13;
        boolean expected = false;
        test(input, k, expected);
    }

    @Test
    public void test4() {
        int[] input = {23, 2, 4, 6, 6};
        int k = 7;
        boolean expected = true;
        test(input, k, expected);
    }

    @Test
    public void test5() {
        int[] input = {1, 0};
        int k = 2;
        boolean expected = false;
        test(input, k, expected);
    }

    @Test
    public void test6() {
        int[] input = {5, 0, 0, 0};
        int k = 3;
        boolean expected = true;
        test(input, k, expected);
    }

    @Test
    public void test7() {
        int[] input = {3, 0};
        int k = 3;
        boolean expected = true;
        test(input, k, expected);
    }

    @Test
    public void test8() {
        int[] input = {0};
        int k = 1;
        boolean expected = false;
        test(input, k, expected);
    }

    @Test
    public void test9() {
        int[] input = {1, 2, 12};
        int k = 6;
        boolean expected = false;
        test(input, k, expected);
    }

    @Test
    public void test10() {
        int[] input = {1, 0, 1, 0, 1};
        int k = 4;
        boolean expected = false;
        test(input, k, expected);
    }

    @Test
    public void test11() {
        int[] input = {1, 3, 0, 6};
        int k = 6;
        boolean expected = true;
        test(input, k, expected);
    }


    private static void test(int[] input, int k, boolean expected) {
        boolean actual = checkSubarraySum(input, k);
        Assert.assertEquals(expected, actual);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        boolean prevIsZero = false;
        int prevKey = -1;
        for (int num : nums) {
            if (num == 0) {
                if (prevIsZero || (sum % k == 0 && !set.isEmpty())) {
                    return true;
                }
                prevIsZero = true;
                prevKey = 0;
                continue;
            }
            sum += num;
            int key = sum % k;
            if ((key == 0 && !set.isEmpty()) || (prevKey != key && set.contains(key))) {
                return true;
            }
            prevKey = key;
            prevIsZero = false;
            set.add(key);
        }
        return false;
    }
}
