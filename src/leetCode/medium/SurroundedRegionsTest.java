package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/surrounded-regions/">130. Surrounded Regions</a>
 * <p>
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are
 * 4-directionally surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O'
 * on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and
 * it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected
 * if they are adjacent cells connected horizontally or vertically.
 * <p>
 * Example 2:
 * <p>
 * Input: board = [["X"]]
 * Output: [["X"]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 */
public class SurroundedRegionsTest {

    @Test
    public void test1() {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] expected = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        test(board, expected);
    }

    @Test
    public void test2() {
        char[][] board = {
                {'X'}
        };
        char[][] expected = {
                {'X'}
        };
        test(board, expected);
    }

    @Test
    public void test3() {
        char[][] board = {
                {'X', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'X', 'O', 'X'},
        };
        char[][] expected = {
                {'X', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'X'},
                {'O', 'X', 'X', 'O', 'X'},
        };
        test(board, expected);
    }

    @Test
    public void test4() {
        char[][] board = {
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
        };
        char[][] expected = {
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
        };
        test(board, expected);
    }

    private static void test(char[][] board, char[][] expected) {
        solve(board);
        Assert.assertArrayEquals(expected, board);
    }

    public static void solve(char[][] board) {
        int h = board.length;
        int w = board[0].length;
        for (int i = 0; i < h; i++) {
            if (board[i][0] == 'O') {
                markEdge(board, i, 0);
            }
            if (board[i][w - 1] == 'O') {
                markEdge(board, i, w - 1);
            }
        }
        for (int j = 0; j < w; j++) {
            if (board[0][j] == 'O') {
                markEdge(board, 0, j);
            }
            if (board[h - 1][j] == 'O') {
                markEdge(board, h - 1, j);
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char c = board[i][j];
                if (c == 'O') {
                    board[i][j] = 'X';
                } else if (c == '2') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void markEdge(char[][] board, int i, int j) {
        int h = board.length;
        int w = board[0].length;
        board[i][j] = '2';
        if (i > 0 && board[i - 1][j] == 'O') {
            markEdge(board, i - 1, j);
        }
        if (j > 0 && board[i][j - 1] == 'O') {
            markEdge(board, i, j - 1);
        }
        if (i < h - 1 && board[i + 1][j] == 'O') {
            markEdge(board, i + 1, j);
        }
        if (j < w - 1 && board[i][j + 1] == 'O') {
            markEdge(board, i, j + 1);
        }
    }
}
