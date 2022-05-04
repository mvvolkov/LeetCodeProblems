package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">https://leetcode.com/problems/search-in-rotated-sorted-array/</a>
 * <p>
 * 33. Search in Rotated Sorted Array
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot
 * index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of
 * target if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1], target = 0
 * Output: -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */
public class SearchInRotatedSortedArrayTest {

    @Test
    public void test1() {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expected = 4;
        test(input, target, expected);
    }

    @Test
    public void test2() {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expected = -1;
        test(input, target, expected);
    }

    @Test
    public void test3() {
        int[] input = {1};
        int target = 0;
        int expected = -1;
        test(input, target, expected);
    }

    @Test
    public void test4() {
        int[] input = {8, 9, 10, 11, 12, 13, 14, 15, 16, 0, 1, 2, 3, 4, 5, 6, 7};
        int target = 14;
        int expected = 6;
        test(input, target, expected);
    }

    @Test
    public void test5() {
        int[] input = {8, 9, 10, 11, 12, 13, 14, 15, 16, 0, 1, 2, 3, 4, 5, 6, 7};
        int target = 0;
        int expected = 9;
        test(input, target, expected);
    }

    @Test
    public void test6() {
        int[] input = {8, 9, 10, 11, 12, 13, 14, 15, 16, 0, 1, 2, 3, 4, 5, 6, 7};
        int target = 2;
        int expected = 11;
        test(input, target, expected);
    }

    private static void test(int[] input, int target, int expected) {
        int actual = search(input, target);
        Assert.assertEquals(expected, actual);
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int pivotIndex = getPivotIndex(nums);
        return search(nums, target, pivotIndex);
    }

    private static int getPivotIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[end] >= nums[start]) {
            return 0;
        }
        while (start + 1 < end) {
            int m = (start + end) / 2;
            if (nums[m] < nums[start]) {
                end = m;
            } else {
                start = m;
            }
        }
        return end;
    }

    private static int rotatedIndex(int size, int pivotIndex, int index) {
        return index >= (size - pivotIndex) ? index - (size - pivotIndex) : index + pivotIndex;
    }

    public static int search(int[] nums, int target, int pivot) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int m = (start + end) / 2;
            int rm = rotatedIndex(nums.length, pivot, m);
            int mv = nums[rm];
            if (mv > target) {
                end = m - 1;
            } else if (mv < target) {
                start = m + 1;
            } else {
                return rm;
            }
        }
        return -1;
    }
}
