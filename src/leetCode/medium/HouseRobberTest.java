package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/house-robber/">https://leetcode.com/problems/house-robber/</a>
 * <p>
 * 198. House Robber
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobberTest {

    @Test
    public void test1() {
        int[] input = {1, 2, 3, 1};
        int expected = 4;
        test(input, expected);
    }

    @Test
    public void test2() {
        int[] input = {2, 7, 9, 3, 1};
        int expected = 12;
        test(input, expected);
    }

    @Test
    public void test3() {
        int[] input = {8, 1, 2, 7};
        int expected = 15;
        test(input, expected);
    }

    @Test
    public void test4() {
        int[] input = {1, 8, 1, 2, 7};
        int expected = 15;
        test(input, expected);
    }

    @Test
    public void test5() {
        int[] input = {1, 1, 8, 1, 2, 7};
        int expected = 16;
        test(input, expected);
    }

    @Test
    public void test6() {
        int[] input = {226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191,
                68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55,
                122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77,
                223, 188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82,
                35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124};
        int expected = 7102;
        test(input, expected);
    }

    @Test
    public void test7() {
        int[] input = {1, 1, 1};
        int expected = 2;
        test(input, expected);
    }

    private static void test(int[] input, int expected) {
        int actual = rob(input);
        Assert.assertEquals(expected, actual);
    }

    public static int rob(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        if (size > 2) {
            nums[size - 3] = nums[size - 3] + nums[size - 1];
        }
        for (int i = size - 4; i >= 0; i--) {
            nums[i] = nums[i] + Math.max(nums[i + 2], nums[i + 3]);
        }
        return Math.max(nums[0], nums[1]);
    }
}
