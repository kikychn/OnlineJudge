package online_judge;
/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class t57_deleteDuplication {

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
		root.next.next.next = new ListNode(3);
		root.next.next.next.next = new ListNode(4);
		root.next.next.next.next.next = new ListNode(4);
		root.next.next.next.next.next.next = new ListNode(5);

		while (root != null) {
			System.out.println(deleteDuplication(root).val);
			root = root.next;
		}
	}

	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null)
			return null;

		ListNode head = new ListNode(0);
		ListNode end = head;
		ListNode now = pHead;

		head.next = pHead;
		while (now != null && now.next != null) {
			if (now.val == now.next.val) {
				int val = now.val;
				while (now != null && now.val == val) {
					now = now.next;
				}
				end.next = now;
			} else {
				end.next = now;
				end = now;
				now = now.next;
			}
		}

		return head.next;
	}

}
