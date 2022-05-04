package leetCode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/">https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/</a>
 * <p>
 * 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void test1() {
        int[] input = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = {3, 4};
        test(input, target, expected);
    }

    @Test
    public void test2() {
        int[] input = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expected = {-1, -1};
        test(input, target, expected);
    }

    @Test
    public void test3() {
        int[] input = {};
        int target = 0;
        int[] expected = {-1, -1};
        test(input, target, expected);
    }

    @Test
    public void test4() {
        int[] input = {5, 7, 7, 8, 8, 10};
        int target = 7;
        int[] expected = {1, 2};
        test(input, target, expected);
    }

    @Test
    public void test5() {
        int[] input = {1};
        int target = 0;
        int[] expected = {-1, -1};
        test(input, target, expected);
    }

    @Test
    public void test6() {
        int[] input = {1};
        int target = 1;
        int[] expected = {0, 0};
        test(input, target, expected);
    }

    @Test
    public void test7() {
        int[] input = {2, 2};
        int target = 2;
        int[] expected = {0, 1};
        test(input, target, expected);
    }

    @Test
    public void test8() {
        int[] input = {1, 3};
        int target = 1;
        int[] expected = {0, 0};
        test(input, target, expected);
    }

    @Test
    public void test9() {
        int[] input = {1, 2, 2};
        int target = 2;
        int[] expected = {1, 2};
        test(input, target, expected);
    }

    private static void test(int[] input, int target, int[] expected) {
        System.out.println("input:  " + Arrays.toString(input));
        System.out.println("target = " + target);
        System.out.println("expected: " + Arrays.toString(expected));
        int[] actual = searchRange(input, target);
        System.out.println("  actual: " + Arrays.toString(actual));
        assert Arrays.equals(expected, actual);
    }


    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return searchRange(nums, target, 0, nums.length - 1);
    }

    private static int[] searchRange(int[] nums, int target, int i1, int i2) {

        if (i2 - i1 < 2) {
            int v1 = nums[i1];
            int v2 = nums[i2];
            if (v1 == target) {
                return v2 == target ? new int[]{i1, i2} : new int[]{i1, i1};
            } else if (v2 == target) {
                return new int[]{i2, i2};
            } else {
                return new int[]{-1, -1};
            }
        }

        int m = i1 + (i2 - i1) / 2;
        int vm = nums[m];
        if (vm > target) {
            return searchRange(nums, target, i1, m);
        } else if (vm < target) {
            return searchRange(nums, target, m, i2);
        } else {
            i1 = nums[i1] == target ? i1 : getStart(nums, target, i1, m, true);
            i2 = nums[i2] == target ? i2 : getStart(nums, target, m, i2, false);
            return new int[]{i1, i2};
        }
    }

    private static int getStart(int[] nums, int target, int i1, int i2, boolean left) {
        if (i1 + 1 == i2) {
            return left ? i2 : i1;
        }
        int m = i1 + (i2 - i1) / 2;
        int vm = nums[m];
        if (vm < target) {
            return getStart(nums, target, m, i2, left);
        } else if (vm > target) {
            return getStart(nums, target, i1, m, left);
        } else {
            if (left) {
                return getStart(nums, target, i1, m, left);
            } else {
                return getStart(nums, target, m, i2, left);
            }
        }
    }
}
