package online_judge;
/**
 * 和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
import java.util.ArrayList;

public class t41_FindContinuousSequence {
	public static void main(String[] args) {
		int sum = 15;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = FindContinuousSequence(sum);

		for (int i = 0; i < result.size(); ++i) {
			ArrayList<Integer> arr = result.get(i);
			for (int e : arr) {
				System.out.print(e);
			}
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (sum < 3)
			return list;

		int small = 1, big = 2;
		int curSum = small + big;
		int middle = (1 + sum) >> 1;

		while (small < middle) {

			if (curSum == sum) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for (int i = small; i <= big; ++i) {
					arr.add(i);
				}
				list.add(arr);
				curSum -= small;
				++small;
			}

			if (curSum < sum) {
				++big;
				curSum += big;
			} else {
				curSum -= small;
				++small;
			}

		}

		return list;
	}

}
