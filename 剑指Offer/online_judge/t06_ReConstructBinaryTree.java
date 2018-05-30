package online_judge;

import java.io.IOException;

/**
 * 重建二叉树 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class t06_ReConstructBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // method,递归
        if (pre == null || in == null || pre.length <= 0 || in.length == 0) {
            return null;
        }

        TreeNode root = reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int[] in, int startPre, int endPre, int startIn,
            int endIn) {

        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);
        root.left = null;
        root.right = null;

        int leftLength = 0, rightLength = 0;
        for (int i = startIn; i <= endIn; ++i) {
            if (in[i] == pre[startPre])
                break;
            leftLength++;
        }
        rightLength = endPre - startPre - leftLength;

        if (leftLength > 0) {
            root.left = reConstructBinaryTree(pre, in, startPre + 1, startPre + leftLength, startIn,
                    startIn + leftLength - 1);
        }
        if (rightLength > 0) {
            root.right = reConstructBinaryTree(pre, in, startPre + leftLength + 1, endPre, startIn + leftLength + 1,
                    endIn);
        }

        return root;
    }

    public static void showTree(TreeNode tree) {
        if (tree == null)
            return;
        System.out.print(tree.val + " ");
        showTree(tree.left);
        showTree(tree.right);
        return;
    }

    public static void main(String[] args) {
        // 普通二叉树
        int[] pre1 = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in1 = { 4, 7, 2, 1, 5, 3, 8, 6 };

        // 完全二叉树
        int[] pre2 = { 1, 2, 4, 5, 3, 6 };
        int[] in2 = { 4, 2, 5, 1, 6, 3 };

        // 所有结点都没有右子节点
        int[] pre3 = { 1, 2, 3, 4 };
        int[] in3 = { 4, 3, 2, 1 };

        // 所有结点都没有左子节点
        int[] pre4 = { 1, 2, 3, 4 };
        int[] in4 = { 1, 2, 3, 4 };

        // 只有一个结点
        int[] pre5 = { 1 };
        int[] in5 = { 1 };

        // 根结点指针为空
        int[] pre6 = null;
        int[] in6 = { 4, 2, 5, 1, 6, 3 };

        // 前序遍历序列和中序遍历序列不匹配
        int[] pre7 = { 1, 2, 4, 5, 7, 3, 6 };
        int[] in7 = { 4, 2, 5, 7, 1, 3, 6 };

        TreeNode tree = reConstructBinaryTree(pre7, in7);
        showTree(tree);

    }

}
