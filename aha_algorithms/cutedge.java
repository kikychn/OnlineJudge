import java.util.Scanner;

public class cutedge {
	static int n, m, N = 9;
	static int e[][] = new int[N][N];
	static int num[] = new int[N];
	static int low[] = new int[N];
	static int flag[] = new int[N];
	static int root, index;

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static void dfs(int cur, int father) {
		index++;
		num[cur] = index;
		low[cur] = index;

		for (int i = 1; i <= n; ++i) {
			if (e[cur][i] == 1) {
				if (num[i] == 0) {
					dfs(i, cur);
					low[cur] = min(low[cur], low[i]);

					if (low[i] > num[cur])
						System.out.println(cur + "-" + i);

				} else if (i != father) {
					low[cur] = min(low[cur], num[i]);
				}
			}
		}
		return;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		// ¶ÁÈë±ß£¬ÁÚ½Ó¾ØÕó´æ´¢
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				e[i][j] = 0;
			}
		}
		int x, y;
		for (int i = 1; i <= m; ++i) {
			x = cin.nextInt();
			y = cin.nextInt();
			e[x][y] = 1;
			e[y][x] = 1;
		}

		root = 1;
		dfs(1, root);
		
		return;

	}

}
/*
Input:
6 6
1 4
1 3
4 2
3 2
2 5
5 6

Output:
5-6
2-5
*/