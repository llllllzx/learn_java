package class_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 已知一颗搜索二叉树后续遍历的数组postArr,请根据该数组重构该搜索二叉树
 */
public class Code_04_ReconstructSearchBinaryTree_lzx {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node process(int[] postArr, int L, int R) {
        Node head = new Node(postArr[R]);
        if (L == R) {
            return head;
        }
        int M = -1;
        for (int i = L; i < R; i++) {
            if (postArr[i] < postArr[R]) {
                M = i;
            }
        }
        //说明只有右子树
        if (M == -1) {
            head.right = process(postArr, L, R - 1);
        } else if (M == R - 1) {
            head.left = process(postArr, L, R - 1);
        } else {
            head.left = process(postArr, L, M);
            head.right = process(postArr, M + 1, R - 1);
        }
        return head;
    }

    public static void main(String[] args) {
        final Object o = new Object();
    }
}
