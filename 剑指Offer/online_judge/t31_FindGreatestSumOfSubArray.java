package online_judge;
/**
 * 连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续多个整数组成一个子数组。
 * 求所有子数组的和最大值。要求时间复杂度为O(n)
 *
 */
public class t31_FindGreatestSumOfSubArray {

	public static void main(String[] args) {
		// int[] num = { 1, -2, 3, 10, -4, 7, 2, -5 };
		int[] num = { 2, 8, 1, 5, 9 };
		int result = FindGreatestSumOfSubArray(num);
		System.out.print(result);
	}

	public static int FindGreatestSumOfSubArray(int[] array) {
		if (array.length == 1)
			return array[0];

		// method1，O(n^2)，枚举出数组的所有子数组，并求和
//		int max = -99999999;
//		for (int i = 1; i <= array.length; ++i) {
//			for (int j = 0; j <= array.length - i; ++j) {
//				int sum = array[j], count = j + 1;
//				for (int k = 1; k < i; ++k) {
//					sum += array[count];
//					++count;
//				}
//				if (sum > max)
//					max = sum;
//			}
//		}
//		return max;

		// method2，O(n)，分析数组的规律(动态规划)，若前几项的和为负，则抛弃掉前面的项
		int max = -99999999, sum = 0;
		for (int i = 0; i < array.length; ++i) {
			if (sum < 0)
				sum = array[i];
			else
				sum += array[i];

			if (max < sum)
				max = sum;
		}
		return max;

	}

}
