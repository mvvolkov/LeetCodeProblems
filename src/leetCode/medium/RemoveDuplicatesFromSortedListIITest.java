package leetCode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">82. Remove Duplicates from Sorted List II/</a>
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedListIITest {

    @Test
    public void test1() {
        int[] input = {1, 2, 3, 3, 4, 4, 5};
        int[] expected = {1, 2, 5};
        test(input, expected);
    }

    @Test
    public void test2() {
        int[] input = {1, 1, 1, 2, 3};
        int[] expected = {2, 3};
        test(input, expected);
    }

    @Test
    public void test3() {
        int[] input = {1, 1, 1, 2, 2, 3};
        int[] expected = {3};
        test(input, expected);
    }

    @Test
    public void test4() {
        int[] input = {1, 1, 1, 2, 2, 3, 3};
        int[] expected = {};
        test(input, expected);
    }

    @Test
    public void test5() {
        int[] input = {0, 0, 0, 1, 2, 2, 3, 3};
        int[] expected = {1};
        test(input, expected);
    }

    @Test
    public void test6() {
        int[] input = {1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8};
        int[] expected = {1, 3, 5, 7};
        test(input, expected);
    }

    private static void test(int[] inputArray, int[] expectedArray) {
        ListNode inputList = intArrayToLinkedList(inputArray);
        ListNode expectedList = intArrayToLinkedList(expectedArray);
        ListNode actual = deleteDuplicates(inputList);
        while (actual != null) {
            Assert.assertEquals(expectedList.val, actual.val);
            actual = actual.next;
            expectedList = expectedList.next;
        }
        Assert.assertNull(expectedList);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode node = null;
        ListNode next = head;
        ListNode nextNext = next.next;
        head = null;
        while (nextNext != null) {
            int val = next.val;
            while (nextNext != null && nextNext.val == val) {
                nextNext = nextNext.next;
            }
            if (next.next != nextNext) {
                if (node != null) {
                    node.next = nextNext;
                }
                if (nextNext == null) {
                    return head;
                }
                next = nextNext;
                nextNext = next.next;
            } else {
                if (head == null) {
                    head = next;
                }
                node = next;
                next = nextNext;
                nextNext = nextNext.next;
            }
        }
        return head != null ? head : next;
    }

    private static ListNode intArrayToLinkedList(int[] arr) {
        ListNode head = null;
        ListNode last = null;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            if (head == null) {
                head = node;
            } else {
                last.next = node;
            }
            last = node;

        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }
}
