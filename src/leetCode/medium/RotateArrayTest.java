package leetCode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p>
 * <p>
 * 1,2,3,4,5,6,7,8,9,10,11,12,13
 * <p>
 * 11,12,13,4,5,6,7,8,9,10,1,2,3  3
 * <p>
 * 11,12,13,1,2,3,7,8,9,10,4,5,6  3
 * <p>
 * 11,12,13,1,2,3,4,5,6,10,7,8,9  3
 * <p>
 * 11,12,13,1,2,3,4,5,6,7,8,9,10  3
 *
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * <p>
 * Try to come up with as many solutions as you can.
 * There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArrayTest {

    @Test
    public void test1() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        test(input, k, expected);
    }

    @Test
    public void test2() {
        int[] input = {-1, -100, 3, 99};
        int k = 2;
        int[] expected = {3, 99, -1, -100};
        test(input, k, expected);
    }

    @Test
    public void test3() {
        int[] input = {-1, -100, 3, 99};
        int k = input.length;
        int[] expected = {-1, -100, 3, 99};
        test(input, k, expected);
    }

    @Test
    public void test4() {
        int[] input = {1, 2};
        int k = input.length + 1;
        int[] expected = {2, 1};
        test(input, k, expected);
    }

    @Test
    public void test5() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
        int k = 38;
        int[] expected = {17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        test(input, k, expected);
    }

    @Test
    public void test6() {
        int[] input = {1, 2, 3};
        int k = 2;
        int[] expected = {2, 3, 1};
        test(input, k, expected);
    }

    //[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21]
    //29

    @Test
    public void test7() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        int k = 29;
        int[] expected = {14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        test(input, k, expected);
    }


    private static void test(int[] input, int k, int[] expected) {
        System.out.println("input: " + Arrays.toString(input));
        System.out.println("k = " + k);
        System.out.println("expected: " + Arrays.toString(expected));
        rotate(input, k);
        System.out.println("  actual: " + Arrays.toString(input));
        assert Arrays.equals(expected, input);
    }

    public static void rotate1(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        while (k-- > 0) {
            int prev = nums[0];
            nums[0] = nums[size - 1];
            for (int j = 0; j < size - 1; j++) {
                int t = nums[j + 1];
                nums[j + 1] = prev;
                prev = t;
            }
        }
    }

    /**
     * 1, 2, 3, 4, 5, 6, 7
     * <p>
     * 5,6,7,4,1,2,3
     */
    public static void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        int start = 0;
        int rightShift = size - k;
        while (k > 0) {
            for (int i = 0; i < k; i++) {
                int i1 = start + i;
                int i2 = rightShift + i;
                int v2 = nums[i2];
                nums[i2] = nums[i1];
                nums[i1] = v2;
            }
            start += k;
            int remainder = size - start;
            if (k > remainder) {
                if (remainder == 0) {
                    break;
                }
                k = k % remainder;
                rightShift = size - k;
            }
        }
    }

}
