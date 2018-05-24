package online_judge;
/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class t33_PrintMinNumber {

	public static void main(String[] args) {
//		int[] num = { 3, 32, 321, };
//		int[] num = { 3, 5, 1, 4, 2, 45};
		int[] num = {3334,3,3333332};
		String str = PrintMinNumber(num);
		System.out.print(str);
	}

	public static String PrintMinNumber(int[] numbers) {
		String result = "";
		if (numbers == null || numbers.length == 0)
			return result;

		Comparator<Integer> cmp = new Comparator<Integer>() { // 优先队列中的比较函数，构建最小堆
			public int compare(Integer o1, Integer o2) {
				String o1Str = o1.toString(), o2Str = o2.toString();
				// return o1Str.compareTo(o2Str);
				int isBig = 0;
				int i = 0;
				for (; i < o1Str.length() && i < o2Str.length(); ++i) {
					isBig = o1Str.charAt(i) - o2Str.charAt(i);
					if (isBig != 0)
						break;
				}
				if (i == o1Str.length() || i == o2Str.length()) {
					while(i<o1.toString().length()) {																																							
						isBig = o1Str.charAt(i) - o1Str.charAt(0);
						if(isBig != 0) break;
						++i;
					}
				}

				return isBig;
			}
		};
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(numbers.length, cmp);
		for (int i = 0; i < numbers.length; ++i) {
			minHeap.add(numbers[i]);
		}

		while (minHeap.isEmpty() == false) {
			result = result.concat(minHeap.poll().toString());
		}

		return result;
	}

}
