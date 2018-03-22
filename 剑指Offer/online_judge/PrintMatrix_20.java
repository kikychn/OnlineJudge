package online_judge;

import java.util.ArrayList;

public class PrintMatrix_20 {

    public static void main(String[] args) {
//        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        // int[][] matrix = {{1},{2},{3},{4},{5}};
         int[][] matrix = {{1,2},{5,6},{9,10},{13,14}};
        // int[][] matrix = { { 1, 2, 3, 4, 5 } };
        ArrayList<Integer> list = printMatrix(matrix);

        System.out.println(list.toString());

    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        /* my method */
//        if (matrix == null)
//            return null;
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//
//        int m = matrix.length, n = matrix[0].length;
//        int startX = 0, startY = 0;
//        while (m > 0 && n > 0) {
//            int i = startX, j = startY;
//            while (j < startY + n)
//                arrayList.add(matrix[i][j++]);
//            j--;
//            i++;
//            while (i < startX + m)
//                arrayList.add(matrix[i++][j]);
//            i--;
//            j--;
//            if (j < startY || i <= startX)
//                return arrayList;
//            while (j >= startY)
//                arrayList.add(matrix[i][j--]);
//            j++;
//            i--;
//            if (i <= startX)
//                return arrayList;
//            while (i > startX)
//                arrayList.add(matrix[i--][j]);
//
//            m -= 2;
//            n -= 2;
//            startX++;
//            startY++;
//        }
//        return arrayList;

        /* a better method */
        if (matrix == null || matrix.length == 0)
            return null;

        ArrayList<Integer> result = new ArrayList<Integer>();

        int start = 0;
        int rows = matrix.length, columns = matrix[0].length;
        while (rows > start * 2 && columns > start * 2) {
            printMatrixInCircle(matrix, rows, columns, start, result);
            ++start;
        }

        return result;
    }

    public static void printMatrixInCircle(int[][] matrix, int rows, int columns, int start,
            ArrayList<Integer> result) {
        int endY = rows - start - 1;
        int endX = columns - start - 1;

        for (int i = start; i <= endX; ++i)
            result.add(matrix[start][i]);

        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i)
                result.add(matrix[i][endX]);
        }

        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; --i)
                result.add(matrix[endY][i]);
        }

        if (start < endY - 1 && start < endX) {
            for (int i = endY - 1; i > start; --i) {
                result.add(matrix[i][start]);
            }
        }

        return;
    }

}
