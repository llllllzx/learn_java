package class_08;

import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        System.out.println(1 ^ 2 ^ 1);
        System.out.println(2 ^ 1 ^ 1 );

        TreeNode head = new TreeNode(2);
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(3);
		head.left = a;
		head.right = b;
        final Solution solution = new Solution();

        System.out.println(solution.serialize(head));

    }

    static class Solution {
        public String serialize(TreeNode root) {
            if(root == null) return "#_";

            String left = serialize(root.left);
            String mid = root.val + "_";
            String right = serialize(root.right);
            return left + mid + right;
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;


}

