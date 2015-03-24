package chap7;

import utils.ListNode;

/**
 * Created by Carl Shen on 3/24/15.
 * Problem 7.4: Find the intersection of two lists
 * Traverse two lists, the intersection node should be the first same node of both lists.
 * Because of this, we can first calculate the length of each list, and advance the longer
 * one by abs(L1 - L2), after that traverse at same time and when they meet, it's the intersection node.
 * Time Complexity is O(L1 + L2)
 * Space Complexity is O(1)
 */
public class FindIntersectedNode {
    public ListNode intersect(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        // get the length of each list
        int len1 = getLength(l1), len2 = getLength(l2);
        // length of list one should be less than list two
        if (len1 > len2) intersect(l2, l1);
        // advance the longer list until they have same length
        for (int i = len2 - len1; i > 0; i--) l2 = l2.next;
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
