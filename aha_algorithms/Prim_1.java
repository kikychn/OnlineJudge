import java.util.Scanner;

// 时间复杂度是O(N^2)
public class Prim_1 {
	public static void main(String args[]) {
		int N = 7;
		int e[][] = new int[N][N];// 邻接矩阵存储边
		int dis[] = new int[N];// 记录点距离生成树的最短距离
		int book[] = new int[N];// 记录点是否已在生成树中
		int n, m, INF = 99999999;
		int count = 0, sum = 0;

		// 输入n和m，n表示顶点数，m表示边数
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		// 初始化邻接矩阵
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i == j)
					e[i][j] = 0;
				else
					e[i][j] = INF;
			}
		}

		// 读入边
		int t1, t2, t3;
		for (int i = 1; i <= m; ++i) {
			t1 = cin.nextInt();
			t2 = cin.nextInt();
			t3 = cin.nextInt();
			e[t1][t2] = t3;
			e[t2][t1] = t3;
		}

		// 初始化dis数组，这里是1号顶点到各个顶点的初始距离                                                                                                                                                                                                                                                                                                                                                                                                                      
		for (int i = 1; i <= n; ++i) {
			dis[i] = e[1][i];
		}	
           
		// 初始化book数组
		for (int i = 1; i <= n; ++i) {
			book[i] = 0;
		}

		// Prim核心部分
		book[1] = 1;// 1号顶点加入生成树                                                                  
		count++;
		int min, u;
		while (count < n) {
			min = INF;
			u = -1;
			// 找到距离生成树最近的顶点
			for (int i = 1; i <= n; ++i) {
				if (book[i] == 0 && dis[i] < min) {
					min = dis[i];
					u = i;
				}
			}
			book[u] = 1;
			count++;
			sum += dis[u];
			// 松弛,扫描当前顶点u所有的边，再以为中间点，更新生成树到每一个非树顶点的距离
			for (int i = 1; i <= n; ++i) {
				if (book[i] == 0 && dis[i] > e[u][i]) {
					dis[i] = e[u][i];
				}
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