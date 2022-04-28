package leetCode.easy;

import org.junit.Test;

public class MergeTwoSortedListsTest {

    @Test
    public void test1() {
        int[] list1 = {1, 2, 4};
        int[] list2 = {1, 3, 4};
        int[] expected = {1, 1, 2, 3, 4, 4};
        test(list1, list2, expected);

    }

    private static void test(int[] arr1, int[] arr2, int[] expectedArr) {
        ListNode list1 = arrayToList(arr1);
        ListNode list2 = arrayToList(arr2);
        ListNode expectedList = arrayToList(expectedArr);
        ListNode result = mergeTwoLists(list1, list2);
        while (result != null) {
            System.out.println("result = " + result.val + "; expected = " + expectedList.val);
            assert result.val == expectedList.val;
            result = result.next;
            expectedList = expectedList.next;
        }
        assert expectedList == null;
    }

    private static ListNode arrayToList(int[] arr) {
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode tail = null;

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                if (head == null) {
                    return list2;
                }
                tail.next = list2;
                return head;
            }
            if (list2 == null) {
                if (head == null) {
                    return list1;
                }
                tail.next = list1;
                return head;
            }
            ListNode node;
            if (list1.val < list2.val) {
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }


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

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }


}
