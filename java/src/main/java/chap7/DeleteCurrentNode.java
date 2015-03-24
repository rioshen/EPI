package chap7;

import utils.ListNode;

/**
 * Created by Carl Shen on 3/24/15.
 * Problem 7.7: Delete current node
 */
public class DeleteCurrentNode {
    public void deleteCurrent(ListNode node) {
        if (node == null) {
            return;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
