package org.dvn.leetcode.medium.linked_list;

//2130
public class MaximumTwinSumOfALinkedList {

    public class ListNode {
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

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = slow;
        ListNode prev = null;
        int counter = 0;
        while (reversed != null) {
            ListNode next = reversed.next;
            reversed.next = prev;
            prev = reversed;
            reversed = next;
            counter++;
        }
        reversed = prev;

        ListNode first = head;

        counter = counter / 2;
        int maxSum = first.val + reversed.val;
        first = first.next;
        reversed = reversed.next;
        while (first != null && reversed != null) {
            int curSum = first.val + reversed.val;
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            first = first.next;
            reversed = reversed.next;
            counter--;
        }
        return maxSum;
    }
}
