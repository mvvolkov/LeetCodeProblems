package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree/">572. Subtree of Another Tree</a>
 * <p>
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
 * structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree tree could also be considered as a subtree of itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 */
public class SubtreeOfAnotherTreeTest {

    @Test
    public void test1() {
        // Input: root = [3,4,5,1,2], subRoot = [4,1,2]
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        TreeNode m1 = new TreeNode(4);
        TreeNode m2 = new TreeNode(1);
        TreeNode m3 = new TreeNode(2);
        m1.left = m2;
        m1.right = m3;
        boolean expected = true;
        test(n1, m1, expected);
    }

    @Test
    public void test2() {
        // root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n10 = new TreeNode(0);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = null;
        n3.right = null;
        n4.left = null;
        n4.right = null;
        n5.left = n10;
        TreeNode m1 = new TreeNode(4);
        TreeNode m2 = new TreeNode(1);
        TreeNode m3 = new TreeNode(2);
        m1.left = m2;
        m1.right = m3;
        boolean expected = false;
        test(n1, m1, expected);
    }


    private static void test(TreeNode root, TreeNode subRoot, boolean expected) {
        boolean actual = isSubtree(root, subRoot);
        Assert.assertEquals(expected, actual);

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return traverseTree(root, subRoot);
    }

    public static boolean compareTrees(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) {
            return n1 == n2;
        }
        if (n1.val != n2.val) {
            return false;
        }
        return compareTrees(n1.left, n2.left) && compareTrees(n1.right, n2.right);
    }

    private static boolean traverseTree(TreeNode node, TreeNode subRoot) {
        if (compareTrees(node, subRoot)) {
            return true;
        }
        if (node == null) {
            return false;
        }
        return traverseTree(node.left, subRoot) || traverseTree(node.right, subRoot);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;


        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

}
