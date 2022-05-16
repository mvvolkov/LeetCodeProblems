package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations-ii/">47. Permutations II</a>
 * <p>
 * Given a collection of numbers, nums, that might contain duplicates, return all
 * possible unique permutations in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermutationsIITest {

    @Test
    public void test1() {
        int[] input = {1, 1, 2};
        int[][] expected = {
                {1, 1, 2}, {1, 2, 1}, {2, 1, 1}
        };
        test(input, expected);
    }

    @Test
    public void test2() {
        int[] input = {1, 2, 3};
        int[][] expected = {
                {1, 2, 3}, {1, 3, 2}, {2, 1, 3},
                {2, 3, 1}, {3, 1, 2}, {3, 2, 1}
        };
        test(input, expected);
    }

    @Test
    public void test3() {
        int[] input = {0, 1};
        int[][] expected = {{0, 1}, {1, 0}};
        test(input, expected);
    }

    @Test
    public void test4() {
        int[] input = {1};
        int[][] expected = {{1}};
        test(input, expected);
    }

    @Test
    public void test5() {
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
        List<List<Integer>> actualList = permuteUnique(input);
        Assert.assertNotNull(actualList);
        Assert.assertEquals(expected.length, actualList.size());
        for (int[] array : expected) {
            boolean found = false;
            for (List<Integer> list : actualList) {
                if (compare(list, array)) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue("not found " + Arrays.toString(array), found);
        }
    }

    private static boolean compare(List<Integer> list, int[] array) {
        HashMap<Integer, Integer> result1 = new HashMap<>(list.size());
        for (Integer i : list) {
            Integer n = result1.get(i);
            if (n == null) {
                n = 0;
            }
            result1.put(i, n + 1);
        }
        HashMap<Integer, Integer> result2 = new HashMap<>(list.size());
        for (int i : array) {
            Integer n = result2.get(i);
            if (n == null) {
                n = 0;
            }
            result2.put(i, n + 1);
        }
        return result1.equals(result2);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>(size);
        List<Integer> p = intArrayToList(nums);
        result.add(p);
        permute(result, p, 0, size);
        return result;
    }

    private static void permute(List<List<Integer>> result, List<Integer> input, int start, int size) {
        if (start == size - 1) {
            return;
        }
        permute(result, input, start + 1, size);
        for (int i = start + 1; i < size; i++) {
            List<Integer> p = swapElements(input, start, i);
            if(!result.contains(p)){
                result.add(p);
            }
            permute(result, p, start + 1, size);
        }
    }

    private static List<Integer> swapElements(List<Integer> input, int i, int j) {
        List<Integer> result = new ArrayList<>(input);
        result.set(i, input.get(j));
        result.set(j, input.get(i));
        return result;
    }

    private static List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int j : array) {
            list.add(j);
        }
        return list;
    }
}
