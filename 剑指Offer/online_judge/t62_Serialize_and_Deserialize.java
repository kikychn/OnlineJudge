package online_judge;
/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
import java.util.*;

public class t62_Serialize_and_Deserialize {
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
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		String s1 = Serialize(root);
		System.out.println(s1);

		TreeNode s2 = Deserialize(s1);
		ArrayList<ArrayList<Integer>> result = Print(s2);
		for (ArrayList arr : result) {
			System.out.println(arr.toString());
		}
	}

	static String Serialize(TreeNode root) {
		if (root == null)
			return "";

		StringBuilder sb = new StringBuilder();
		Serialize(root, sb);
		return sb.toString();
	}

	static void Serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
			return;
		}

		sb.append(root.val);
		sb.append(",");
		Serialize(root.left, sb);
		Serialize(root.right, sb);
	}

	static TreeNode Deserialize(String str) {
		if (str.length() == 0)
			return null;
		String[] strs = str.split(",");

		return Deserialize(strs);
	}

	static int index = -1;

	static TreeNode Deserialize(String[] strs) {
		index++;
		if (!strs[index].equals("#")) {
			TreeNode root = new TreeNode(0);
			root.val = Integer.parseInt(strs[index]);
			root.left = Deserialize(strs);
			root.right = Deserialize(strs);
			return root;
		}
		return null;
	}

	// 此处引用t60_Print中的多行打印一棵树
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
