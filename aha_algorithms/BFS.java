import java.util.Arrays;
import java.util.Scanner;

public class BFS {
	static class note{
		int x, s;
	}
	public static void main(String args[]) {
		int N=51+10;
		boolean e [][] = new boolean[N][N];
		int n,m,start,end;
		
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		start = cin.nextInt();
		end = cin.nextInt();
		
		
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=n;++j) {
				if(i==j) e[i][j] = true;
				else e[i][j] = false;
			}
		}
		
		for(int i=0;i<m;++i) {
			int a = cin.nextInt();
			int b = cin.nextInt();
			e[a][b] = true;
			e[b][a] = true;
		}
		
		int head=1, tail=1;
		note que [] = new note[N];
		boolean book [] = new boolean[N];
		Arrays.fill(book, false);
		
		que[tail] = new note();
		que[tail].x = 1;
		que[tail].s = 0;
		book[tail] = true;
		tail++;
		
		while(head<tail) {
			int cur = que[head].x;
			int ts = que[head].s;
			head++;
			for(int i=1;i<=n;i++) {
				if(!book[i] && e[cur][i]) {
					que[tail] = new note();
					que[tail].x = i;
					que[tail].s = ts + 1;
					tail++;
				}
				
				if(que[tail-1].x==end) {
					head = tail;
					break;
				}
			}
		}
		System.out.println(que[tail-1].s);
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
