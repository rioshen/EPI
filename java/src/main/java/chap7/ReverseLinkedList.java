package chap7;

import utils.ListNode;

/**
 * Created by Carl Shen on 3/24/15.
 * Problem 7.9: Reverse Singly Linked List
 */
public class ReverseLinkedList {
    public ListNode reverseRecur(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseRecur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseIter(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
