package Chapter7;

import utils.ListNode;

/**
 * Created by Carl Shen on 3/24/15.
 * Problem 7.1
 * Merge two sorted lists in O(1) space and O(N) run time.
 */
public class MergeTwoSortedLists {
    /**
     * Taken two sorted lists L and F, returns the merge of L and F.
     * @param L
     *          first sorted list
     * @param F
     *          second sorted list
     * @return
     *          merged sorted list in increasing order
     */
    public ListNode mergeTwoSortedLists(ListNode L, ListNode F) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (L != null && F != null) {
            if (L.val < F.val) {
                curr.next = L;
                L = L.next;
            } else {
                curr.next = F;
                F = F.next;
            }
            curr = curr.next;
        }
        curr.next = (L == null) ? F : L;

        return dummy.next;
    }
}
