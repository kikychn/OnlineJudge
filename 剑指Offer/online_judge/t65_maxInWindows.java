package online_judge;
/**
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
import java.util.*;

public class t65_maxInWindows {
	public static void main(String[] args) {
		int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;
		ArrayList<Integer> result = maxInWindows(num, size);
		System.out.println(result.toString());
	}

	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<>();
		if (num == null || num.length < size || size < 1)
			return result;

		LinkedList<Integer> indexDeque = new LinkedList<>();
		for (int i = 0; i < size - 1; ++i) {
			while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
				indexDeque.removeLast();
			}
			indexDeque.addLast(i);
		}

		for (int i = size - 1; i < num.length; ++i) {
			while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
				indexDeque.removeLast();
			}
			indexDeque.addLast(i);

			if (i - indexDeque.getFirst() + 1 > size) {
				indexDeque.removeFirst();
			}
			result.add(num[indexDeque.getFirst()]);
		}

		return result;
	}
}
