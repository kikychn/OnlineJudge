package online_judge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UnionSet {
    static int ind = 1;
    static Map<String, Integer> m = new HashMap();
    static int N = (int) 1e5 + 10;
    static int[] father = new int[N << 1];

    public static void main(String[] args) {
        initFather();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            int op = in.nextInt();
            String name1 = in.next();
            String name2 = in.next();
            int n1 = getNo(name1);
            int n2 = getNo(name2);
            if (op == 0)
                join(n1, n2);
            else {
                String ans = find(n1, n2) ? "yes" : "no";
                System.out.println(ans);
            }
        }
    }

    static int getNo(String name) {
        if (!m.containsKey(name))
            m.put(name, ind++);
        return m.get(name);
    }

    static void initFather() {
        for (int i = 0; i < (N << 1); ++i)
            father[i] = i;
    }

    static int getFather(int x) {
        while (x != father[x])
            x = father[x];
        return x;
    }

    static boolean join(int x, int y) {
        x = getFather(x);
        y = getFather(y);
        if (x != y)
            father[x] = y;
        return x != y;
    }

    static boolean find(int x, int y) {
        x = getFather(x);
        y = getFather(y);
        // System.out.println(x + "," + y);
        return x == y;
    }
}
/*
10
0 Steven David
0 Lcch Dzx
1 Lcch Dzx
1 David Dzx
0 Lcch David
0 Frank Dzx
1 Steven Dzx
1 Frank David
0 Steven Dzx
0 Dzx Frank

10
0 1 2
1 1 3
1 1 2
0 2 3
1 3 1
1 1 4
0 4 5
1 1 5
0 4 3
1 1 5
*/