import java.util.Scanner;

public class Bellman_Ford {
	public static void main(String args[]) {
		int n, m;
		int u[] = new int[8];
		int v[] = new int[8];
		int w[] = new int[8];
		int first[] = new int[6];// first要比n的最大值1
		int next[] = new int[8];// next要比m的最大值大1

		int dis[] = new int[6];
		int book[] = new int[6];// book数组用来记录哪些顶点已经在队列中

		int que[] = new int[101];
		int head = 1, tail = 1;

		int INF = 99999999;

		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		// 初始化first数组下标1~n的值为-1，表示1~n顶点暂时都没有边
		for (int i = 1; i <= n; ++i) {
			first[i] = -1;
		}

		for (int i = 1; i <= m; ++i) {
			// 读入每一条边
			u[i] = cin.nextInt();
			v[i] = cin.nextInt();
			w[i] = cin.nextInt();
			// 建立邻接表
			next[i] = first[u[i]];
			first[u[i]] = i;
		}

		// 初始化dis数组，表示1号顶点到其余各个顶点的初始路程
		for (int i = 1; i <= n; ++i) {
			dis[i] = INF;
		}
		dis[1] = 0;

		// 初始化book数组，初始化为0，表明各个顶点开始都不在队列中
		for (int i = 1; i <= n; ++i) {
			book[i] = 0;
		}

		// 1号顶点入队
		que[tail] = 1;
		tail++;
		book[1] = 1;// 标记1号顶点已经入队

		// 队列优化的Bellman-Ford算法核心语句
		int k;
		while (head < tail) {
			k = first[que[head]];// 当前需要处理的队首顶点
			while (k != -1) {// 扫描当前顶点的所有出边
				if (dis[v[k]] > dis[u[k]] + w[k]) {
					dis[v[k]] = dis[u[k]] + w[k];// 更新顶点u[k]到v[k]的路程
				}
				if (book[v[k]] == 0) {// 表示不在队列中，将顶点v[k]加入队列中
					que[tail] = v[k];
					tail++;
					book[v[k]] = 1;
				}
				k = next[k];
			}
			book[que[head]] = 1;
			head++;
		}

		// 输出1号顶点到其余各个顶点的最短路径
		for (int i = 1; i <= n; ++i) {
			System.out.print(dis[i] + " ");
		}

	}
}
/*
Input:
5 7
1 2 2
1 5 10
2 3 3
2 5 7
3 4 4
4 5 5
5 3 6
Output:
0 2 5 9 9 
 */