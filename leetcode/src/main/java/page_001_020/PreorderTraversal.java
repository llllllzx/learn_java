package page_001_020;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author liuzhaoxin
 */
public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            ArrayList<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return list;
        }
        return new ArrayList<>();
    }
}
