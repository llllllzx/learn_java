package untils;

import domain.ListNode;

/**
 * @author liuzhaoxin
 */
public class ConvertArrayToListNode {
    public static ListNode convert(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int num : array) {
            ListNode node = new ListNode(num);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
