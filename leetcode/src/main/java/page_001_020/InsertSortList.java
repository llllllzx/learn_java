package page_001_020;

import domain.ListNode;

/**
 * @author liuzhaoxin
 */
public class InsertSortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        new InsertSortList().insertionSortList(node1);
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy,pre = dummy;
        if(head == null || head.next == null){
            return head;
        }
        while(head != null){
            ListNode newHead = head.next;
            while(cur != null){
                if(head.val >= cur.val){
                    pre = cur;
                    cur = cur.next;
                }else{
                    pre.next = head;
                    head.next = cur;
                    break;
                }
            }
            if(cur == null){
                pre.next = head;
                head.next = null;
            }
            head = newHead;
            cur = dummy;
            pre = dummy;
        }
        return dummy.next;
    }
}
