package online_judge;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class t30_GetLeastNumbers_Solution {

    public static void main(String[] args) {
        int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
        int k = 4;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr = GetLeastNumbers_Solution(input, k);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length < k || k <= 0)
            return result;

        // method1
//        Arrays.sort(input);
//        for (int i = 0; i < k; ++i) {
//            result.add(input[i]);
//        }

        // method2,用最大堆保存k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数放入
        Comparator<Integer> cmp = new Comparator<Integer>() { // 优先队列中的比较函数，构建最大堆
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, cmp);

        for (int i = 0; i < input.length; ++i) {
            if (i < k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }

        return result;
    }

}
