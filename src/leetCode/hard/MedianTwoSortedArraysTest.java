package leetCode.hard;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianTwoSortedArraysTest {

    @Test
    public void test1() {
        int[] input1 = {1, 3};
        int[] input2 = {2};
        double expected = 2.;
        test(input1, input2, expected);
    }

    @Test
    public void test2() {
        int[] input1 = {1, 2};
        int[] input2 = {3, 4};
        double expected = 2.5;
        test(input1, input2, expected);
    }

    @Test
    public void test3() {
        int[] input1 = {1, 2, 5};
        int[] input2 = {3, 4, 8, 9};
        double expected = 4.;
        test(input1, input2, expected);
    }

    @Test
    public void test4() {
        int[] input1 = {3, 4};
        int[] input2 = {1, 2};
        double expected = 2.5;
        test(input1, input2, expected);
    }

    @Test
    public void test5() {
        int[] input1 = {1, 3, 5, 7};
        int[] input2 = {7, 12};
        double expected = 6.;
        test(input1, input2, expected);
    }

    @Test
    public void test6() {
        // 1, 2, 3, 4, 5, 8, 9, 11, 13, 15, 17, 20, 23

        int[] input1 = {1, 2, 5, 9, 13, 17, 20, 23};
        int[] input2 = {3, 4, 8, 11, 15};
        double expected = 9.;
        test(input1, input2, expected);
    }

    @Test
    public void test7() {
        // 1, 2, 3, 4, 5, 8, 9, 11, 13, 15, 17, 20

        int[] input1 = {1, 2, 5, 9, 13, 17, 20};
        int[] input2 = {3, 4, 8, 11, 15};
        double expected = 8.5;
        test(input1, input2, expected);
    }

    @Test
    public void test8() {
        int[] input1 = {3, 4};
        int[] input2 = {};
        double expected = 3.5;
        test(input1, input2, expected);
    }

    @Test
    public void test9() {
        int[] input1 = {};
        int[] input2 = {2, 3};
        double expected = 2.5;
        test(input1, input2, expected);
    }

    @Test
    public void test10() {
        int[] input1 = {2, 2, 4, 4};
        int[] input2 = {2, 2, 4, 4, 4};
        double expected = 4.;
        test(input1, input2, expected);
    }

    @Test
    public void test11() {
        int[] input1 = {1, 2, 3, 4};
        int[] input2 = {3, 4, 7, 8, 9};
        double expected = 4.;
        test(input1, input2, expected);
    }

    @Test
    public void test12() {
        int[] input1 = {2, 2, 4, 4};
        int[] input2 = {2, 2, 4, 4};
        double expected = 3.;
        test(input1, input2, expected);
    }

    @Test
    public void test13() {
        int[] input1 = {1, 2, 6, 8};
        int[] input2 = {2, 4};
        double expected = 3.;
        test(input1, input2, expected);
    }

    @Test
    public void test14() {
        int[] input1 = {2, 6};
        int[] input2 = {2, 4};
        double expected = 3.;
        test(input1, input2, expected);
    }

    @Test
    public void test15() {
        int[] input1 = {3, 4};
        int[] input2 = {2, 4};
        double expected = 3.5;
        test(input1, input2, expected);
    }

    @Test
    public void test16() {
        int[] input1 = {1};
        int[] input2 = {1};
        double expected = 1.;
        test(input1, input2, expected);
    }

    @Test
    public void test17() {
        int[] input1 = {1};
        int[] input2 = {2};
        double expected = 1.5;
        test(input1, input2, expected);
    }

    @Test
    public void test18() {
        int[] input1 = {1, 2};
        int[] input2 = {-1, 3};
        double expected = 1.5;
        test(input1, input2, expected);
    }

    @Test
    public void test19() {
        int[] input1 = {5, 7};
        int[] input2 = {1, 9};
        double expected = 6.;
        test(input1, input2, expected);
    }

    @Test
    public void test20() {
        int[] input1 = {1, 1};
        int[] input2 = {1, 1};
        double expected = 1.;
        test(input1, input2, expected);
    }

    private static void test(int[] input1, int[] input2, double expected) {
        System.out.println("   input1: " + Arrays.toString(input1));
        System.out.println("   input2: " + Arrays.toString(input2));
        System.out.println("expected: " + expected);
        double actual = findMedianSortedArrays(input1, input2);
        System.out.println("  actual: " + actual);
        assert expected == actual;
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int s1 = nums1.length;
        int s2 = nums2.length;
        boolean isOdd1 = s1 % 2 == 1;
        boolean isOdd2 = s2 % 2 == 1;
        int s = s1 + s2;

        if (s1 == 0) {
            if (isOdd2) {
                return nums2[s2 / 2];
            }
            int i = s2 / 2 - 1;
            return 0.5 * (nums2[i] + nums2[i + 1]);
        }
        if (s2 == 0) {
            if (isOdd1) {
                return nums1[s1 / 2];
            }
            int i = s1 / 2 - 1;
            return 0.5 * (nums1[i] + nums1[i + 1]);
        }

        if (s1 == 1 && s2 == 1) {
            return 0.5 * (nums1[0] + nums2[0]);
        }

        if (!isOdd1 && !isOdd2) {
            int i1 = s1 / 2 - 1;
            int i2 = s2 / 2 - 1;
            int v1 = nums1[i1];
            int v2 = nums2[i2];
            if (v1 == v2) {
                int v3 = Math.min(nums1[i1 + 1], nums2[i2 + 1]);
                return 0.5 * (v1 + v3);
            }
        }
        boolean medianIsSingleValue = s % 2 == 1;
        int remainderSize = medianIsSingleValue ? s / 2 : s / 2 - 1;

        double l1 = getLeftMedian(nums1, nums2, remainderSize);
        if (l1 == 0.) {
            l1 = getLeftMedian(nums2, nums1, remainderSize);
        }
        if (medianIsSingleValue) {
            return l1;
        }
        double l2 = getRightMedian(nums1, nums2, remainderSize);
        if (l2 == 0.) {
            l2 = getRightMedian(nums2, nums1, remainderSize);
        }
        return 0.5 * (l1 + l2);
    }

    private static double getLeftMedian(int[] nums1, int[] nums2, int remainderSize) {
        int start = 0;
        int end = nums2.length;
        int s1 = nums1.length;
        while (start < end) {
            int i = start + (end - start) / 2;
            int v = nums2[i];
            int insertPosition = searchInsert(nums1, 0, s1, v);
            int currentRemainder = insertPosition + i;
            if (currentRemainder > remainderSize) {
                end = i;
            } else if (currentRemainder < remainderSize) {
                start = i + 1;
            } else {
                return v;
            }
        }
        return 0.;
    }

    private static double getRightMedian(int[] nums1, int[] nums2, int remainderSize) {
        int start = 0;
        int end = nums2.length;
        int s1 = nums1.length;
        int s2 = nums2.length;
        while (start < end) {
            int i2 = start + (end - start) / 2;
            int v = nums2[i2];
            int insertPosition1 = searchInsert(nums1, 0, s1, v);
            int currentRemainder = (s1 - insertPosition1) + (s2 - 1 - i2);
            if (currentRemainder > remainderSize) {
                start = i2 + 1;
            } else if (currentRemainder < remainderSize) {
                end = i2;
            } else {
                return v;
            }
        }
        return 0.;
    }

    private static double getTrivialMedian(int[] nums1, int[] nums2) {
        int s1 = nums1.length;
        int s2 = nums2.length;
        int s = s1 + s2;
        if (s % 2 == 1) {
            int i = s / 2;
            return i < s1 ? nums1[i] : nums2[i - s1];
        }
        int i1 = s / 2 - 1;
        int i2 = i1 + 1;
        int v1 = i1 < s1 ? nums1[i1] : nums2[i1 - s1];
        int v2 = i2 < s1 ? nums1[i2] : nums2[i2 - s1];
        return 0.5 * (v1 + v2);
    }


    private static int searchInsert(int[] nums, int start, int end, int target) {

        if (start == end) {
            return end;
        }
        if (start + 1 == end) {
            int startValue = nums[start];
            return startValue >= target ? start : end;
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
