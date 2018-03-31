package online_judge;

import java.util.ArrayList;

public class FindPath_25 {

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

        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        path = findPath(root, target);

        for (int i = 0; i < path.size(); ++i) {
            for (int j = 0; j < path.get(i).size(); ++j) {
                System.out.print(path.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();

        if (root == null)
            return path;

        int sum = 0;
        ArrayList<Integer> singlePath = new ArrayList<Integer>();
        addPath(path, singlePath, root, target, sum);

        return path;
    }

    public static void addPath(ArrayList<ArrayList<Integer>> path, ArrayList<Integer> singlePath, TreeNode root,
            int target, int sum) {
        if (root == null)
            return;

        singlePath.add(root.val);
        sum += root.val;

        if (sum == target && root.left == null && root.right == null) {
//            path.add((ArrayList<Integer>) singlePath.clone());
            path.add(new ArrayList<Integer>(singlePath));
            singlePath.remove(singlePath.size() - 1);
            sum -= root.val;
            return;
        }

        if (sum < target && root.left != null) {
            addPath(path, singlePath, root.left, target, sum);
        }
        if (sum < target && root.right != null) {
            addPath(path, singlePath, root.right, target, sum);
        }

        singlePath.remove(singlePath.size() - 1);
        sum -= root.val;
        return;
    }

}
