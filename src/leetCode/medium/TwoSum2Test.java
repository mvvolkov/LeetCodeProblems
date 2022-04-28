package leetCode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/</a>
 * <p>
 * 167. Two Sum II - Input Array Is Sorted
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers
 * be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2]
 * of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Example 2:
 * <p>
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Example 3:
 * <p>
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */
public class TwoSum2Test {

    @Test
    public void test1() {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 2};
        test(input, target, expected);
    }

    @Test
    public void test2() {
        int[] input = {2, 3, 4};
        int target = 6;
        int[] expected = {1, 3};
        test(input, target, expected);
    }

    @Test
    public void test3() {
        int[] input = {-1, 0};
        int target = -1;
        int[] expected = {1, 2};
        test(input, target, expected);
    }

    @Test
    public void test4() {
        int[] input = {2, 7, 11, 15, 16, 18, 21, 23, 25, 30, 32, 36, 38};
        int target = 37;
        int[] expected = {2, 10};
        test(input, target, expected);
    }

    @Test
    public void test5() {
        int[] input = {2, 7, 11, 15, 16, 18, 21, 23, 25, 30, 33, 36, 38};
        int target = 39;
        int[] expected = {5, 8};
        test(input, target, expected);
    }

    @Test
    public void test6() {
        int[] input = {2, 7, 11, 15, 16, 18, 21, 23, 25, 30, 33, 36, 38};
        int target = 9;
        int[] expected = {1, 2};
        test(input, target, expected);
    }

    @Test
    public void test7() {
        int[] input = {2, 7, 11, 15, 16, 18, 21, 23, 25, 30, 33, 36, 38};
        int target = 69;
        int[] expected = {11, 12};
        test(input, target, expected);
    }

    private static void test(int[] input, int target, int[] expected) {
        System.out.println("input: " + Arrays.toString(input));
        System.out.println("target: " + target);
        System.out.println("expected: " + Arrays.toString(expected));
        int[] actual = twoSum(input, target);
        System.out.println("  actual: " + Arrays.toString(actual));
        assert Arrays.equals(actual, expected);
    }

    private static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int leftValue = numbers[left];
        int rightValue = numbers[right];
        int sum = leftValue + rightValue;
        while (sum != target) {
            int middle = left + (right - left) / 2;
            int middleValue = numbers[middle];
            if (sum > target) {
                while (true) {
                    int middleSum = leftValue + middleValue;
                    if (middleSum > target) {
                        right = middle;
                        rightValue = middleValue;
                        break;
                    } else if (middleSum < target) {
                        if (middle + 1 == right) {
                            rightValue = numbers[--right];
                            break;
                        }
                        middle = middle + (right - middle) / 2;
                        middleValue = numbers[middle];
                    } else {
                        return new int[]{left + 1, middle + 1};
                    }
                }
            } else {
                while (true) {
                    int middleSum = middleValue + rightValue;
                    if (middleSum < target) {
                        left = middle;
                        leftValue = middleValue;
                        break;
                    } else if (middleSum > target) {
                        if (left + 1 == middle) {
                            leftValue = numbers[++left];
                            break;
                        }
                        middle = left + (middle - left) / 2;
                        middleValue = numbers[middle];
                    } else {
                        return new int[]{middle + 1, right + 1};
                    }
                }
            }
            sum = leftValue + rightValue;
        }
        return new int[]{left + 1, right + 1};
    }
}
