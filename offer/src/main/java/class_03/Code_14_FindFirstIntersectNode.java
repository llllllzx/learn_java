package class_03;

public class Code_14_FindFirstIntersectNode {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		//当两个链表都是无环链表时，查看两链表相交的节点
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		//当两个链表都是有环链表时，查看两链表相交的节点
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		//当一个链表有环，一个链表无环，这两个链表肯定不相交。
		return null;
	}

	//如果链表有环，返回第一个入环的节点
	//如果链表没有环，返回null
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; // n1 -> slow
		Node n2 = head.next.next; // n2 -> fast
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	//考察两个无环链表的相交节点
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		//通过变量n来最终表示，head1与head2长度差值的绝对值。
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
		//cur1指向较长的链表
		cur1 = n > 0 ? head1 : head2;
		//cur2指向较短的链表
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		//较长的链表先遍历n个节点
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		//然后，长链表和短链表一起遍历,找到第一个相等的节点。如果不相交，遍历到最后cur1与cur2都为null
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	//在两个链表都有环的情况，一共有两种相交的情况
	//参考一下这个图片：https://note.youdao.com/yws/public/resource/a15a948d45944dc3dcddca5a37c65054/xmlnote/51725E8F69F84C9B98DBEA458B1F0D34/9530
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		//两个有环链表的入环节点相同；和noLoop方法一样
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {//两个有环链表的入环节点不相同
			cur1 = loop1.next;
			//cur1在遍历一圈时，如果cur1 == loop2还不成立的话，就直接返回null；如果成立的话，就返回loop1
			//同理也可以使用cur2进行遍历。
			//即loop1和loop2都有可能是相交节点，无论返回哪一个，都对。
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
