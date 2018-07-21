package online_judge;

import java.util.ArrayList;

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
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(5);
		
		ArrayList<ArrayList<Integer>> result = Print(root);
		for(ArrayList arr:result) {
			System.out.println(arr.toString());
		}
		
	}

	static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		
	}
}
