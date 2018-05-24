package online_judge;

import java.util.Arrays;

public class t29_MoreThanHalfNum_Solution_copy {

    public static void main(String[] args) {
         int[] array = { 1, 2, 3, 2, 4, 2, 5, 2, 3 };
//        int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };

        int result = MoreThanHalfNum_Solution(array);
        System.out.print(result);

    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0)
            return 0;

        Arrays.sort(array);
        int len = array.length;
        int midNum = array[len / 2];
        int count = 0;
        for (int num : array) {
            if (midNum == num)
                ++count;
        }

        if (count <= len / 2)
            midNum = 0;

        return midNum;
    }

}
