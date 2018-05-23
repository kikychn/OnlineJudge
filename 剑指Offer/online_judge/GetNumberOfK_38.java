package online_judge;
/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 *
 */
public class GetNumberOfK_38 {
	public static void main(String[] args) {
		int[] list = { 3, 3, 3, 3, 4, 5 };
		System.out.print(GetNumberOfK(list, 3));
	}

	public static int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0)
			return 0;

		int firstK = GetFirstK(array, k, 0, array.length - 1);
		int lastK = GetLastK(array, k, 0, array.length - 1);

		if (firstK != -1 && lastK != -1)
			return lastK - firstK + 1;
		return 0;
	}

	public static int GetFirstK(int[] array, int k, int start, int end) {
		if (start > end)
			return -1;

		int middleIndex = (start + end) >> 1;
		int middleData = array[middleIndex];

		if (middleData == k) {
			if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0)
				return middleIndex;
			else
				end = middleIndex - 1;
		} else if (middleData > k)
			end = middleIndex - 1;
		else
			start = middleIndex + 1;

		return GetFirstK(array, k, start, end);

	}

	public static int GetLastK(int[] array, int k, int start, int end) {
		if (start > end)
			return -1;

		int middleIndex = (start + end) >> 1;
		int middleData = array[middleIndex];

		if (middleData == k) {
			if ((middleIndex < end && array[middleIndex + 1] != k) || middleIndex == end)
				return middleIndex;
			else
				start = middleIndex + 1;
		} else if (middleData > k)
			end = middleIndex - 1;
		else
			start = middleIndex + 1;

		return GetLastK(array, k, start, end);

	}
	
}
