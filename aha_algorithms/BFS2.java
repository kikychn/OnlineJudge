import java.util.Arrays;
import java.util.Scanner;

public class BFS2 {
	public static void main(String args[]) {
		int N = 51 + 10;
		boolean e[][] = new boolean[N][N];
		int n, m, start, end;

		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		start = cin.nextInt();
		end = cin.nextInt();

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i == j)
					e[i][j] = true;
				else
					e[i][j] = false;
			}
		}

		for (int i = 0; i < m; ++i) {
			int a = cin.nextInt();
			int b = cin.nextInt();
			e[a][b] = true;
			e[b][a] = true;
		}

		int head = 1, tail = 1;
		int que[] = new int[N];
		boolean book[] = new boolean[N];
		Arrays.fill(book, false);
		int step = 0;
		que[tail] = start;
		book[start] = true;
		tail++;

		while (head < tail) {
			int len = tail - head;
			for (int i = 0; i < len; ++i) {
				int cur = que[head];
				System.out.print(cur + " ");
				if (cur == end) {
					head = tail;
					break;
				}
				head++;
				for (int j = 1; j <= n; j++) {
					if (!book[j] && e[cur][j]) {
						que[tail] = j;
						book[j] = true;
						tail++;
					}
				}
			}
			System.out.println();
			step++;
		}
		System.out.println(step - 1);
	}
}

/*

5 7 1 5
1 2
1 3
2 3
2 4
3 4
3 5
4 5

4 4 1 3
1 2
2 3
3 4
2 4

*/