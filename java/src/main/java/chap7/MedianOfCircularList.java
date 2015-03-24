package chap7;

import utils.ListNode;

/**
 * Created by Carl Shen on 3/24/15.
 * Problem 7.3: Find median of a sorted circular list
 *
 * Solution:
 * 1. Calculate the length of the list, because it's circular, instead of deciding whether it's null
 * we terminate the loop while the pointer back in the first node
 * 2. Find the middle element of the list, if the length is odd, middle is median, otherwise, median is middle + middle.next
 */
public class MedianOfCircularList {
    public double findMedian(ListNode head) {
        if (head == null || head.next == null) return 0.0;
        int length = getLength(head);
        ListNode curr = head.next;
        for (int i = 0; i < (length - 1) >> 1; i++) {
            curr = curr.next;
        }
        return (length % 2 == 0) ? 0.5 * (curr.val + curr.next.val) : curr.val * 1.0;
    }

    /**
     * Returns the length of circular list
     * @param head : fake node
     * @return length of the list
     */
    public int getLength(ListNode head) {
        if (head == null || head.next == null) return 0;
        ListNode curr = head.next.next;
        int len = 1;
        while (curr != head.next) {
            curr = curr.next;
            len++;
        }
        return len;
    }
}
