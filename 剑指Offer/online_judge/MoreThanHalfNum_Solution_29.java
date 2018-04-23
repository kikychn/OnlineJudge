package online_judge;
/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution_29 {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 2, 4, 2, 5, 2, 3 };
//        int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };

        int result = MoreThanHalfNum_Solution(array);
        System.out.print(result);
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0)
            return 0;
        if (array.length == 1)
            return array[0];

        quickSort(array, 0, array.length - 1);
        int count = 1, max = 1, first = array[0], findNum = 0;
        for (int i = 1; i < array.length; ++i) {
            if (array[i] == first) {
                ++count;
                if (count > max && count > array.length / 2) {
                    max = count;
                    findNum = array[i];
                }
            } else {
                first = array[i];
                count = 1;
            }
        }

        return findNum;
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int v = arr[left];

            int i = left + 1, j = right;
            while (true) {
                while (i < j && arr[j] > v)
                    --j;
                while (i < j && arr[i] < v)
                    ++i;

                if (i >= j)
                    break;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                ++i;
                --j;
            }

            if (arr[left] > arr[i]) {
                arr[left] = arr[i];
                arr[i] = v;
            }
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

}
