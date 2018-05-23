package online_judge;

import online_judge.FindPath_25.TreeNode;

public class TreeDepth_39 {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.right.right = new TreeNode(6);

		System.out.print(TreeDepth(root));
	}

	public static int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;

		int nLeft = TreeDepth(root.left);
		int nRight = TreeDepth(root.right);

		return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
	}
}
