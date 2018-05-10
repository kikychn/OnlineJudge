package online_judge;
/**
 * 丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 */
public class GetUglyNumber_Solution_34 {

	public static void main(String[] args) {
		int n = 7;
		System.out.print(GetUglyNumber_Solution2(n));
	}

	public static int GetUglyNumber_Solution(int index) {
		if (index <= 0)
			return 0;

		int uglyFound = 0;
		int number = 0;
		while (uglyFound < index) {
			++number;

			if (isUgly(number))
				++uglyFound;
		}

		return number;
	}

	public static boolean isUgly(int number) {
		while (number % 2 == 0)
			number /= 2;
		while (number % 3 == 0)
			number /= 3;
		while (number % 5 == 0)
			number /= 5;

		return (number == 1) ? true : false;
	}

	public static int GetUglyNumber_Solution2(int index) {
		if (index <= 0)
			return 0;

		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		int nextUglyIndex = 1;
		int multiply2 = 0, multiply3 = 0, multiply5 = 0;

		while (nextUglyIndex < index) {
			int min = Min(uglyNumbers[multiply2] * 2, uglyNumbers[multiply3] * 3, uglyNumbers[multiply5] * 5);
			uglyNumbers[nextUglyIndex] = min;

			while (uglyNumbers[multiply2] * 2 <= uglyNumbers[nextUglyIndex])
				++multiply2;
			while (uglyNumbers[multiply3] * 3 <= uglyNumbers[nextUglyIndex])
				++multiply3;
			while (uglyNumbers[multiply5] * 5 <= uglyNumbers[nextUglyIndex])
				++multiply5;

			++nextUglyIndex;
		}

		return uglyNumbers[nextUglyIndex - 1];
	}

	public static int Min(int num1, int num2, int num3) {
		int min = (num1 < num2) ? num1 : num2;
		min = (min < num3) ? min : num3;
		return min;
	}
}
