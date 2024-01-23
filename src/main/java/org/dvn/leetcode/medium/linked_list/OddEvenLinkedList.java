package org.dvn.leetcode.medium.linked_list;

//328
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode firstOdd = head;
        ListNode currentOdd = firstOdd;
        ListNode firstEven = head.next;
        ListNode currentEven = firstEven;

        while (currentOdd != null) {
            ListNode tempEven = currentOdd.next;
            if (currentOdd.next != null) {
                currentOdd.next = currentOdd.next.next;
            }

            currentEven.next = tempEven;
            currentEven = currentEven.next;
            if (currentOdd.next == null) break;
            currentOdd = currentOdd.next;

        }
        currentOdd.next = firstEven;
        return firstOdd;
    }

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

}
