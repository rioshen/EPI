package Chapter7;

import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Created by Carl Shen on 3/24/15.
 */
public class TestMedianOfCircularList {
    private MedianOfCircularList sol = new MedianOfCircularList();

    @Test
    public void testEvenList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        assertEquals(0, Double.compare(sol.findMedian(head), 1.5));
    }
}
