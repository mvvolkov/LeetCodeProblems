package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/single-number/">https://leetcode.com/problems/single-number/</a>
 * <p>
 * 136. Single Number
 * <p>
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumberTest {

    @Test
    public void test1() {
        int[] input = {2, 2, 1};
        int expected = 1;
        test(input, expected);
    }

    @Test
    public void test2() {
        int[] input = {1};
        int expected = 1;
        test(input, expected);
    }

    @Test
    public void test3() {
        int[] input = {4, 1, 2, 1, 2};
        int expected = 4;
        test(input, expected);
    }

    private static void test(int[] input, int expected) {
        int actual = singleNumber(input);
        Assert.assertEquals(expected, actual);
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
