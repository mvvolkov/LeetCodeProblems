package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">https://leetcode.com/problems/permutations/</a>
 * <p>
 * 46. Permutations
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class PermutationsTest {

    @Test
    public void test1() {
        int[] input = {1, 2, 3};
        int[][] expected = {
                {1, 2, 3}, {1, 3, 2}, {2, 1, 3},
                {2, 3, 1}, {3, 1, 2}, {3, 2, 1}
        };
        test(input, expected);
    }

    @Test
    public void test2() {
        int[] input = {0, 1};
        int[][] expected = {{0, 1}, {1, 0}};
        test(input, expected);
    }

    @Test
    public void test3() {
        int[] input = {1};
        int[][] expected = {{1}};
        test(input, expected);
    }

    @Test
    public void test4() {
        int[] input = {1, 2, 3, 4};
        int[][] expected = {
                {1, 2, 3, 4}, {1, 2, 4, 3}, {1, 3, 2, 4}, {1, 3, 4, 2}, {1, 4, 2, 3}, {1, 4, 3, 2},
                {2, 1, 3, 4}, {2, 1, 4, 3}, {2, 3, 1, 4}, {2, 3, 4, 1}, {2, 4, 1, 3}, {2, 4, 3, 1},
                {3, 1, 2, 4}, {3, 1, 4, 2}, {3, 2, 1, 4}, {3, 2, 4, 1}, {3, 4, 1, 2}, {3, 4, 2, 1},
                {4, 1, 2, 3}, {4, 1, 3, 2}, {4, 2, 1, 3}, {4, 2, 3, 1}, {4, 3, 1, 2}, {4, 3, 2, 1}
        };
        test(input, expected);
    }


    private static void test(int[] input, int[][] expected) {
        List<List<Integer>> actual = permute(input);
        Assert.assertEquals(expected.length, actual.size());
        for (int[] p : expected) {
            Assert.assertTrue(actual.contains(intArrayToList(p)));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        // create 1 permutation
        // create N-1 permutations with different first element
        // for each permutation create (N-2) permutation

        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>(size);
        List<Integer> p = intArrayToList(nums);
        result.add(p);
        permute(result, p, 0, size);
        return result;
    }

    private static List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int j : array) {
            list.add(j);
        }
        return list;
    }

    private static void permute(List<List<Integer>> result, List<Integer> input, int start, int size) {
        if (start == size - 1) {
            return;
        }
        permute(result, input, start + 1, size);
        for (int i = start + 1; i < size; i++) {
            List<Integer> p = swapElements(input, start, i);
            result.add(p);
            permute(result, p, start + 1, size);
        }
    }

    private static List<Integer> swapElements(List<Integer> input, int i, int j) {
        List<Integer> result = new ArrayList<>(input);
        result.set(i, input.get(j));
        result.set(j, input.get(i));
        return result;
    }
}
