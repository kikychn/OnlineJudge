package online_judge;
/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class t11_Power {
    static boolean g_InvalidInput = false;

    public static void main(String[] args) {
        System.out.println(power(2, 5));
        System.out.println(power(2, 0));
        System.out.println(power(0, 5));
        System.out.println(power(0, -5));
        System.out.println(power(3, 3));
        
    }

    public static double power(double base, int exponent) {
        g_InvalidInput = false;
        if (base == 0.0 && exponent < 0) {
            g_InvalidInput = true;
            return 0.0;
        }

        int abs_exp = Math.abs(exponent);
        double result = powerWithUnsignedExponent(base, abs_exp);

        if (exponent < 0)
            result = 1 / result;

        return result;

    }

    static double powerWithUnsignedExponent(double base, int exponent) {
        double result = 1.0;
        if (exponent == 0 || base == 1.0)
            return result;
        
        /* method1 */
//        for (int i = 0; i < exponent; ++i) {
//            result *= base;
//        }

        /* method2 */
        result = powerWithUnsignedExponent(base, (exponent >> 1)); // 用右移运算符代替除以2
        result *= result;
        if ((exponent & 1) == 1) // 用位与运算符代替了求余运算符(%)来判断一个数是奇数还是偶数
            result *= base;

        return result;
    }
    
}
