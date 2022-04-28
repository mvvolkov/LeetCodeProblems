package leetCode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/">https://leetcode.com/problems/search-insert-position/</a>
 * <p>
 * 35. Search Insert Position
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class SearchInsertPositionTest {

    @Test
    public void test1() {
        int[] input = {1, 3, 5, 6};
        int target = 5;
        int expected = 2;
        test(input, target, expected);
    }

    @Test
    public void test2() {
        int[] input = {1, 3, 5, 6};
        int target = 2;
        int expected = 1;
        test(input, target, expected);
    }

    @Test
    public void test3() {
        int[] input = {1, 3, 5, 6};
        int target = 7;
        int expected = 4;
        test(input, target, expected);
    }

    @Test
    public void test4() {
        int[] input = {3, 5, 6};
        int target = 1;
        int expected = 0;
        test(input, target, expected);
    }

    @Test
    public void test5() {
        int[] input = {1, 3, 5, 6};
        int target = 0;
        int expected = 0;
        test(input, target, expected);
    }

    @Test
    public void test6() {
        int[] input = {1, 3};
        int target = 2;
        int expected = 1;
        test(input, target, expected);
    }

    @Test
    public void test7() {
        int[] input = {1, 2, 5};
        int target = 6;
        int expected = 3;
        test(input, target, expected);
    }


    private static void test(int[] nums, int target, int expected) {
        System.out.println("input array: " + Arrays.toString(nums));
        System.out.println("target: " + target);
        System.out.println("expected: " + expected);
        int actual = searchInsert(nums, target);
        System.out.println("  actual: " + actual);
        assert expected == actual;
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        }
        int size = nums.length;
        if (nums[size - 1] < target) {
            return size;
        }
        int left = 0;
        int right = size - 1;
        while (left + 1 < right) {
            int middleIndex = left + (right - left) / 2;
            int middleValue = nums[middleIndex];
            if (middleValue >= target) {
                right = middleIndex;
            } else {
                left = middleIndex;
            }
        }
        return right;
    }
}
