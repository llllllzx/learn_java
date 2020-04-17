package page_001_020;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author liuzhaoxin
 * 后序遍历二叉树
 */
public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> stack1 = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();
            stack.push(root);
            //当栈不为空时，继续遍历
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                stack1.push(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            while (!stack1.isEmpty()) {
                list.add(stack1.pop());
            }
            return list;
        }
        return new ArrayList<>();
    }
}
