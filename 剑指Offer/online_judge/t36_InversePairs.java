package online_judge;
/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 */
public class t36_InversePairs {

	public static void main(String[] args) {
		int[] arr = { 7, 5, 6, 4 };
		System.out.print(InversePairs2(arr));
	}

	// 此方法超时
	public static int InversePairs(int[] array) {
		int result = 0;
		if (array == null || array.length == 0)
			return result;

		for (int i = 0; i < array.length; ++i) {
			for (int j = i + 1; j < array.length; ++j) {
				if (array[i] > array[j])
					result++;
			}
		}

		return result;
	}

	public static int InversePairs2(int[] array) {
		int result = 0;
		if (array == null || array.length == 0)
			return result;

		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; ++i) {
			copy[i] = array[i];
		}

		result = InversePairsCore(array, copy, 0, array.length - 1);

		return result;
	}

	public static int InversePairsCore(int[] array, int[] copy, int start, int end) {
		if (start == end)
			return 0;

		int mid = (start + end) >> 1;
		int leftCount = InversePairsCore(array, copy, start, mid);
		int rightCount = InversePairsCore(array, copy, mid + 1, end);

		int count = 0;
		int i = mid, j = end, locCopy = end;
		while (i >= start && j > mid) {
			if (array[i] > array[j]) {
				count += j - mid;
				copy[locCopy--] = array[i--];
				if (count >= 1000000007) {
					count %= 1000000007; // 1000000007 是最小的十位质数。模1000000007，可以保证值永远在int的范围内。
				}
			} else {
				copy[locCopy--] = array[j--];
			}
		}
		while (i >= start) {
			copy[locCopy--] = array[i--];
		}
		while (j > mid) {
			copy[locCopy--] = array[j--];
		}

		for (int s = start; s <= end; ++s) {
			array[s] = copy[s];
		}

		return (leftCount + rightCount + count) % 1000000007;
	}

}
