package online_judge;
/**
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 *
 */
public class t37_FindFirstCommonNode {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode root1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(6);
		ListNode node5 = new ListNode(7);
		ListNode root2 = new ListNode(4);
		ListNode node6 = new ListNode(5);

		root1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		root2.next = node6;
		node6.next = node4;

		ListNode result = FindFirstCommonNode(root1, root2);
		System.out.print(result.val);

	}

	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null)
			return null;

		int len1 = getListLength(pHead1);
		int len2 = getListLength(pHead2);
		ListNode cur1 = pHead1;
		ListNode cur2 = pHead2;

		if (len1 > len2) {
			for (int i = 0; i < len1 - len2; ++i) {
				cur1 = cur1.next;
			}
		} else if (len1 < len2) {
			for (int i = 0; i < len2 - len1; ++i) {
				cur2 = cur2.next;
			}
		}

		while (cur1 != null && cur2 != null && cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}

		return cur1;

	}

	public static int getListLength(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			++len;
		}
		return len;
	}

}
