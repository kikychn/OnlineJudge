package online_judge;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinTree {
    static int N = (int)1e5 + 10;
    static int[] father = new int[N];
    static int[][] edge = new int[N*10][3];
    static int[] h = new int[N*10];
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i=1; i<=m; ++i) {
            for(int j = 0; j<3; ++j) edge[i][j] = in.nextInt();
        }
        
        for(int i = 0; i<n; ++i) father[i] = i;
        
        initHeap(m);
        
        int sum = 0;
        for(int i=1; i<=m; ++i) {
//            System.out.println(Arrays.toString(edge[h[i]]));
            if(join(edge[h[i]][0], edge[h[i]][1])) {
//                System.out.println(Arrays.toString(edge[h[i]]));
                sum += edge[h[i]][2];
            }
        }
        
        System.out.println(sum);
    }   
    
    static void initHeap(int m) {
        for(int i = 1; i <= m; ++i) h[i] = i;
        sortHeap(m);
    }
    
    static void siftdown(int x, int len) {
        h[0] = h[x];
        for(int i=2*x; i<=len; h[x] = h[i], x = i, i = 2*x) {
            if(i + 1 <= len && isBig(i+1,i)) i++;
            if(!isBig(i,0)) break;
        }
        h[x] = h[0];
    }
    
    static boolean isBig(int x, int y) {
        return edge[h[x]][2] > edge[h[y]][2];
    }
    
    static void sortHeap(int len) {
        for(int i=len/2; i >= 1; --i) {
            siftdown(i,len);
        }
//        for(int i = 1; i <= len; ++i) {
//            System.out.println(Arrays.toString(edge[h[i]]));
//        }
       
        while(len>1) {
            h[0] = h[1];
            h[1] = h[len];
            h[len] = h[0];
            siftdown(1, --len);
        }
    }
    
    static int getFather(int x) {
        int y = x;
        while(x != father[x]) x = father[x];
        while(y != x) {
            int temp = father[y];
            father[y] = x;
            y = temp;
        }
        return x;
    }
    
    static boolean join(int x, int y) {
        x = getFather(x);
        y = getFather(y);
        if(x!=y) father[x] = y;
        return x != y;
    }
    
}

/*
5 29
1 2 674
2 3 249
3 4 672
4 5 933
1 2 788
3 4 147
2 4 504
3 4 38
1 3 65
3 5 6
1 5 865
1 3 590
1 4 682
2 4 227
2 4 636
1 4 312
1 3 143
2 5 158
2 3 516
3 5 102
1 5 605
1 4 99
4 5 224
2 4 198
3 5 894
1 5 845
3 4 7
2 4 14
1 4 185

5 6
1 2 2
2 1 1
1 3 1
4 5 20
5 1 33
3 4 4
*/