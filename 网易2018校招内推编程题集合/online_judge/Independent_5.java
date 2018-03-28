package online_judge;

import java.util.Scanner;

public class Independent_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x, f, d, p;
        x = in.nextInt();
        f = in.nextInt();
        d = in.nextInt();
        p = in.nextInt();

        int day = 0;
        if (d / x <= f)
            day = d / x;
        else
            day = f + (d - f * x) / (x + p);

        System.out.print(day);

    }
}
/*
3 5 100 10
11

2 17 20 1
10

1 1996245611 1999990159 123
1996275808
*/