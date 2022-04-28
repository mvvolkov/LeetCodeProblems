package leetCode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
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
        assert Arrays.equals(expected, actual);
    }

    public static int[] sortedSquares(int[] nums) {

        int size = nums.length;
        int left = 0;
        int right = size - 1;
        int leftValue = nums[left];
        boolean noMoreNegatives = leftValue >= 0;
        leftValue = leftValue * leftValue;
        int rightValue = nums[right];
        rightValue = rightValue * rightValue;
        int[] result = new int[size];
        int i = size - 1;
        while (left <= right) {
            if (noMoreNegatives || leftValue < rightValue) {
                result[i--] = rightValue;
                if(right==0){
                    break;
                }
                right--;
                rightValue = nums[right];
                rightValue = rightValue * rightValue;
            } else {
                result[i--] = leftValue;
                if (left == size - 1) {
                    break;
                }
                left++;
                leftValue = nums[left];
                noMoreNegatives = leftValue >= 0;
                leftValue = leftValue * leftValue;
            }
        }
        return result;
    }


}
