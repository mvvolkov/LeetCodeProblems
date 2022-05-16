package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/subsets-ii/">90. Subsets II</a>
 * <p>
 * Given an integer array nums that may contain duplicates, return all possible subsets
 * (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class SubsetsIITest {

    @Test
    public void test1() {
        int[] nums = {1, 2, 2};
        int[][] expected = {{}, {1}, {2}, {1, 2}, {2, 2}, {1, 2, 2}};
        test(nums, expected);
    }

    @Test
    public void test2() {
        int[] nums = {0};
        int[][] expected = {{}, {0}};
        test(nums, expected);
    }

    @Test
    public void test3() {
        int[] nums = {};
        int[][] expected = {{}};
        test(nums, expected);
    }

    //[4,4,4,1,4]
    @Test
    public void test4() {
        int[] nums = {4, 4, 4, 1, 4};
        int[][] expected = {{}, {1}, {1, 4}, {1, 4, 4}, {1, 4, 4, 4}, {1, 4, 4, 4, 4}, {4}, {4, 4}, {4, 4, 4}, {4, 4, 4, 4}};
        test(nums, expected);
    }


    private static void test(int[] nums, int[][] expected) {
        List<List<Integer>> actualList = subsetsWithDup(nums);
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

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<Map<Integer, Integer>> set = new HashSet<>();
        set.add(Map.of());
        for (int num : nums) {
            addSubsets(set, num);
        }
        List<List<Integer>> result = new ArrayList<>(set.size());
        set.forEach(map -> {
            List<Integer> list = new ArrayList<>();
            map.forEach((Integer i, Integer n) -> {
                for (int j = 0; j < n; j++) {
                    list.add(i);
                }
            });
            result.add(list);
        });
        return result;
    }

    private static void addSubsets(Set<Map<Integer, Integer>> result, int next) {
        Set<Map<Integer, Integer>> newSubsets = new HashSet<>();
        for (Map<Integer, Integer> map : result) {
            Map<Integer, Integer> newMap = new HashMap<>(map);
            Integer n = newMap.get(next);
            if (n == null) {
                n = 0;
            }
            newMap.put(next, n + 1);
            newSubsets.add(newMap);
        }
        result.addAll(newSubsets);
    }
}
