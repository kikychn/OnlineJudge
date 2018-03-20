import java.util.Scanner;

//最小堆解决堆排序问题
public class MinHeap {
	static int h[] = new int[101];// 用来存放堆的数组
	static int n;// 存储堆中元素的个数，也就是堆的大小

	// 交换函数，用于交换堆中的两个元素的值
	static void swap(int x, int y) {
		int t;
		t = h[x];
		h[x] = h[y];
		h[y] = t;
		return;
	}

	// 向下调整函数
	static void siftdown(int i) {
		int t, flag = 0;
		while (i * 2 <= n && flag == 0) {
			// 首先判断它与左子树的关系，并用t记录较小的结点编号
			if (h[i] > h[i * 2]) {
				t = i * 2;
			} else {
				t = i;
			}

			// 如果它有右儿子，再对右儿子进行讨论
			if ((i * 2 + 1) <= n) {
				// 如果右儿子的值更小，更新较小的结点编号
				if (h[t] > h[i * 2 + 1]) {
					t = i * 2 + 1;
				}
			}

			// 如果发现最小的结点编号不是自己，说明子结点中有比父结点更小的
			if (t != i) {
				swap(i, t);
				i = t;// 更新i为刚才与它交换的儿子结点的编号，便于接下来继续向下调整
			} else {
				flag = 1;// 说明当前的父结点已经比两个子结点都小，不需要再调整了
			}

		}
		return;
	}

	// 建立堆的函数
	static void creat() {
		for (int i = n / 2; i >= 1; --i) {
			siftdown(i);
		}
	}

	// 删除最小的元素
	static int deletemin() {
		int t = h[1];// 用一个临时变量记录堆顶的值(最小值)
		h[1] = h[n];// 将堆的最后一个点赋值到堆顶
		--n;// 堆的元素减少1
		siftdown(1);// 向下调整
		return t;// 返回之间记录的堆顶点的最小值
	}

	public static void main(String args[]) {
		int num;
		Scanner cin = new Scanner(System.in);
		num = cin.nextInt();// 读入要排序的数字的个数

		for (int i = 1; i <= num; ++i) {
			h[i] = cin.nextInt();
		}
		n = num;

		// 建堆
		creat();

		// 删除堆顶元素，连续删除n次，也就是从小到大把数输出来
		for (int i = 1; i <= num; ++i) {
			System.out.print(deletemin() + " ");
		}

	}
}
/*
Input:
14
99 5 36 7 22 17 46 12 2 19 25 28 1 92

Output:
1 2 5 7 12 17 19 22 25 28 36 46 92 99
 */
