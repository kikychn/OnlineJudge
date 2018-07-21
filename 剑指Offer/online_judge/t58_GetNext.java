package online_judge;
/**
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
import online_judge.t57_deleteDuplication.ListNode;

public class t58_GetNext {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.left.next = root;
		root.left.left = new TreeLinkNode(4);
		root.left.left.next = root.left;
		root.left.right = new TreeLinkNode(5);
		root.left.right.next = root.left;
		root.left.right.left = new TreeLinkNode(6);
		root.left.right.left.next = root.left.right;
		root.left.right.right = new TreeLinkNode(7);
		root.left.right.right.next = root.left.right;
		root.right = new TreeLinkNode(3);
		root.right.next = root;
		root.right.left = new TreeLinkNode(8);
		root.right.left.next = root.right;
		root.right.right = new TreeLinkNode(9);
		root.right.right.next = root.right;

		while (root != null) {
			System.out.println(GetNext(root.left.right.right).val);
			root = root.next;
		}
	}

	public static TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null)
			return null;
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}
		while (pNode.next != null) {
			if (pNode.next.left == pNode)
				return pNode.next;
			pNode = pNode.next;
		}
		return null;
	}

}
