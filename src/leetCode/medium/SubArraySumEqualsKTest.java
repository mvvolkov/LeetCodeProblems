package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Given an array of integers nums and an integer k, return the total number
 * of subarrays whose sum equals to k.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * <p>
 * <p>
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">https://leetcode.com/problems/subarray-sum-equals-k/</a>
 */
public class SubArraySumEqualsKTest {

    @Test
    public void test1() {
        int[] input = {1, 1, 1};
        int k = 2;
        int expected = 2;
        test(input, k, expected);
    }

    @Test
    public void test2() {
        int[] input = {1, 2, 3};
        int k = 3;
        int expected = 2;
        test(input, k, expected);
    }

    @Test
    public void test3() {
        int[] input = {-1, -1, 1};
        int k = 0;
        int expected = 1;
        test(input, k, expected);
    }

    @Test
    public void test4() {
        int[] input = {1, -1, 0};
        int k = 0;
        int expected = 3;
        test(input, k, expected);
    }

    @Test
    public void test5() {
        int[] input = {0, 0, 1, 2, 3};
        int k = 3;
        int expected = 4;
        test(input, k, expected);
    }

    private static void test(int[] input, int k, int expected) {
        System.out.println("input: " + Arrays.toString(input));
        System.out.println("k = " + k);
        int actual = subarraySum(input, k);
        Assert.assertEquals(expected, actual);
    }


    public static int subarraySum(int[] nums, int k) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                result++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }



    // Same task but use subsequence instead of subarray
//    private static class Subarray {
//        private final int sum;
//
//        private final int lastIndex;
//
//        private Subarray(int lastIndex, int sum) {
//            this.lastIndex = lastIndex;
//            this.sum = sum;
//        }
//    }


//    public static int subarraySum(int[] nums, int k) {
//        Arrays.sort(nums);
//
//        int result = 0;
//        Deque<Subarray> subarrays = new ArrayDeque<>();
//        for (int i = 0; i < nums.length; i++) {
//            int value = nums[i];
//            if (value > k) {
//                break;
//            }
//            if (value == k) {
//                result++;
//                continue;
//            }
//            subarrays.add(new Subarray(i, value));
//        }
//        while (!subarrays.isEmpty()) {
//            Deque<Subarray> nextLevelSubarrays = new ArrayDeque<>();
//            for (Subarray s : subarrays) {
//                for (int j = s.lastIndex + 1; j < nums.length; j++) {
//                    int value = nums[j] + s.sum;
//                    if (value > k) {
//                        break;
//                    }
//                    if (value == k) {
//                        result++;
//                        continue;
//                    }
//                    nextLevelSubarrays.add(new Subarray(j, value));
//                }
//            }
//            subarrays = nextLevelSubarrays;
//        }
//        return result;
//    }
}
