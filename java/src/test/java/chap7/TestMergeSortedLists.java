package chap7;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Created by Carl Shen on 3/24/15.
 */
public class TestMergeSortedLists {
    private ListNode L;
    private ListNode F;
    private MergeTwoSortedLists sol = new MergeTwoSortedLists();

    @Before
    public void init() {
        L = new ListNode(1);
        L.next = new ListNode(3);
        L.next.next = new ListNode(5);

        F = new ListNode(2);
        F.next = new ListNode(4);
        F.next.next = new ListNode(6);
    }

    @Test
    public void testEmptyLists() {
        assertEquals(sol.mergeTwoSortedLists(null, null), null);
    }

    @Test
    public void testOneEmpty() {
        ListNode curr = L;
        ListNode res = sol.mergeTwoSortedLists(L, null);
        while (curr != null) {
            assertEquals(res.val, curr.val);
            res = res.next;
            curr = curr.next;
        }
    }
}
