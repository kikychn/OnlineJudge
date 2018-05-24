package online_judge;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class t9_Fibonacci {

    public static int Fibonacci(int n) {
        /* method1,递归 */
//        if (n <= 0)
//            return 0;
//        if (n == 1)
//            return 1;
//        return Fibonacci(n - 1) + Fibonacci(n - 2);

        /* method2, */
        int[] result = { 0, 1 };
        if (n < 2)
            return result[n];

        int fibMinusOne = 1, fibMinusTwo = 0;
        int fibN = 0;
        for (int i = 2; i <= n; ++i) {
            fibN = fibMinusOne + fibMinusTwo;

            fibMinusTwo = fibMinusOne;
            fibMinusOne = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        int n = 37;
        int result = Fibonacci(n);
        System.out.println(result);
    }

}
