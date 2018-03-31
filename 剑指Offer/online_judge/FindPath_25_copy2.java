package online_judge;

import java.util.ArrayList;

public class FindPath_25_copy2 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        int target = 22;

        findPath(root, target);
        
        for (int i = 0; i < path.size(); ++i) {
            for (int j = 0; j < path.get(i).size(); ++j) {
                System.out.print(path.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    private static ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null)
            return path;

        ArrayList<Integer> curr = new ArrayList<Integer>();
        addPath(root, target, curr);
        return path;

    }

    public static void addPath(TreeNode node, int target, ArrayList<Integer> curr) {
        if (node == null)
            return;

        curr.add(node.val);
        if (node.val == target && node.left == null && node.right == null) {
            path.add(curr);
            return;
        }

        ArrayList<Integer> left = (ArrayList<Integer>) curr.clone();
        ArrayList<Integer> right = (ArrayList<Integer>) curr.clone();
        curr = null; 
        addPath(node.left, target - node.val, left);
        addPath(node.right, target - node.val, right);
    }
}
