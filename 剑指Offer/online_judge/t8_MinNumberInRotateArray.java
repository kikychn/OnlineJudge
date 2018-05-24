package online_judge;

import java.util.ArrayList;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class t8_MinNumberInRotateArray {

    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        /*二分查找最小值*/
        int start = 0, end = array.length - 1;
        int mid = start;
        // 如果下标为start,end,mid指向的三个数字相等，则只能顺序查找
        if (array[start] == array[end] && array[start] == array[mid]) {
            return minInOrder(array, start, end);
        }

        while (array[start] >= array[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            if (array[mid] >= array[start]) {
                start = mid;
            } else if (array[mid] <= array[end]) {
                end = mid;
            }
        }

        return array[mid];
    }

    public static int minInOrder(int[] array, int start, int end) {
        int min = array[start];
        for (int i = start + 1; i <= end; ++i) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    public static void main(String[] args) {

        int[] array1 = { 3, 4, 5, 1, 2 };
        int[] array2 = { 1, 0, 1, 1, 1 };
        int[] array3 = { 1, 1, 1, 0, 1 };
        int min = minNumberInRotateArray(array2);
        System.out.println(min);
    }

}
