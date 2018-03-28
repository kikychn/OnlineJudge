package online_judge;

import java.util.Scanner;

public class StaggerSubString_3 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        int count = 1, max = 1;
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                ++count;
                if (count > max)
                    max = count;
            } else
                count = 1;
        }

        System.out.print(max);
    }
}
/*
Input
111101111

Output
3
 */