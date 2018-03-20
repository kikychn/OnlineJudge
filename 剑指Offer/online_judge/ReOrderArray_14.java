package online_judge;
/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray_14 {

    public static void main(String[] args) {
        int[] nums1 = {4, 6, 7, 2, 1, 4, 9, 3};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(nums2);
        for(int i=0; i<nums2.length;++i) {
            System.out.print(nums2[i]+" ");
        }
    }

    public static void reOrderArray(int [] array) {
        if(array == null || array.length == 0) return;
        
        for(int i=0; i<array.length; ++i) {
            if((array[i] & 1) == 1) continue;
            else {
                int j = i+1;
                while(j<array.length && ((array[j] & 1) == 0)) ++j;
                if(j == array.length) break;
                int temp = array[j];
                for(int k = j; k>i; --k) {
                    array[k] = array[k-1];
                }
                array[i] = temp;
            }
        }
        return;
    }
    
}
