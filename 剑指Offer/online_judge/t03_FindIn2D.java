package online_judge;

/**
 * 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class t03_FindIn2D {
	public static boolean Find(int target, int[][] array) {

		/* method1,O(N^2) */
		/******
		if (array == null || array.length <= 0)
			return false;

		int rows = array.length, cols = array[0].length;
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (array[i][j] == target) {
					return true;
				}
			}
		}
		return false;
		******/

		/* method2,O(M+N) */
		if (array == null || array.length <= 0) {
			return false;
		}

		int rows = array.length, cols = array[0].length;
		int row = 0, col = cols - 1;
		while (row < rows && col >= 0) {
			if (target == array[row][col])
				return true;
			if (target < array[row][col]) {
				--col;
				if (col < 0)
					break;
			}
			if (target > array[row][col])
				++row;
		}
		return false;
		
	}

	public static void main(String[] args) {
		int target1 = 7, target2 = 5;
		int[][] array1 = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int[][] array2 = null;
		int[][] array3 = new int[0][0];

		boolean result1 = Find(target1, array1);
		boolean result2 = Find(target2, array1);
		boolean result3 = Find(target2, array2);
		boolean result4 = Find(target2, array3);

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}

}
