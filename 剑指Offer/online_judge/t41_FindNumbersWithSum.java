package online_judge;
/**
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
import java.util.ArrayList;

public class t41_FindNumbersWithSum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 7, 11, 15 };
		ArrayList<Integer> req = FindNumbersWithSum2(arr, 15);
		System.out.println(req.get(0) + " " + req.get(1));
	}

	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (array == null || array.length < 2)
			return result;

		int plus = 99999999, x = -1, y = -1;
		for (int i = 0; i < array.length; ++i) {
			for (int j = i + 1; j < array.length; ++j) {
				if (array[i] + array[j] == sum && array[i] * array[j] < plus) {
					x = array[i];
					y = array[j];
					plus = x * y;
				}
			}
		}

		if (x != -1 && y != -1) {
			result.add(Math.min(x, y));
			result.add(Math.max(x, y));
		}

		return result;

	}

	public static ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (array == null || array.length < 2)
			return result;

		int start = 0, end = array.length - 1;
		int plus = 99999999, x = -1, y = -1;
		while (start < end) {
			int curSum = array[start] + array[end];
			int curPlus = array[start] * array[end];

			if (curSum == sum) {
				if (curPlus < plus) {
					x = array[start];
					y = array[end];
					plus = curPlus;
				}
				--end;
				++start;
			} else if (curSum > sum)
				--end;
			else
				++start;
		}

		if (x != -1 && y != -1) {
			result.add(Math.min(x, y));
			result.add(Math.max(x, y));
		}

		return result;

	}

}
