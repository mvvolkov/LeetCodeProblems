package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/</a>
 * <p>
 * 153. Find Minimum in Rotated Sorted Array
 * <p>
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * <p>
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
 * [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 */
public class FindMinimumInRotatedSortedArrayTest {

    @Test
    public void test1() {
        int[] input = {3, 4, 5, 1, 2};
        int expected = 1;
        test(input, expected);
    }

    @Test
    public void test2() {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int expected = 0;
        test(input, expected);
    }

    @Test
    public void test3() {
        int[] input = {11, 13, 15, 17};
        int expected = 11;
        test(input, expected);
    }

    private static void test(int[] nums, int expected) {
        int actual = findMin(nums);
        Assert.assertEquals(expected, actual);
    }

    /**
     * See also {@link SearchInRotatedSortedArrayTest#getPivotIndex(int[])}
     */
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[end] >= nums[start]) {
            return nums[0];
        }
        while (start + 1 < end) {
            int m = (start + end) / 2;
            if (nums[m] < nums[start]) {
                end = m;
            } else {
                start = m;
            }
        }
        return nums[end];
    }
}
