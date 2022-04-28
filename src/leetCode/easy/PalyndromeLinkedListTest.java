package leetCode.easy;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">https://leetcode.com/problems/palindrome-linked-list/</a>
 * <p>
 * 234. Palindrome Linked List
 * Easy
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2]
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalyndromeLinkedListTest {


    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        while (true) {
            ListNode tail = head;
            ListNode prevTail = null;
            while (tail.next != null) {
                prevTail = tail;
                tail = tail.next;
            }
            if (head.val != tail.val) {
                return false;
            }
            // the middle
            if (tail == head || head.next == tail) {
                break;
            }
            head = head.next;
            prevTail.next = null;
        }
        return true;
    }


    // Definition for singly-linked list.
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
