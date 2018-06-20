package online_judge;
/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 */
public class t47_Add {
	public static void main(String[] args) {
		int n1 = 5, n2 = 17;
		System.out.print(Add(n1, n2));
	}

	public static int Add(int num1, int num2) {
		int sum, carry;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;

			num1 = sum; 
			num2 = carry;
		} while (num2 != 0);

		return num1;
	}
}
