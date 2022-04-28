package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">https://leetcode.com/problems/add-two-numbers/</a>
 * <p>
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored
 * in reverse order, and each of their nodes contains a single digit. Add the two numbers and return
 * the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbersTest {

    @Test
    public void test1() {
        int[] l1 = {2, 4, 3};
        int[] l2 = {5, 6, 4};
        int[] expected = {7, 0, 8};
        test(l1, l2, expected);
    }

    @Test
    public void test2() {
        int[] l1 = {0};
        int[] l2 = {0};
        int[] expected = {0};
        test(l1, l2, expected);
    }

    @Test
    public void test3() {
        int[] l1 = {9, 9, 9, 9, 9, 9, 9};
        int[] l2 = {9, 9, 9, 9};
        int[] expected = {8, 9, 9, 9, 0, 0, 0, 1};
        test(l1, l2, expected);
    }

    @Test
    public void test4() {
        int[] l1 = {2, 4, 9};
        int[] l2 = {5, 6, 4, 9};
        int[] expected = {7, 0, 4, 0, 1};
        test(l1, l2, expected);
    }

    private static void test(int[] array1, int[] array2, int[] expected) {
        ListNode l1 = arrayToList(array1);
        ListNode l2 = arrayToList(array2);
        ListNode actual = addTwoNumbers(l1, l2);
        Assert.assertArrayEquals(expected, listToArray(actual));
    }

    private static ListNode arrayToList(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode prev = head;

        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            prev.next = node;
            prev = node;
        }
        return head;
    }

    private static int[] listToArray(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        int[] array = new int[size];
        node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.val;
            node = node.next;
        }
        return array;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1;
        int sum = l1.val + l2.val;
        int fromPrevDegree;
        if (sum < 10) {
            fromPrevDegree = 0;
        } else {
            sum -= 10;
            fromPrevDegree = 1;
        }
        l1.val = sum;
        l1 = l1.next;
        l2 = l2.next;
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + fromPrevDegree;
            if (sum < 10) {
                fromPrevDegree = 0;
            } else {
                sum -= 10;
                fromPrevDegree = 1;
            }
            l1.val = sum;
            tail = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            l1 = l2;
            tail.next = l2;
        }
        while (l1 != null && fromPrevDegree != 0) {
            sum = l1.val + fromPrevDegree;
            if (sum < 10) {
                fromPrevDegree = 0;
            } else {
                sum -= 10;
            }
            l1.val = sum;
            tail = l1;
            l1 = l1.next;
        }
        if (fromPrevDegree != 0) {
            tail.next = new ListNode(fromPrevDegree);
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
