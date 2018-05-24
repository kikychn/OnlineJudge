package online_judge;
/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class t9_JumpFloor {

    // 斐波那契数列问题
    public static int jumpFloor(int target) {
        
        int[] result = {0, 1, 2};
        if(target<3)
            return result[target];
        
        /* 递归 */
//        return jumpFloor(target-1) + jumpFloor(target - 2);
        
        /* 循环 */
        int jumpN = 0;
        int jumpMinusOne = 2, jumpMinusTwo = 1;
        for(int i = 3; i <= target; ++i) {
            jumpN = jumpMinusOne + jumpMinusTwo;
            
            jumpMinusTwo = jumpMinusOne;
            jumpMinusOne = jumpN;
        }
        return jumpN;
    }
    
    public static void main(String[] args) {
        int n = 5;
        int result = jumpFloor(n);
        System.out.print(result);
    }

}
