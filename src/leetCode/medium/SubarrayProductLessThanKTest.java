package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/subarray-product-less-than-k/">713. Subarray Product Less Than K</a>
 * <p>
 * <p>
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where
 * the product of all the elements in the subarray is strictly less than k.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */
public class SubarrayProductLessThanKTest {

    @Test
    public void test1() {
        int[] input = {10, 5, 2, 6};
        // 0-2 100 3
        // 1-4 60 6 - 1
        int k = 100;
        int expected = 8;
        test(input, k, expected);
    }

    @Test
    public void test2() {
        int[] input = {1, 2, 3};
        int k = 0;
        int expected = 0;
        test(input, k, expected);
    }

    @Test
    public void test3() {
        int[] input = {1, 8, 7, 3, 10, 2, 6, 5, 1};
        // 0-2  56  3
        // 2-4  210 3
        // 3-5  60 3 - 1
        // 4-6  120 3 - 1
        // 5-7  60  3 - 1
        // 6-9  30 6 - 1
        // 3 + 3 + 2 + 2 + 2 + 5 = 17
        int k = 40;
        int expected = 17;
        test(input, k, expected);
    }


    @Test
    public void test4() {
        int[] input = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        int expected = 18;
        test(input, k, expected);
    }

    @Test
    public void test5() {
        int[] input = {50, 3, 10, 2};
        int k = 40;
        int expected = 5;
        test(input, k, expected);
    }

    @Test
    public void test6() {
        int[] input = {50, 3, 10, 4};
        int k = 40;
        int expected = 4;
        test(input, k, expected);
    }

    @Test
    public void test7() {
        // 0-4 800  10
        // 1-5 320   10 - 6
        // 2-6 640  10 - 6
        // 4-8 1344  10 - 3
        // 6-9 588  6 -3
        // 7-10  6 - 3
        int[] input = {10, 2, 2, 5, 4, 4, 4, 3, 7, 7};
        int k = 289;
        int expected = 31;
        test(input, k, expected);
    }


    //[100,2,3,4,100,5,6,7,100]
    //100

    @Test
    public void test8() {
        int[] input = {100,2,3,4,100,5,6,7,100};
        int k = 100;
        int expected = 11;
        test(input, k, expected);
    }

    private static void test(int[] nums, int k, int expected) {
        int actual = numSubarrayProductLessThanK(nums, k);
        Assert.assertEquals(expected, actual);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        // i1 = 0
        // first subarray where product  >= k, i2 is next pointer, calc i2-i1
        // increase i1 while product >= k, calc i2-i1

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] < k ? 1 : 0;
        }
        int result = 0;
        int i1 = 0;
        int i2 = 0;
        int product = nums[i2];
        while (i2 < nums.length) {
            while (product < k) {
                if (i2 == nums.length - 1) {
                    i2++;
                    break;
                }
                product *= nums[++i2];
            }
            if (i2 == i1) {
                i2++;
                if (i2 == nums.length) {
                    break;
                }
                product = nums[i2];
                i1 = i2;
                continue;
            }
            int n = i2 - i1;
            while (product >= k && i2 - i1 > 0) {
                product /= nums[i1++];
            }
            int n1 = i2 != nums.length ? i2 - i1 : 0;
            result += (n - n1) * (n + n1 + 1);
        }
        return result / 2;
    }

}
