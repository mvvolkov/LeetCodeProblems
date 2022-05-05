package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-peak-element/">https://leetcode.com/problems/find-peak-element/</a>
 * <p>
 * 162. Find Peak Element
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given an integer array nums, find a peak element, and return its index. If the array contains
 * multiple peaks, return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index
 * number 5 where the peak element is 6.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */
public class FindPeakElementTest {

    @Test
    public void test1() {
        int[] input = {1, 2, 3, 1};
        int[] expected = {2};
        test(input, expected);
    }

    @Test
    public void test2() {
        int[] input = {1, 2, 1, 3, 5, 6, 4};
        int[] expected = {1, 5};
        test(input, expected);
    }

    @Test
    public void test3() {
        int[] input = {1, 2, 1, 3, 4, 5, 6};
        int[] expected = {1, 6};
        test(input, expected);
    }

    @Test
    public void test4() {
        int[] input = {1, 3, 4, 2};
        int[] expected = {2};
        test(input, expected);
    }

    @Test
    public void test5() {
        int[] input = {1};
        int[] expected = {0};
        test(input, expected);
    }

    @Test
    public void test6() {
        int[] input = {1, 2};
        int[] expected = {1};
        test(input, expected);
    }

    private static void test(int[] input, int[] expected) {
        int actual = findPeakElement(input);
        boolean found = false;
        for (int i : expected) {
            if (i == actual) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(actual + " not found in" + Arrays.toString(expected), found);
    }

    public static int findPeakElement(int[] nums) {
        int start = -1;
        int end = nums.length;
        int mid = start + (end - start) / 2;
        return findPeakElement(nums, start, end, mid, nums[mid]);
    }

    /**
     * Contract: nums[mid] > nums[start] && nums[mid] > num[end]
     */
    private static int findPeakElement(int[] nums, int start, int end, int mid, int midValue) {

        if (mid > start + 1) {
            int newMid = start + (mid - start) / 2;
            int newMidValue = nums[newMid];
            if (newMidValue > midValue) {
                return findPeakElement(nums, start, mid, newMid, newMidValue);
            } else {
                return findPeakElement(nums, newMid, end, mid, midValue);
            }
        } else {
            if (mid + 1 == end) {
                return mid;
            }
            int newMid = mid + (end - mid) / 2;
            int newMidValue = nums[newMid];
            if (newMidValue > midValue) {
                return findPeakElement(nums, mid, end, newMid, newMidValue);
            } else {
                return findPeakElement(nums, start, newMid, mid, midValue);
            }
        }
    }

}
