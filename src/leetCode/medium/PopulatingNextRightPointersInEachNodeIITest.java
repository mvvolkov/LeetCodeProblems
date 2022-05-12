package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/">117. Populating Next Right Pointers in Each Node II</a>
 * <p>
 * Given a binary tree
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
 * should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to
 * its next right node, just like in Figure B. The serialized output is in level order as connected
 * by the next pointers, with '#' signifying the end of each level.
 * <p>
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * Follow-up:
 * <p>
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space
 * for this problem.
 */
public class PopulatingNextRightPointersInEachNodeIITest {

    @Test
    public void test1() {
        Integer[] input = {1, 2, 3, 4, 5, null, 7};
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = null;
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        List<String> expected = Arrays.asList("1", "#", "2", "3", "#", "4", "5", "7", "#");
        test(n1, expected);
    }

    @Test
    public void test2() {
        Integer[] input = {};
        Node n1 = null;
        List<String> expected = List.of();
        test(n1, expected);
    }

    @Test
    public void test3() {
        Integer[] input = {0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8};
        Node n1 = new Node(0);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(1);
        Node n5 = null;
        Node n6 = new Node(3);
        Node n7 = new Node(-1);
        Node n8 = new Node(5);
        Node n9 = new Node(1);
        Node n10 = null;
        Node n11 = new Node(6);
        Node n12 = null;
        Node n13 = new Node(8);
        Node n14 = null;
        Node n15 = null;

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        // n5
        n6.left = n10;
        n6.right = n11;
        n7.left = n12;
        n7.right = n13;
        List<String> expected = Arrays.asList("0", "#", "2", "4", "#", "1", "3", "-1", "#", "5", "1", "6", "8", "#");
        test(n1, expected);
    }

    private static void test(Node input, List<String> expected) {
        List<String> actual = getOutput(connect(input));
        Assert.assertEquals(expected, actual);
    }


    private static List<String> getOutput(Node root) {
        List<String> result = new ArrayList<>();
        Node node = root;
        Node nextLevel = getNextLevelNode(node);
        while (node != null) {
            result.add(Integer.toString(node.val));
            node = node.next;
            if (node == null) {
                result.add("#");
                node = nextLevel;
                nextLevel = getNextLevelNode(node);
            }
        }
        return result;
    }

    private static Node getNextLevelNode(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }

    public static Node connect(Node root) {
        Node parent = root;
        while (parent != null) {
            parent = setPointers(parent);
        }
        return root;
    }

    private static Node setPointers(Node parent) {
        Node prev = null;
        Node next;
        Node first = null;
        while (parent != null) {
            if (prev == null) {
                if (parent.left != null) {
                    prev = parent.left;
                    first = prev;
                    next = parent.right;
                    if (next != null) {
                        prev.next = next;
                        prev = next;
                    }
                } else {
                    prev = parent.right;
                    if (prev != null) {
                        first = prev;
                    }
                }
            } else {
                if (parent.left != null) {
                    next = parent.left;
                    prev.next = next;
                    prev = next;
                }
                if (parent.right != null) {
                    next = parent.right;
                    prev.next = next;
                    prev = next;
                }
            }
            parent = parent.next;
        }
        return first;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "val = " + val + "; next = " + (next == null ? "null" : next.val) + "; left = " +
                    (left == null ? "null" : left.val) + "; right = " + (right == null ? "null" : right.val);
        }
    }
}
