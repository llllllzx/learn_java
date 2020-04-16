package page_001_020;

import domain.TreeNode;

import java.util.Stack;

/**
 * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 */
public class MinimumDepthOfBinaryTree {

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = run(root.left);
        int right = run(root.right);
        int min = 0;
        if (root.left != null && root.right != null) {
            min = Math.min(left, right);
        } else {
            min = root.left != null ? left : right;
        }

        return 1 + min;
    }


    public int run2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = run(root.left);
        int right = run(root.right);
        //太巧秒了
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return 1 + Math.min(left, right);
    }
}


