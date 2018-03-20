import java.util.Scanner;

// 图的最小生成树
public class Kruskal {

	static Edge e[] = new Edge[10];// 数组大小根据实际情况来设置，要比m的最大值大1

	static int n, m;
	static int sum = 0, count = 0;// 并查集需要用到的一些变量，f数组的大小根据实际情况来设置，要比n的最大值大1
	static int f[] = new int[7];

	static void quicksort(int left, int right) {
		int i, j;
		Edge t = new Edge();

		if (left > right) {
			return;
		}

		i = left;
		j = right;
		while (i != j) {
			// 顺序很重要，要先从右边开始
			while (e[j].w >= e[left].w && i < j) {
				j--;
			}
			// 再从左边开始找
			while (e[i].w <= e[left].w && i < j) {
				i++;
			}
			// 交换
			if (i < j) {
				t = e[i];
				e[i] = e[j];
				e[j] = t;
			}
		}
		// 最终将基准数归位，将left和i
		t = e[left];
		e[left] = e[i];
		e[i] = t;

		quicksort(left, i - 1);// 继续处理左边的
		quicksort(i + 1, right);// 继续处理右边的
		return;
	}

	// 并查集寻找祖先的函数
	int temp;
	static int getf(int v) {
		if (f[v] == v) {
			return v;
		} else {
			// 这里是路径压缩
			f[v] = getf(f[v]);// 此处等号左侧和下一行的df[v]改为任意变量均可，如可换为temp
			return f[v];
		}
	}

	// 并查集合并两个子集的函数
	static boolean merge(int v, int u) {
		int t1, t2;
		t1 = getf(v);
		t2 = getf(u);
		if (t1 != t2) {
			f[t2] = t1;
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();// n表示顶点个数
		m = cin.nextInt();// m表示边的条数
		e = new Edge[m+1];
		// 读入边
		int a, b, c;
		for (int i = 1; i <= m; i++) {
			a = cin.nextInt();
			b = cin.nextInt();
			c = cin.nextInt();
			e[i] = new Edge(a,b,c);
		}

		quicksort(1, m);// 按权值从小到大对边进行快速排序

		f = new int[n+1];
		// 并查集初始化
		for (int i = 1; i <= n; i++) {
			f[i] = i;
		}

		// Kruskal算法核心部分
		for (int i = 1; i <= m; i++) {
			// 判断一条边的两个顶点是否已经连通，即判断是否已在同一个集合中
			if (merge(e[i].u, e[i].v)) {
				count++;
				sum += e[i].w;
			}

			if (count == n - 1) {
				break;
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