package online_judge;
/**
 * 链表中环的入口结点
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 */
public class t56_EntryNodeOfLoop {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);
		root.next.next.next.next.next.next = root.next.next;

		System.out.println(EntryNodeOfLoop(root).val);
	}

	/* 第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
	 * 第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; 
	 * n=x;可以看出p1实际走了一个环的步数，再让p1指向链表头部，p2位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。*/
	public static ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null)
			return null;

		ListNode p1 = pHead;
		ListNode p2 = pHead;
		int circle_node_num = 1;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				p1 = pHead;
				while (p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				if (p1 == p2)
					return p1;
			}
		}

		return null;
	}

}
