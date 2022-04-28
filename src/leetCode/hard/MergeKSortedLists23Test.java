package leetCode.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists23Test {


    @Test
    public void test1() {
        int[][] input = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        int[] expected = {1, 1, 2, 3, 4, 4, 5, 6};
        test(input, expected);
    }

    @Test
    public void test2() {
        int[][] input = {};
        int[] expected = {};
        test(input, expected);
    }

    @Test
    public void test3() {
        int[][] input = {{}};
        int[] expected = {};
        test(input, expected);
    }

    private static void test(int[][] input, int[] expected) {
        ListNode[] lists = new ListNode[input.length];
        int i = 0;
        int size = 0;
        for (int[] list : input) {
            size += list.length;
            if (list.length == 0) {
                lists[i++] = null;
                continue;
            }
            ListNode head = new ListNode(list[0]);
            ListNode prev = head;
            for (int j = 1; j < list.length; j++) {
                ListNode node = new ListNode(list[j]);
                prev.next = node;
                prev = node;
            }
            lists[i++] = head;
        }
        ListNode result = mergeKLists(lists);
        int[] actual = new int[size];
        i = 0;
        while (result != null) {
            actual[i++] = result.val;
            result = result.next;
        }
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("  actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(size, Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        if (queue.isEmpty()) {
            return null;
        }

        ListNode head = queue.poll();
        ListNode prev = head;
        ListNode next = head.next;
        if (next != null) {
            queue.add(next);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            prev.next = node;
            next = node.next;
            if (next != null) {
                queue.add(next);
            }
            prev = node;
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
