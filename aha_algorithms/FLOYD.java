import java.util.Scanner;

public class FLOYD {
	public static void main(String args[]) {
		int N = 10;
		int e[][] = new int[N][N];
		int n, m;
		int INF = 99999999;

		Scanner cin = new Scanner(System.in);
		n = cin.nextInt(); // n表示顶点个数
		m = cin.nextInt(); // m表示边的条数

		for (int i = 1; i <= n; ++i) { // 邻接矩阵表示图
			for (int j = 1; j <= n; ++j) {
				if (i == j) {
					e[i][j] = 0;
				} else {
					e[i][j] = INF;
				}
			}
		}

		int t1, t2, t3;
		for (int i = 1; i <= m; ++i) {
			t1 = cin.nextInt();
			t2 = cin.nextInt();
			t3 = cin.nextInt();
			e[t1][t2] = t3;
		}

		// Floyd-Warshall算法核心语句,不能处理“负权回路（负权环）”的图。
		for (int k = 1; k <= n; ++k) {
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					if (e[i][k] < INF && e[k][j] < INF && e[i][j] > e[i][k] + e[k][j]) {
						e[i][j] = e[i][k] + e[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				System.out.print(e[i][j] + " ");
			}
			System.out.println();
		}

	}
}
/*
Input:
4 8
1 2 2
1 3 6
1 4 4
2 3 3
3 1 7
3 4 1
4 1 5
4 3 12

Output:
0 2 5 4 
9 0 3 4 
6 8 0 1 
5 7 10 0 
 */