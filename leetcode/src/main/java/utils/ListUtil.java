package utils;

import domain.ListNode;

/**
 * @author liuzhaoxin
 */
public class ListUtil {
    public static ListNode convertArrayToListNode(int[] array) {
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
