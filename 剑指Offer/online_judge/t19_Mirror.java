package online_judge;
/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class t19_Mirror {

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
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        printTree(root);
        System.out.println();

        Mirror(root);
        printTree(root);
    }

    // 先序遍历
    public static void printTree(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");

        printTree(node.left);
        printTree(node.right);
    }

    public static void Mirror(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
    }
}
