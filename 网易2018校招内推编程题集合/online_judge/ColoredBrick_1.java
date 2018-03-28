package online_judge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ColoredBrick_1 {
    
    public static void main(String[] args) {
        coloredBrick();
    }
    
    public static void coloredBrick() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        
        int result = 0;
        if(s == null || s.length()<=0) {
            System.out.print(result);
            return;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<s.length(); ++i) {
            String subStr = s.substring(i, i+1);
            int count = map.containsKey(subStr)?map.get(subStr):0;
            map.put(subStr, ++count);
        }
        
        if(map.size()==1)
            result = 1;
        else if(map.size() == 2)
            result = 2;
        
        System.out.print(result);
    }
}
/*
Input:
ABAB

Output:
2
*/