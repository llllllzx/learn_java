package class_03;

public class Code_07_ReverseList {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static class DoubleNode {
		public int value;
		public DoubleNode last;
		public DoubleNode next;

		public DoubleNode(int data) {
			this.value = data;
		}
	}

	public static DoubleNode reverseList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void printDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List: ");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.last;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		printLinkedList(head1);
		head1 = reverseList(head1);
		printLinkedList(head1);

		DoubleNode head2 = new DoubleNode(1);
		head2.next = new DoubleNode(2);
		head2.next.last = head2;
		head2.next.next = new DoubleNode(3);
		head2.next.next.last = head2.next;
		head2.next.next.next = new DoubleNode(4);
		head2.next.next.next.last = head2.next.next;
		printDoubleLinkedList(head2);
		printDoubleLinkedList(reverseList(head2));

	}

	/**
	 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
	 *
	 * k 是一个正整数，它的值小于或等于链表的长度。
	 *
	 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
	 */
	public static  Node reverseKGroup(Node head, int k) {
		if(head == null){
			return null;
		}
		Node a = head,b = head;
		for(int i = 0; i< k;i++){
			//请将最后剩余的节点保持原有顺序
			if(b == null){
				return head;
			}
			b = b.next;
		}

		Node newHead = reverseList(a,b);
		a.next = reverseKGroup(b,k);
		return newHead;

	}

	//旋转指定两个节点的链表
	public static Node reverseList(Node a,Node b){
		Node pre = null;
		Node next = a;
		Node cur = a;
		while(cur != b){
			next = cur.next;
			cur.next =pre;
			pre = cur;
			cur =next;
		}
		return pre;
	}

}
