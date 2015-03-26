package Chapter7;

import utils.ListNode;

/**
 * Created by Carl Shen on 3/24/15.
 * Problem 7.11: Zipping a list.
 */
public class ZipplingList {
    /**
     * Split the list into two halves, and reverse the second half, merge two halves as the result.
     * First step is simple, we can use slow-fast pointer to find the middle element.
     * After that, reverse the second half.
     * Finally, we merge them back
     * @param list
     * @return
     */
    public void zip(ListNode list) {
        if (list == null || list.next == null) return;

        ListNode middle = findMiddle(list);
        ListNode newHead = middle.next;
        middle.next = null;
        newHead = reverse(newHead);

        merge(list, newHead);
    }

    public void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode temp = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = temp;
            l1 = temp;
        }
    }
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
