package page_001_020;


/**
 * @author liuzhaoxin
 */
public class SortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        new SortList().sortList(node1);
    }

        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode fast = head,slow = head,daemon = head;

            while(fast != null && fast.next != null){
                daemon = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            //将链表一分为二
            daemon.next = null;

            ListNode newHead = slow;

            ListNode left = sortList(head);
            ListNode right = sortList(newHead);
            return merge(left,right);
        }

        private ListNode merge(ListNode left,ListNode right){
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            if(left == null) return right;
            if(right == null) return left;

            while(left != null && right != null){
                if(left.val <= right.val){
                    cur.next = left;
                    cur = cur.next;
                    left = left.next;
                }else{
                    cur.next = right;
                    cur = cur.next;
                    right = right.next;
                }
            }
            if(left == null){
                cur.next = right;
            }
            if(right == null){
                cur.next = left;
            }
            return dummy.next;
        }

    }

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
