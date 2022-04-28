package leetCode.easy;

/**
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">https://leetcode.com/problems/middle-of-the-linked-list/</a>
 * <p>
 * 876. Middle of the Linked List
 *
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 */
public class MiddleOfTheLinkedListTest {

    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode tail = head.next;
        ListNode middle = head;
        boolean shouldMoveMiddle = false;
        while (tail != null) {
            if (shouldMoveMiddle) {
                middle = middle.next;
            }
            shouldMoveMiddle = !shouldMoveMiddle;
            tail = tail.next;
        }
        return middle;
    }

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
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
