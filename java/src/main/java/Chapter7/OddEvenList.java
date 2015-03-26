package Chapter7;

import utils.ListNode;

/**
 * Created by Carl Shen on 3/24/15.
 * Problem 7.6 Odd Even List
 * First split the list into odd and even sub lists. We maintain two pointers, one for odd and the other for even,
 * initialize the even pointer pointing the head, and odd to the next of head.
 * Point the last node in even to the head of odd sub list.
 * Time Complexity is O(N), where N is the number of nodes in the list
 * Space Complexity is O(1);
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode evenDummy = new ListNode(-1), oddDummy = new ListNode(-1);
        ListNode even = evenDummy, odd = oddDummy;
        ListNode l = head, r = head.next;
        while (l != null && l.next != null) {
            even.next = l;
            l = l.next.next;
            even = even.next;
        }
        while (r != null && r.next != null) {
            odd.next = r;
            r = r.next.next;
            odd = odd.next;
        }
        even.next = oddDummy.next;
        odd.next = null;
        return evenDummy.next;
    }
}
