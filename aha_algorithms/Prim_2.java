import java.util.Scanner;

public class Prim_2 {
	static int dis[] = new int[7];// 记录点距离生成树的最短距离
	static int book[] = new int[7];// 记录点是否已在生成树中
	static int h[] = new int[7];// h用来保存堆
	static int pos[] = new int[7];// pos用来存储每个顶点在堆中的位置
	static int size;// 记录堆的大小

	// 交换函数，用来交换堆中的两个元素的值
	static void swap(int x, int y) {
		int t;
		t = h[x];
		h[x] = h[y];
		h[y] = t;

		t = pos[h[x]];
		pos[h[x]] = pos[h[y]];
		pos[h[y]] = t;
		return;
	}

	// 向下调整函数
	static void siftdown(int i) {// 传入一个需要向下调整的结点编号
		int t, flag = 0;// flag用来记录是否需要继续向下调整
		while (i * 2 <= size && flag == 0) {
			if (dis[h[i * 2]] < dis[h[i]]) {
				t = i * 2;// 用t记录值较小的结点编号
			} else {
				t = i;
			}

			if (i * 2 + 1 <= size) {
				if (dis[h[i * 2 + 1]] < dis[h[i]]) {
					t = i * 2 + 1;
				}
			}

			if (t != i) {
				swap(i, t);
				i = t;
			} else {
				flag = 1;
			}
		}
		return;
	}

	static void siftup(int i) {// 传入一个需要向上调整的结点编号i
		int flag = 0;
		if (i == 1)
			return;
		while (i != 1 && flag == 0) {
			if (dis[h[i]] < dis[h[i / 2]]) {
				swap(i, i / 2);
			} else {
				flag = 1;
			}
			i = i / 2;
		}
		return;
	}

	// 从堆顶取出一个元素
	static int pop() {
		int t;
		t = h[1];
		pos[t] = 0;
		h[1] = h[size];
		pos[h[1]] = 1;
		size--;
		siftdown(1);
		return t;
	}

	public static void main(String args[]) {
		int n, m, count = 0, sum = 0;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		// 读入边
		int u[] = new int[19];
		int v[] = new int[19];
		int w[] = new int[19];
		int a, b, c;
		for (int i = 1; i <= m; ++i) {
			u[i] = cin.nextInt();
			v[i] = cin.nextInt();
			w[i] = cin.nextInt();
		}
		// 这里是无向图，所以需要将所有的边再反方向存储一次
		for (int i = m + 1; i <= 2 * m; ++i) {
			u[i] = v[i - m];
			v[i] = u[i - m];
			w[i] = w[i - m];
		}

		// 邻接表存储边
		int first[] = new int[n + 1];
		int next[] = new int[2*m + 1];
		for (int i = 1; i <= n; ++i) {
			first[i] = -1;
		}
		for (int i = 1; i <= 2 * m; ++i) {
			next[i] = first[u[i]];
			first[u[i]] = i;
		}

		/* Prim核心部分开始 */
		// 将1号顶点加入生成树
		book[1] = 1;
		count++;
		// 初始化dis数组，这里是1号顶点到其余各个顶点的初始距离
		int INF = 999999999;
		dis[1] = 0;
		for (int i = 2; i <= n; ++i) {
			dis[i] = INF;
		}
		int k = first[1];
		while (k != -1) {
			dis[v[k]] = w[k];
			k = next[k];
		}
		// 初始化堆
		size = n;
		for (int i = 1; i <= size; ++i) {
			h[i] = i;
			pos[i] = i;
		}
		for (int i = n / 2; i >= 1; --i) {
			siftdown(i);
		}
		pop();// 先弹出一个堆顶元素，因为此时堆顶是1号顶点

		int j;
		while (count < n) {
			j = pop();
			book[j] = 1;
			count++;
			sum += dis[j];

			k = first[j];
			while (k != -1) {
				if (book[v[k]] == 0 && dis[v[k]] > w[k]) {
					dis[v[k]] = w[k];
					siftup(pos[v[k]]);
				}
				k = next[k];
			}
		}

		System.out.println(sum);

	}
}
/*
Input:
6 9
2 4 11
3 5 13
4 6 3
5 6 4
2 3 6
4 5 7
1 2 1
3 4 9
1 3 2

Output:
19
*/
