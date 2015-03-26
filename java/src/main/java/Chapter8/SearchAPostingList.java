package Chapter8;

import java.util.Stack;

/**
 * Created by Carl Shen on 3/25/15.
 * Problem 8.4:
 * Write recursive and iterative routines that take posting list and
 * computes the jump-first order. Assume each node has an order filed.
 */
public class SearchAPostingList {
    static class JumpPostingNode {
        int val;
        int order = -1;
        JumpPostingNode next;
        JumpPostingNode jump;

        public JumpPostingNode(int x) { this.val = x; }
    }

    public void computeJumpOrder(JumpPostingNode head) {
        computeRecur(head, 0);
    }

    public void computeRecur(JumpPostingNode head, int order) {
        if (head != null && head.order == -1) {
            head.order = order++;
            computeRecur(head.jump, order);
            computeRecur(head.next, order);
        }
    }

    public void computeJumpOrderIter(JumpPostingNode head){
        if (head == null) return;
        Stack<JumpPostingNode> stack = new Stack<JumpPostingNode>();
        stack.push(head);
        int order = 0;
        while (!stack.isEmpty()) {
            JumpPostingNode node = stack.pop();
            if (node != null && node.order == -1) {
                node.order = order++;
                stack.push(node.next);
                stack.push(node.jump);
            }
        }
    }
}
