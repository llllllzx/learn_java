package page_001_020;

import domain.RandomListNode;

/**
 * @author liuzhaoxin
 * 现在有一个这样的链表：链表的每一个节点都附加了一个随机指针，随机指针可能指向链表中的任意一个节点或者指向空。
 * 请对这个链表进行深拷贝
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode cur = head;
        //将新节点加到老节点的后面
        while (cur != null) {
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = head;
        //填充Random
        while (cur != null) {
            //当前节点的random不为空的时候，填充新节点的Random
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode newHead = head.next;
        cur = head;
        //新老链表分离
        while (cur != null) {
            RandomListNode temp = cur.next;
            cur.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }
}
