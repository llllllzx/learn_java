package class_03;

import java.util.ArrayList;
import java.util.Stack;

public class Code_16_ZigZagPrintBinaryTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return result;
        }
        int layer = 1;
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();
        odd.push(pRoot);
        while (!odd.isEmpty() || !even.isEmpty()) {
            if (layer % 2 == 1) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!odd.isEmpty()) {
                    TreeNode node = odd.pop();
                    if (node != null) {
                        temp.add(node.val);
                        even.push(node.left);
                        even.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    result.add(temp);
                    layer++;
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!even.isEmpty()) {
                    TreeNode node = even.pop();
                    if (node != null) {
                        temp.add(node.val);
                        odd.push(node.right);
                        odd.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    result.add(temp);
                    layer++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }

}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
