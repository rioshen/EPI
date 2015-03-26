package Chapter7;

import utils.ListNode;

/**
 * Created by Carl Shen on 3/24/15.
 * Problem 7.2
 * Check whether a linked list contains cycle
 */
public class DetectCycle {
    public ListNode findCycle (ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
