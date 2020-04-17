package page_001_020;

/**
 * @author liuzhaoxin
 */

import domain.ListNode;

/**
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 */
public class DetectCycle {
    ListNode slow = null;
    ListNode fast = null;
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        boolean flag = existCircle(head);
        if(!flag){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    private boolean existCircle(ListNode head){
        slow = head;
        fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
