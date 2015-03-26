package Chapter8;

import utils.TreeNode;

import java.util.Stack;

/**
 * Created by Carl Shen on 3/25/15.
 * Problem 8.3:
 * Given a BST root, print all its descendants in sorted order.
 * Solution:
 * Keep traversing down to the left most leaf and use a stack to store all its ancestors.
 * When we hit the end, pop the top element and star searching the right sub tree
 */
public class InorderTraversal {
    public static void inorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        inorder(root);
    }
}
