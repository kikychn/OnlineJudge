package online_judge;
/**
 * 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @author kikychn
 */

public class t63_KthNode {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);

		TreeNode result = KthNode(root, 3);
		System.out.println(result.val);
	}

	static int index = 0;

	static TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot != null) {
			TreeNode node = KthNode(pRoot.left, k);
			if (node != null)
				return node;
			++index;
			if (index == k)
				return pRoot;
			node = KthNode(pRoot.right, k);
			if (node != null)
				return node;
		}
		return null;
	}
}
