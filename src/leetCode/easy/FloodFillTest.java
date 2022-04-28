package leetCode.easy;

import org.junit.Test;

import java.util.*;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents
 * the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill
 * on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally
 * to the starting pixel of the same color as the starting pixel, plus any pixels connected
 * 4-directionally to those pixels (also with the same color), and so on.
 * Replace the color of all of the aforementioned pixels with newColor.
 * <p>
 * Return the modified image after performing the flood fill.
 */
public class FloodFillTest {

    // Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
    //Output: [[2,2,2],[2,2,0],[2,0,1]]


    @Test
    public void test1() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] expected = {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        test(image, sr, sc, newColor, expected);
    }

    @Test
    public void test2() {
        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        int sr = 0;
        int sc = 0;
        int newColor = 2;
        int[][] expected = {{2, 2, 2}, {2, 2, 2}};
        test(image, sr, sc, newColor, expected);
    }

    @Test
    public void test3() {
        int[][] image = {{0, 0, 0}, {1, 0, 0}};
        int sr = 1;
        int sc = 0;
        int newColor = 2;
        int[][] expected = {{0, 0, 0}, {2, 0, 0}};
        test(image, sr, sc, newColor, expected);
    }

    private static void test(int[][] image, int sr, int sc, int newColor, int[][] expected) {
        System.out.println("input array: " + Arrays.deepToString(image));
        System.out.println("start point: " + sr + ", " + sc);
        System.out.println("expected: " + Arrays.deepToString(expected));
        int[][] actual = floodFill(image, sr, sc, newColor);
        System.out.println("  actual: " + Arrays.deepToString(actual));
        assert Arrays.deepEquals(expected, actual);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return new FloodFillProcessor(image, sr, sc, newColor).execute();
    }

    private static final class FloodFillProcessor {

        private final boolean[][] processedPoints;
        private final int[] stack;
        private int stackSize;
        private final int[][] image;
        private final int oldColor;
        private final int newColor;
        private final int sr;
        private final int sc;
        private final int h;
        private final int w;

        private FloodFillProcessor(int[][] image, int sr, int sc, int newColor) {
            this.image = image;
            this.newColor = newColor;
            this.sr = sr;
            this.sc = sc;
            oldColor = image[sr][sc];
            h = image.length;
            w = image[0].length;
            processedPoints = new boolean[image.length][image[0].length];
            stack = new int[h * w * 2];
        }

        private int[][] execute() {
            pushPoint(sc, sr);
            processedPoints[sr][sc] = true;
            while (stackSize > 0) {
                int[] point = pop();
                int x = point[0];
                int y = point[1];
                image[y][x] = newColor;
                if (x > 0) {
                    processPoint(x - 1, y);
                }
                if (x < w - 1) {
                    processPoint(x + 1, y);
                }
                if (y > 0) {
                    processPoint(x, y - 1);
                }
                if (y < h - 1) {
                    processPoint(x, y + 1);
                }
            }
            return image;
        }

        private void pushPoint(int x, int y) {
            stack[stackSize++] = x;
            stack[stackSize++] = y;
        }

        private int[] pop() {
            int[] result = new int[2];
            result[1] = stack[--stackSize];
            result[0] = stack[--stackSize];
            return result;
        }

        private void processPoint(int x, int y) {
            if (processedPoints[y][x]) {
                return;
            }
            if (image[y][x] == oldColor) {
                pushPoint(x, y);
            }
            processedPoints[y][x] = true;
        }
    }
}


