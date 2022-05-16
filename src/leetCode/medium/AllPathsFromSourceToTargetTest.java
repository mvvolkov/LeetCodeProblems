package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">797. All Paths From Source to Target</a>
 * <p>
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0
 * to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a
 * directed edge from node i to node graph[i][j]).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * <p>
 * Example 2:
 * <p>
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
public class AllPathsFromSourceToTargetTest {

    @Test
    public void test1() {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        int[][] expected = {{0, 1, 3}, {0, 2, 3}};
        test(graph, expected);
    }

    @Test
    public void test2() {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        int[][] expected = {{0, 4}, {0, 3, 4}, {0, 1, 3, 4}, {0, 1, 2, 3, 4}, {0, 1, 4}};
        test(graph, expected);
    }

    @Test
    public void test3() {
        int[][] graph = {{1}, {}};
        int[][] expected = {{0, 1}};
        test(graph, expected);
    }

    @Test
    public void test4() {
        int[][] graph = {{}};
        int[][] expected = {{0}};
        test(graph, expected);
    }

    private static void test(int[][] graph, int[][] expected) {
        List<List<Integer>> actualList = allPathsSourceTarget(graph);
        Assert.assertNotNull(actualList);
        Assert.assertEquals(expected.length, actualList.size());
        for (int i = 0; i < expected.length; i++) {
            List<Integer> list = actualList.get(i);
            for (int j = 0; j < expected[i].length; j++) {
                Assert.assertEquals(expected[i][j], (int) list.get(j));
            }
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        allPathsSourceTarget(graph, new ArrayList<>(), 0, result);
        return result;
    }

    private static void allPathsSourceTarget(int[][] graph, List<Integer> list, int next, List<List<Integer>> result) {
        list.add(next);
        if (next == graph.length - 1) {
            result.add(list);
            return;
        }
        for (int k : graph[next]) {
            List<Integer> nextList = new ArrayList<>(list);
            allPathsSourceTarget(graph, nextList, k, result);
        }
    }
}
