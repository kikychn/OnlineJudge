package online_judge;
/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 */
public class t40_FindNumsAppearOnce {

	public static void main(String[] args) {
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		int num1[] = { 0 }, num2[] = { 0 };
		FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + " " + num2[0]);
	}

	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length < 2)
			return;

		// 两个只出现一次的数字的异或结果
		int resultExclusiveOR = 0;
		for (int i = 0; i < array.length; ++i)
			resultExclusiveOR ^= array[i];

		// 在結果数字中找到第一个为1的位的位置，记为第n位
		int flag = 1;
		while ((resultExclusiveOR & flag) == 0)
			flag <<= 1;
		
		// 以第n位为标准把原数组中的数字分成两个子数组
		for (int i = 0; i < array.length; ++i) {
			if ((flag & array[i]) == 0)
				num1[0] ^= array[i];
			else
				num2[0] ^= array[i];
		}

	}

}
