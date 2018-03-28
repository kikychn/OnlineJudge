package online_judge;
/**
 * 尚未解决
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class SaveMoney {

    public static void main(String[] args) {
        
        int[] year = {1,2,3,5};
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        double[] r = new double[4];
        for(int i=0; i<4; ++i) {
            r[i] = in.nextDouble();
        }
        
        int maxN = 20;
        double[] money = new double[maxN + 1];
        
        money[1] = 1.0 + r[0];
        for(int i=1; i<=n; ++i) {
            for(int j=0; j<4; j++) {
                if(i>=year[j]) {
                    double newR = 1.0+r[j];
                    double newMoney = Math.pow(newR, year[j]);
                    money[i] = Math.max(money[i], money[i-year[j]]*newMoney);
                }
            }
        }
        
        DecimalFormat df = new DecimalFormat( "0.00000");
        System.out.println(df.format(money[n]));
    }

}
/*
8 0.0430 0.0449 0.0458 0.0473
1 0.0430 0.0449 0.0458 0.0473
2 0.0430 0.0449 0.0458 0.0473
通过率35%
*/