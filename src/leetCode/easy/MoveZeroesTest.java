package leetCode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">https://leetcode.com/problems/move-zeroes/</a>
 * <p>
 * 283. Move Zeroes
 * <p>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of
 * the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class MoveZeroesTest {

    @Test
    public void test1() {
        int[] input = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        test(input, expected);
    }

    @Test
    public void test2() {
        int[] input = {0};
        int[] expected = {0};
        test(input, expected);
    }

    @Test
    public void test3() {
        int[] input = {0, 1, 0, 0, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0, 0, 0};
        test(input, expected);
    }

    private static void test(int[] nums, int[] expected) {
        System.out.println("   input: " + Arrays.toString(nums));
        System.out.println("expected: " + Arrays.toString(expected));
        moveZeroes(nums);
        System.out.println("  actual: " + Arrays.toString(nums));
        assert Arrays.equals(nums, expected);
    }

    public static void moveZeroes(int[] nums) {

        int size = nums.length;
        int firstZero = 0;
        for (; firstZero < size; firstZero++) {
            if (nums[firstZero] == 0) {
                break;
            }
        }
        int k = firstZero;
        for (int i = firstZero + 1; i < size; i++) {
            int value = nums[i];
            if (value != 0) {
                nums[k++] = value;
            }
        }
        while (k < size) {
            nums[k++] = 0;
        }
    }
}
