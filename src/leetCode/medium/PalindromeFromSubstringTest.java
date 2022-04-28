package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a string s and array queries where queries[i] = [lefti, righti, ki].
 * We may rearrange the substring s[lefti...righti] for each query and then choose up to ki of them
 * to replace with any lowercase English letter.
 * <p>
 * If the substring is possible to be a palindrome string after the operations above, the result of
 * the query is true. Otherwise, the result is false.
 * <p>
 * Return a boolean array answer where answer[i] is the result of the ith query queries[i].
 * <p>
 * Note that each letter is counted individually for replacement, so if,
 * for example s[lefti...righti] = "aaa", and ki = 2, we can only replace two of the letters.
 * Also, note that no query modifies the initial string s.
 * <p>
 * <p>
 * <p>
 * Example :
 * <p>
 * Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * Output: [true,false,false,true,true]
 * Explanation:
 * queries[0]: substring = "d", is palidrome.
 * queries[1]: substring = "bc", is not palidrome.
 * queries[2]: substring = "abcd", is not palidrome after replacing only 1 character.
 * queries[3]: substring = "abcd", could be changed to "abba" which is palidrome.
 * Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
 * queries[4]: substring = "abcda", could be changed to "abcba" which is palidrome.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "lyb", queries = [[0,1,0],[2,2,1]]
 * Output: [false,true]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, queries.length <= 105
 * 0 <= lefti <= righti < s.length
 * 0 <= ki <= s.length
 * s consists of lowercase English letters.
 * <p>
 * <a href="https://leetcode.com/problems/can-make-palindrome-from-substring/">https://leetcode.com/problems/can-make-palindrome-from-substring/</a>
 */
public class PalindromeFromSubstringTest {

    @Test
    public void test1() {
        String input = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> expected = Arrays.asList(true, false, false, true, true);
        test(input, queries, expected);
    }

    @Test
    public void test2() {
        String input = "lyb";
        int[][] queries = {{0, 1, 0}, {2, 2, 1},};
        List<Boolean> expected = Arrays.asList(false, true);
        test(input, queries, expected);
    }

    @Test
    public void test3() {
        String input = "akcaopqodado";
        int[][] queries = {{0, 3, 1}, {0, 3, 0}, {7, 11, 0}, {6, 11, 0}, {6, 11, 1}};
        List<Boolean> expected = Arrays.asList(true, false, true, false, true);
        test(input, queries, expected);
    }

    private static void test(String input, int[][] queries, List<Boolean> expected) {
        List<Boolean> actual = canMakePaliQueries(input, queries);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        char[] chars = s.toCharArray();
        int[][] letters = new int[26][chars.length];
        int[] counts = new int[26];
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            int count = counts[index];
            letters[index][count++] = i;
            counts[index] = count;
        }
        List<Boolean> result = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int k = query[2];
            int length = end - start + 1;
            if (k >= length / 2) {
                result.add(true);
                continue;
            }
            boolean canHaveOneOddLetter = length % 2 == 1;
            int odd = 0;
            for (int i = 0; i < 26; i++) {
                int count = counts[i];
                if (count > 0 && letterIsOdd(letters[i], count-1, start, end)) {
                    odd++;
                }
            }
            if (canHaveOneOddLetter) {
                odd--;
            }
            result.add(2 * k >= odd);
        }
        return result;
    }

    private static boolean letterIsOdd(int[] indices, int size, int queryStart, int queryEnd) {

        if (indices[size] < queryStart || indices[0] > queryEnd) {
            return false;
        }
        int first = getFirstLetter(indices, 0, size, queryStart);
        int last = getLastLetter(indices, 0, size, queryEnd);
        return (last - first) % 2 == 0;
    }

    private static int getFirstLetter(int[] indices, int start, int end, int queryStart) {

        //indices[end] >= queryStart
        if (start == end) {
            return end;
        }
        if (start + 1 == end) {
            return indices[start] >= queryStart ? start : end;
        }
        int middle = start + (end - start) / 2;
        int value = indices[middle];
        if (value > queryStart) {
            return getFirstLetter(indices, start, middle, queryStart);
        } else if (value < queryStart) {
            return getFirstLetter(indices, middle, end, queryStart);
        } else {
            return middle;
        }
    }

    private static int getLastLetter(int[] indices, int start, int end, int queryEnd) {
        // indices[start] <= queryEnd
        if (start == end) {
            return start;
        }
        if (start + 1 == end) {
            return indices[end] <= queryEnd ? end : start;
        }
        int middle = start + (end - start) / 2;
        int value = indices[middle];
        if (value < queryEnd) {
            return getLastLetter(indices, middle, end, queryEnd);
        } else if (value > queryEnd) {
            return getLastLetter(indices, start, middle, queryEnd);
        } else {
            return middle;
        }
    }
}
