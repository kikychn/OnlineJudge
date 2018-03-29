package online_judge;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST_24 {

    public static void main(String[] args) {
        // int[] seq = {5, 7, 6, 9, 11, 10, 8};
        int[] seq = { 7, 4, 6, 5 };
        boolean result = verifySquenceOfBST(seq);
        System.out.print(result);
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;

        return isBST(sequence, 0, sequence.length - 1);
    }

    public static boolean isBST(int[] seq, int start, int end) {
        if (start >= end)
            return true;

        int i = start;
        for (; i < end; ++i) {
            if (seq[i] > seq[end])
                break;
        }

        int j = i;
        for (; j < end; ++j) {
            if (seq[j] < seq[end])
                return false;
        }

        return isBST(seq, start, i - 1) && isBST(seq, i, end - 1);
    }

}
