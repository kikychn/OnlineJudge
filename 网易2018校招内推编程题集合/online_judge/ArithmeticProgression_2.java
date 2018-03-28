package online_judge;

import java.util.Scanner;

public class ArithmeticProgression_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = in.nextInt();
        }
        
        quickSort(arr, 0, arr.length-1);
        
        int diff = arr[1] - arr[0];
        int i;
        for(i=1; i<n-1; ++i) {
            if(arr[i+1] - arr[i] != diff) break;
        }
        if(i==n-1)
            System.out.print("Possible");
        else
            System.out.print("Impossible");

    }

    static void quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end)
            return;

        int mark = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (i<=end && arr[i] <= mark)
                i++;
            while (j>=start &&  arr[j] > mark)
                j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[start] = arr[j];
        arr[j] = mark;

        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    }
}

/*
3
3 1 2
 */