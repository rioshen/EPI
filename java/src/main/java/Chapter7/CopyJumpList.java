package Chapter7;

import utils.JumpListNode;

/**
 * Created by Carl Shen on 3/24/15.
 */
public class CopyJumpList {
    public JumpListNode copy(JumpListNode head) {
        if (head == null) return null;

        JumpListNode curr = head;
        while (curr != null) {
            JumpListNode temp = new JumpListNode(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.jump != null) {
                curr.next.jump = curr.jump.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        JumpListNode copy = curr.next;
        while (curr.next != null) {
            JumpListNode temp = curr.next;
            curr.next = temp.next;
            curr = temp;
        }
        return copy;
    }
}
