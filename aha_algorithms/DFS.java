import java.util.Scanner;

public class DFS {
	static int[] arr = new int[30];
	static int[] num = new int[30];
	static int X, min = -1;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		X = cin.nextInt();
		for (int i = 0; i < N; i++) {
			num[i] = cin.nextInt();
		}
		// dfs(0, 0, N);
		dfs2(0, N, 0);
		System.out.println(min);
		cin.close();
	}

	public static void dfs(int step, int start, int n) {
		if (start == n) {
			return;
		}

		int sum = 0;
		for (int i = 0; i < step; i++) {
			// System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		if (sum >= X) {
			if (min == -1) {
				min = sum;
			} else if (sum < min) {
				min = sum;
			}
		}
		// System.out.println();

		for (int i = start; i < n; i++) {
			arr[step] = num[i];
			dfs(step + 1, i + 1, n);
		}
	}

	public static void dfs2(int step, int n, int sum) {
		if (step == n) {
			if (sum >= X) {
				if (min == -1) {
					min = sum;
				} else if (sum < min) {
					min = sum;
				}
			}
			return;
		}

		dfs2(step + 1, n, sum + num[step]);
		dfs2(step + 1, n, sum);
		return;
	}
}
