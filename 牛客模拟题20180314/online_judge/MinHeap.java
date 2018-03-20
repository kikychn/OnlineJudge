package online_judge;

import java.util.Arrays;

public class MinHeap {
    
    int[] h = new int[6];
    int size = 5;
    
    MinHeap(){
        h = new int[] {0, 1, 2, 3, 4, 5};
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.buildHeap();
        heap.showHeap();
        heap.sort();
        
    }
    
    void siftdown(int x, int len) {
//        boolean flag = true;
//        while(flag) {
//            int t = x;
//            if(2*x <= len) {
//                if(h[2*x] > h[x])
//                    t = 2 * x;
//                if(2*x + 1 <= len && h[2*x+1] > h[t]) {
//                    t = 2*x + 1;
//                }
//            }
//            
//            if(t == x)
//                flag = false;
//            
//            swap(t, x);
//            x = t;
//            
//        }
        
        h[0] = h[x];
        for(int i = 2*x; i <= len; h[x] = h[i],x = i, i = 2*i) {
            if(i+1 <= len && h[i] < h[i + 1])
                i++;
            if(h[0] > h[i])
                break;
        }
        h[x] = h[0];
    }
    
    void swap(int x, int y) {
        int t;
        t = h[x];
        h[x] = h[y];
        h[y] = t;
    }
    
    void buildHeap() {
        for(int i=size/2; i>=1; --i) {
            siftdown(i, size);
        }
    }
    
    void showHeap() {
        for(int i=0,ind=1; ind<size; ++i) {
            for(int j = 0; j < (1<<i) && ind <= size; ++ind, ++j) {
                System.out.print(h[ind]+ " ");
            }
            System.out.println();
        }
    }
    
    void sort() {
        int len = size;
        while(len > 1) {
            swap(1, len);
            --len;
            siftdown(1, len);
        }
        
        System.out.println(Arrays.toString(h));
    }
    
}
