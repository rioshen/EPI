package Chapter7;

import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Carl Shen on 3/24/15.
 */
public class TestListCycle {
    private DetectCycle sol = new DetectCycle();

    @Test
    public void testListNoCycle() {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        assertNull(sol.findCycle(l));
    }

    @Test
    public void testCycleList() {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = l.next;
        // now 3 is pointing to 2
        assertEquals(l.next, sol.findCycle(l));
    }

    @Test
    public void testCycleisHead() {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = l;
        // now 2 is pointing to 1, 1 is the cycle point
        assertEquals(l, sol.findCycle(l));
    }
}
