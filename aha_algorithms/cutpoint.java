import java.util.Scanner;
// 可用邻接表替代邻接矩阵存储图，时间复杂度由O(N^2)降到O(N+M)

public class cutpoint {
	static int n, m, N = 9;
	static int e[][] = new int[N][N];
	static int root;// 根结点
	static int num[] = new int[N];// 记录每个顶点的时间戳，初始化默认值为0，表明尚未访问过
	static int low[] = new int[N];// 记录每个顶点在不经过父顶点时，能够回到的最小时间戳
	static int flag[] = new int[N];// 标记顶点是否为割点
	static int index;// 用来进行时间戳的递增

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static void dfs(int cur, int father) {// 传入两个参数，当前顶点编号和父顶点的编号
		int child = 0;

		index++;
		num[cur] = index;// 当前顶点的时间戳
		low[cur] = index;// 当前顶点能够访问到的最早顶点的时间戳，一开始是自己

		for (int i = 1; i <= n; ++i) {
			if (e[cur][i] == 1) {
				if (num[i] == 0) {// 顶点i的时间戳为0，表示尚未被访问过
					child++;
					dfs(i, cur);
					low[cur] = min(low[cur], low[i]);// 更新当前顶点cur能访问到最早顶点的时间戳

					if (cur != root && low[i] >= num[cur])
						flag[cur] = 1;
					if (cur == root && child == 2)
						flag[cur] = 1;
				} else if (i != father) {
					// 否则顶点i被访问过，并且这个顶点不是当前顶点cur的父亲，
					// 说明此时i为cur的祖先，因此需要更新结点cur能访问到的最早顶点的时间戳
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
		// 初始化邻接矩阵
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

		root = 1;// 根结点设置为1
		dfs(1, root);// 从1号顶点开始进行深度优先遍历
		
		for(int i = 1; i <= n; ++i) {
			if(flag[i] == 1)
				System.out.print(i);
		}
		
		return;

	}

}
/*
Input:
6 7
1 4
1 3
4 2
3 2
2 5
2 6
5 6

Output:
2
*/

