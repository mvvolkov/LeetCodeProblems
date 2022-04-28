package leetCode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroesTest {


    //Example 1:
    //
    //Input: nums = [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    //
    //Example 2:
    //
    //Input: nums = [0]
    //Output: [0]

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

        int k = 0;
        int size = nums.length;
        boolean zeroFound = false;
        for (int i = 0; i < size; i++) {
            int value = nums[i];
            if (value != 0) {
                if (zeroFound) {
                    nums[k] = value;
                }
                k++;
            } else {
                zeroFound = true;
            }
        }
        while (k < size) {
            nums[k++] = 0;
        }
    }
}
