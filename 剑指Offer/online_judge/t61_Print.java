package online_judge;
/**
 * 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
import java.util.*;


public class t61_Print {
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
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		ArrayList<ArrayList<Integer>> result = Print(root);
		for (ArrayList arr : result) {
			System.out.println(arr.toString());
		}
	}

	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null)
			return result;

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(pRoot);
		while (true) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			while (!s1.empty()) {
				TreeNode node = s1.pop();
				arr.add(node.val);
				if (node.left != null)
					s2.push(node.left);
				if (node.right != null)
					s2.push(node.right);
			}
			result.add(arr);
			if (s1.empty() && s2.empty())
				break;

			arr = new ArrayList<Integer>();
			while (!s2.empty()) {
				TreeNode node = s2.pop();
				arr.add(node.val);
				if (node.right != null)
					s1.push(node.right);
				if (node.left != null)
					s1.push(node.left);
			}
			result.add(arr);
			if (s1.empty() && s2.empty())
				break;
		}

		return result;
	}
}
