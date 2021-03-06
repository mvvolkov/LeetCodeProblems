package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/binary-search/">https://leetcode.com/problems/binary-search/</a>
 * <p>
 * 704. Binary Search
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */
public class BinarySearchTest {

    @Test
    public void test1() {
        int[] input = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int expected = 4;
        test(input, target, expected);
    }

    @Test
    public void test2() {
        int[] input = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int expected = -1;
        test(input, target, expected);
    }

    private static void test(int[] input, int target, int expected) {
        int actual = search(input, target);
        Assert.assertEquals(expected, actual);
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int m = (start + end) / 2;
            int mv = nums[m];
            if (mv > target) {
                end = m - 1;
            } else if (mv < target) {
                start = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
