package online_judge;
/**
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom_23 {

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

        ArrayList<Integer> tree = printFromTopToBottom(root);
        for (int i = 0; i < tree.size(); ++i) {
            System.out.print(tree.get(i) + " ");
        }
    }

    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> tree = new ArrayList<Integer>();

        if (root == null)
            return tree;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tree.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

        return tree;
    }

}
