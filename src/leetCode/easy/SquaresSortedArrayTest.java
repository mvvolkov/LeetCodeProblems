package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">https://leetcode.com/problems/squares-of-a-sorted-array/</a>
 * <p>
 * 977. Squares of a Sorted Array
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares
 * of each number sorted in non-decreasing order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */
public class SquaresSortedArrayTest {

    @Test
    public void test1() {
        int[] input = {-4, -1, 0, 3, 10};
        int[] expected = {0, 1, 9, 16, 100};
        test(input, expected);
    }

    @Test
    public void test2() {
        int[] input = {-7, -3, 2, 3, 11};
        int[] expected = {4, 9, 9, 49, 121};
        test(input, expected);
    }

    @Test
    public void test3() {
        int[] input = {-2};
        int[] expected = {4};
        test(input, expected);
    }

    @Test
    public void test4() {
        int[] input = {2};
        int[] expected = {4};
        test(input, expected);
    }

    @Test
    public void test5() {
        int[] input = {-5, -3, -2, -1};
        int[] expected = {1, 4, 9, 25};
        test(input, expected);
    }

    private static void test(int[] input, int[] expected) {
        System.out.println("input: " + Arrays.toString(input));
        System.out.println("expected: " + Arrays.toString(expected));
        int[] actual = sortedSquares(input);
        System.out.println("  actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }

    public static int[] sortedSquares(int[] nums) {

        int size = nums.length;
        int left = 0;
        int right = size - 1;
        int leftValue = nums[left];
        int rightValue = nums[right];
        int[] result = new int[size];
        int k = right;
        while (leftValue < 0 && rightValue >= 0) {
            if (rightValue > -leftValue) {
                result[k--] = rightValue * rightValue;
                rightValue = nums[--right];
            } else {
                result[k--] = leftValue * leftValue;
                leftValue = nums[++left];
            }
        }
        if (leftValue >= 0) {
            for (int i = right; i >= left; i--) {
                leftValue = nums[i];
                result[k--] = leftValue * leftValue;
            }
            return result;
        }
        for (int i = left; i <= right; i++) {
            rightValue = nums[i];
            result[k--] = rightValue * rightValue;
        }
        return result;
    }
}
