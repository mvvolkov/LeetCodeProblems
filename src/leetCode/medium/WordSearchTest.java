package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/word-search/">https://leetcode.com/problems/word-search/</a>
 * <p>
 * 79. Word Search
 * Medium
 * <p>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * <p>
 * <p>
 * <p>
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearchTest {

    @Test
    public void test1() {
        char[][] input = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean expected = true;
        test(input, word, expected);
    }

    @Test
    public void test2() {
        char[][] input = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        boolean expected = true;
        test(input, word, expected);
    }

    @Test
    public void test3() {
        char[][] input = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        boolean expected = false;
        test(input, word, expected);
    }

    @Test
    public void test4() {
        char[][] input = {
                {'A', 'B', 'C', 'E', 'a', 'b'},
                {'S', 'F', 'C', 'S', 'd', 'k'},
                {'A', 'D', 'E', 'E', 'n', 'm'},
                {'d', 'k', 'E', 'a', 'n', 'm'},
                {'A', 'D', 'E', 'E', 'n', 'm'}
        };
        String word = "SCFDkEaEE";
        boolean expected = true;
        test(input, word, expected);
    }

    @Test
    public void test5() {
        char[][] input = {
                {'A'}
        };
        String word = "A";
        boolean expected = true;
        test(input, word, expected);
    }

    @Test
    public void test6() {
        char[][] input = {
                {'A', 'A'}
        };
        String word = "A";
        boolean expected = true;
        test(input, word, expected);
    }

    @Test
    public void test7() {
        char[][] input = {
                {'A', 'B'}
        };
        String word = "BA";
        boolean expected = true;
        test(input, word, expected);
    }

    @Test
    public void test8() {
        char[][] input = {
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'}
        };
        String word = "aaaaaaaaaaaaa";
        boolean expected = false;
        test(input, word, expected);
    }

    @Test
    public void test9() {
        char[][] input = {
                {'a', 'b'},
                {'c', 'd'},
        };
        String word = "dbac";
        boolean expected = true;
        test(input, word, expected);
    }

    @Test
    public void test10() {
        char[][] input = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'},
        };
        String word = "AAB";
        boolean expected = true;
        test(input, word, expected);
    }

    @Test
    public void test11() {
        char[][] input = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String word = "ABCESEEEFS";
        boolean expected = true;
        test(input, word, expected);
    }


    private static void test(char[][] board, String word, boolean expected) {
        boolean actual = exist(board, word);
        Assert.assertEquals(expected, actual);
    }

    public static boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (findFromIndex(board, h, w, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean findFromIndex(char[][] board, int h, int w, char[] chars, int i, int j, int index) {

        char c = board[i][j];
        if (c != chars[index++]) {
            return false;
        }
        if (index == chars.length) {
            return true;
        }
        board[i][j] = '.';
        if (i + 1 < h && findFromIndex(board, h, w, chars, i + 1, j, index)) {
            return true;
        }
        if (i > 0 && findFromIndex(board, h, w, chars, i - 1, j, index)) {
            return true;
        }
        if (j + 1 < w && findFromIndex(board, h, w, chars, i, j + 1, index)) {
            return true;
        }
        if (j > 0 && findFromIndex(board, h, w, chars, i, j - 1, index)) {
            return true;
        }
        board[i][j] = c;
        return false;
    }
}