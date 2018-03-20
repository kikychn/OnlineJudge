package online_judge;
/* 尚未解决 */
import java.util.Scanner;

public class Counting_Islands_II_1352 {
    static int M = (int)1e5 + 10;
    static int N = 1001;
    static int[][] node = new int[M][3];
    static int[][] grid = new int[N][N];
    static int ind = 1;
    static int[] father = new int[M];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        if(m <= 0) return;
            
        for(int i=1; i<=m; ++i) {
            father[i] = i;
        }
        
        for(int i=0; i < m; ++i) {
            for(int j=0; j<2; ++j) node[i][j] = in.nextInt();
            node[i][2] = 1;
            grid[node[i][0]][node[i][1]] = ind++;
        }
        
        for(int i=0; i<m; ++i) {
            join(node[i][0], node[i][1],i+1);
            int count = 0;
            for(int j = 1; j <= i+1; ++j) {
                if(j == father[j]) {
                    count++;
                }
            }
            System.out.println(count);
        }
        
        return;
    }

    static int[][] offset = {{0,-1},{-1,0},{0,1},{1,0}}; 
    static void join(int x, int y, int maxNode) {
        boolean isConnected = false;
        for(int i=0; i<4; ++i) {
            int off_x = x+offset[i][0];
            int off_y = y+offset[i][1];
            if(off_x>=0 && off_y>=0 && grid[off_x][off_y] > 0) {
                if(!isConnected) {
                    father[grid[x][y]] = min(father[grid[x][y]],father[grid[off_x][off_y]]);
                    isConnected = true;
                }else {
                    father[grid[off_x][off_y]] = father[grid[x][y]];
                }
            }
        }
      
        return;
    }
    
    static int min(int x, int y) {
        return x<=y?x:y;
    }
    
}
/*
3
0 0
1 1
1 0

6
0 1
2 1
1 0
1 2
1 3
3 3
 */
