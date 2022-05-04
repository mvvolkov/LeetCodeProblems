package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/">https://leetcode.com/problems/merge-sorted-array/</a>
 * <p>
 * 88. Merge Sorted Array
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that
 * should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * <p>
 * Example 3:
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1.
 * The 0 is only there to ensure the merge result can fit in nums1.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class MergeSortedArrayTest {

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};
        test(nums1, m, nums2, n, expected);
    }

    @Test
    public void test2() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {1};
        test(nums1, m, nums2, n, expected);
    }

    @Test
    public void test3() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        int[] expected = {1};
        test(nums1, m, nums2, n, expected);
    }

    @Test
    public void test4() {
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6, 8, 9};
        int n = 5;
        int[] expected = {1, 2, 2, 3, 5, 6, 8, 9};
        test(nums1, m, nums2, n, expected);
    }

    @Test
    public void test5() {
        int[] nums1 = {1, 5, 8, 0, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 3, 6, 7, 9};
        int n = 5;
        int[] expected = {1, 2, 3, 5, 6, 7, 8, 9};
        test(nums1, m, nums2, n, expected);
    }

    @Test
    public void test6() {
        int[] nums1 = {6, 10, 15, 0, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 3, 5, 7, 12};
        int n = 5;
        int[] expected = {1, 3, 5, 6, 7, 10, 12, 15};
        test(nums1, m, nums2, n, expected);
    }

    @Test
    public void test7() {
        int[] nums1 = {1, 3, 5, 7, 12, 0, 0, 0};
        int m = 5;
        int[] nums2 = {6, 10, 15};
        int n = 3;
        int[] expected = {1, 3, 5, 6, 7, 10, 12, 15};
        test(nums1, m, nums2, n, expected);
    }

    private static void test(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(expected, nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int k = n + m - 1;
        m--;
        n--;
        int left = nums1[m--];
        int right = nums2[n--];
        while (true) {
            if (right > left) {
                nums1[k--] = right;
                if (n < 0) {
                    nums1[k--] = left;
                    break;
                }
                right = nums2[n--];
            } else {
                nums1[k--] = left;
                if (m < 0) {
                    nums1[k--] = right;
                    break;
                }
                left = nums1[m--];
            }
        }
        while (m >= 0) {
            nums1[k--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[k--] = nums2[n--];
        }
    }
}
