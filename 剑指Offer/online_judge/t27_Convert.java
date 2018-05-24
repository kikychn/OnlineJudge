package online_judge;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class t27_Convert {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        TreeNode list = convert(root);

        while (list != null) {
            System.out.print(list.val + " ");
            list = list.right;
        }
    }

    public static TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;

        TreeNode last = null;
        last = convertNode(pRootOfTree, last);

        while (last.left != null) {
            last = last.left;
        }

        return last;
    }

    public static TreeNode convertNode(TreeNode pNode, TreeNode last) {
        if (pNode == null)
            return null;

        if (pNode.left != null)
            last = convertNode(pNode.left, last);

        pNode.left = last;
        if (last != null) {
            last.right = pNode;
        }
        last = pNode;

        if (pNode.right != null)
            last = convertNode(pNode.right, last);

        return last;
    }

}
