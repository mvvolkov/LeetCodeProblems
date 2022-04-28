package leetCode.medium;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.Arrays;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfListTest {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        ListNode prevNode = null;
        ListNode p = head;
        int size = 0;
        while (p != null) {
            if (prevNode != null) {
                prevNode = prevNode.next;
            }
            size++;
            if (size == n + 1) {
                prevNode = head;
            }
            p = p.next;
        }
        if (size == n) {
            return head.next;
        }
        if (prevNode == null) {
            return null;
        }
        ListNode nodeToDelete = prevNode.next;
        prevNode.next = nodeToDelete.next;
        return head;
    }


    //Definition for singly-linked list.
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
