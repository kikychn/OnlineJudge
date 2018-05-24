package online_judge;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class t39_IsBalanced_Solution {
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
		root.right.right.right = new TreeNode(6);

		System.out.print(IsBalanced_Solution1(root));
		System.out.print(IsBalanced_Solution2(root));
	}

	public static boolean IsBalanced_Solution1(TreeNode root) {
		if (root == null)
			return true;

		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		int diff = left - right;
		if (diff > 1 || diff < -1)
			return false;

		return IsBalanced_Solution1(root.left) && IsBalanced_Solution1(root.right);

	}

	public static int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		if (Math.abs(left - right) > 1) {
			isBalanced = false;
		}

		return 1 + (left > right ? left : right);
	}

	
	static boolean isBalanced = true;
	public static boolean IsBalanced_Solution2(TreeNode root) {
		TreeDepth(root);
		return isBalanced;
	}

}
