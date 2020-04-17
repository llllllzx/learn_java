package page_001_020;

import domain.ListNode;
import utils.ListUtil;

/**
 * @author liuzhaoxin
 *
 * 将给定的单链表L： L 0→L 1→…→L n-1→L n,
 * 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 要求使用原地算法，并且不改变节点的值
 *
 * 1->2->3->4->5->6->7  ===>  1->7->2->6->3->5->4
 */
public class ReorderList {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        ListNode listNode = ListUtil.convertArrayToListNode(array);
        new ReorderList().reorderList(listNode);
        //new ReorderList().reverseListNode(listNode);
    }
    //version1.0
    public void reorderList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode fast = head, slow = head, pre = head;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;

            ListNode newHead = reverseListNode(slow);

            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            ListNode left = head, right = newHead;
            boolean flag = true;
            while (head != null && newHead != null) {
                if (flag) {
                    left = head.next;
                    cur.next = head;
                    cur = cur.next;
                    head = left;
                    flag = false;
                } else {
                    right = newHead.next;
                    cur.next = newHead;
                    cur = cur.next;
                    newHead = right;
                    flag = true;
                }
            }
            if (head == null) {
                cur.next = newHead;
            }
            if (newHead == null) {
                cur.next = head;
            }
            head = dummy.next;
        }
    }

    private ListNode reverseListNode(ListNode head) {
        if (head != null && head.next != null) {
            ListNode dummy = new ListNode(-1);
            ListNode newHead = head;
            while (head != null) {
                newHead = head.next;
                if (dummy.next == null) {
                    dummy.next = head;
                    head.next = null;
                } else {
                    head.next = dummy.next;
                    dummy.next = head;
                }
                head = newHead;
            }
            return dummy.next;
        }
        return head;
    }


    //version 2.0
    public void reorderList2(ListNode head) {
        if (head != null && head.next != null) {
            ListNode fast = head, slow = head, pre = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode after  = slow.next;
            slow.next = null;

            ListNode newHead = reverseListNode(after);

            ListNode oldHead = head;
            ListNode left = head;
            ListNode right = newHead;
            boolean flag = true;
            while (oldHead != null && newHead != null){
                left = oldHead.next;
                right = newHead.next;
                oldHead.next = newHead;
                oldHead = left;
                newHead.next = oldHead;
                newHead = right;
            }
        }
    }

    private ListNode reverseListNode2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode temp = null;
        while(head != null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
