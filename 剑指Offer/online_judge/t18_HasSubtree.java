package online_judge;
/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class t18_HasSubtree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(6);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        boolean result = hasSubTree(root1, root2);
        System.out.println(result);
    }

    public static boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                result = doesTree1HaveTree2(root1, root2);
            if (!result)
                result = hasSubTree(root1.left, root2);
            if (!result)
                result = hasSubTree(root1.right, root2);
        }

        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot2 == null)
            return true;

        if (pRoot1 == null)
            return false;

        if (pRoot1.val != pRoot2.val)
            return false;

        return doesTree1HaveTree2(pRoot1.left, pRoot2.left) && doesTree1HaveTree2(pRoot1.right, pRoot2.right);
    }

}
