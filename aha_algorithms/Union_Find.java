import java.util.Scanner;
// 并查集
public class Union_Find {
	static int f[] = new int[1000];
	static int n, m, k, sum = 0;

	static void init() {
		for (int i = 1; i <= n; ++i) {
			f[i] = i;
		}
	}

	// 找爹的递归函数，不停地去找爹，直到找到祖宗为止，“擒贼先擒王”原则
	static int getf(int v) {
		if (f[v] == v) {
			return v;
		} else {
			f[v] = getf(f[v]);
			return f[v];
		}
	}

	// 合并两个子集合的函数
	static void merge(int v, int u) {
		int t1, t2;
		t1 = getf(v);
		t2 = getf(u);
		if (t1 != t2) {// 判断两个结点是否在同一个集合中，即是否为同一个祖先
			f[t2] = t1;
		}
		return;
	}

	public static void main(String args[]) {
		int x, y;

		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		init();// 初始化
		for (int i = 1; i <= m; ++i) {
			x = cin.nextInt();
			y = cin.nextInt();
			merge(x, y);
		}

		for (int i = 1; i <= n; ++i) {
			if (f[i] == i) {
				++sum;
			}
		}

		System.out.println(sum);

	}
}
/*
Input:
10 9
1 2
3 4
5 2
4 6
2 6
8 7
9 7
1 6
2 4

Output:
3
*/