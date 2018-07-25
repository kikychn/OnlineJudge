package online_judge;

import online_judge.t61_Print.TreeNode;

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

	static TreeNode KthNode(TreeNode pRoot, int k) {
		
	}
}
