package topInterviewQuestions_easycollection;

public class Array_RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        
        int k = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != nums[k]) nums[++k] = nums[i];
        }
        return k+1;
    }

}
