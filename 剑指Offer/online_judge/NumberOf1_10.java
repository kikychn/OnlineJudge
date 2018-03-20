package online_judge;
/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1_10 {

    public static void main(String[] args) {
        int n = -5;
        int result = new Solution().NumberOf1(n);
        System.out.println(result);
    }

}

class Solution {
    public int NumberOf1(int n) {
        int count = 0;

        /* method1 */
//        int flag = 1;
//        while (flag != 0) {
//            if ((n & flag) != 0) {
//                ++count;
//            }
//            flag = flag << 1;
//        }

        /* method2 */
//        while (n != 0) {
//            if ((n & 1) != 0)
//                ++count;
//
//            n >>>= 1;
//        }

        /* method3 */
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }

        return count;
    }
}