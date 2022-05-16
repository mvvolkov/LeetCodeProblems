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

    @Test
    public void test6() {
        int[] input = {2, 2, 1, 1};
        int[][] expected = {
                {1, 1, 2, 2}, {1, 2, 1, 2}, {1, 2, 2, 1}, {2, 1, 1, 2}, {2, 1, 2, 1}, {2, 2, 1, 1}
        };
        test(input, expected);
    }

    @Test
    public void test7() {
        int[] input = {2, 2, 1, 1, 3};
        int[][] expected = {
                {2, 2, 1, 1, 3}, {2, 2, 1, 3, 1}, {2, 2, 3, 1, 1}, {2, 1, 2, 1, 3}, {2, 3, 2, 1, 1}, {2, 1, 2, 3, 1}, {2, 1, 1, 2, 3},
                {2, 1, 3, 2, 1}, {2, 3, 1, 2, 1}, {2, 1, 1, 3, 2}, {2, 1, 3, 1, 2}, {2, 3, 1, 1, 2},
                {1, 2, 2, 1, 3}, {1, 2, 2, 3, 1}, {3, 2, 2, 1, 1}, {1, 2, 1, 2, 3}, {1, 2, 3, 2, 1},
                {3, 2, 1, 2, 1}, {1, 2, 1, 3, 2}, {1, 2, 3, 1, 2}, {3, 2, 1, 1, 2}, {1, 1, 2, 2, 3},
                {1, 3, 2, 2, 1}, {3, 1, 2, 2, 1}, {1, 1, 2, 3, 2}, {1, 3, 2, 1, 2}, {3, 1, 2, 1, 2},
                {1, 1, 3, 2, 2}, {1, 3, 1, 2, 2}, {3, 1, 1, 2, 2}
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
        int[] map = new int[21];
        for (int i : nums) {
            map[i + 10]++;
        }
        int i = nums[0] + 10;
        int number = map[i];
        int key = i - 10;
        int[] permutation = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            permutation[j] = 11;
        }
        List<int[]> permutations = new ArrayList<>();
        makeCombinations(permutation, key, number, 0, permutations, map, new int[]{});
        List<List<Integer>> result = new ArrayList<>();
        for (int[] permutation1 : permutations) {
            result.add(intArrayToList(permutation1));
        }
        return result;
    }

    private static void makeCombinations(int[] permutation, int key, int n, int start, List<int[]> permutations, int[] map, int[] usedKeys) {
        for (int i = start; i < permutation.length - n + 1; i++) {
            if (permutation[i] == 11) {
                int[] newPermutation = new int[permutation.length];
                System.arraycopy(permutation, 0, newPermutation, 0, permutation.length);
                newPermutation[i] = key;
                if (n == 1) {
                    int[] newUsedKeys = new int[usedKeys.length + 1];
                    System.arraycopy(usedKeys, 0, newUsedKeys, 0, usedKeys.length);
                    newUsedKeys[usedKeys.length] = key;
                    boolean found = false;
                    for (int j = 0; j < 21; j++) {
                        int n1 = map[j];
                        if (n1 > 0) {
                            int key1 = j - 10;
                            boolean keyIsUsed = false;
                            for (int usedKey : newUsedKeys) {
                                if (key1 == usedKey) {
                                    keyIsUsed = true;
                                    break;
                                }
                            }
                            if (!keyIsUsed) {
                                makeCombinations(newPermutation, key1, n1, 0, permutations, map, newUsedKeys);
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) {
                        permutations.add(newPermutation);

                    }
                } else {
                    makeCombinations(newPermutation, key, n - 1, i + 1, permutations, map, usedKeys);
                }
            }
        }
    }

    private static List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int j : array) {
            list.add(j);
        }
        return list;
    }
}
