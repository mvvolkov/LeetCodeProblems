package leetCode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
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
        return searchInsert(nums, 0, nums.length, target);
    }

    private static int searchInsert(int[] nums, int start, int end, int target) {

        if (start == end) {
            return end;
        }
        if (start + 1 == end) {
            int startValue = nums[start];
            return startValue >= target? start : end;
        }

        int middleIndex = start + (end - start) / 2;
        int middleValue = nums[middleIndex];

        if (middleValue > target) {
            return searchInsert(nums, start, middleIndex, target);
        } else if (middleValue < target) {
            return searchInsert(nums, middleIndex, end, target);
        } else {
            return middleIndex;
        }
    }
}
