package online_judge;
/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

public class t39_TreeDepth {

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
