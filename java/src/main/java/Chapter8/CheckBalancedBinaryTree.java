package Chapter8;

import utils.TreeNode;

/**
 * Created by Carl Shen on 3/25/15.
 */
public class CheckBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return root == null || getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        if (left == -1) return -1;
        int right = getHeight(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
