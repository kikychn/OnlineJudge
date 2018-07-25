package online_judge;
/**
 * 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import online_judge.t59_isSymmetrical.TreeNode;

public class t60_Print {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);

		ArrayList<ArrayList<Integer>> result = Print(root);
		for (ArrayList arr : result) {
			System.out.println(arr.toString());
		}

	}

	static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null)
			return result;

		Queue<TreeNode> layer = new LinkedList<TreeNode>();
		ArrayList<Integer> layerList = new ArrayList<Integer>();
		layer.add(pRoot);
		int start = 0;
		int end = 1;
		while (!layer.isEmpty()) {
			TreeNode cur = layer.remove();
			layerList.add(cur.val);
			start++;

			if (cur.left != null) {
				layer.add(cur.left);
			}
			if (cur.right != null) {
				layer.add(cur.right);
			}

			if (start == end) {
				result.add(layerList);
				layerList = new ArrayList<Integer>();
				start = 0;
				end = layer.size();
			}
		}

		return result;
	}

}
