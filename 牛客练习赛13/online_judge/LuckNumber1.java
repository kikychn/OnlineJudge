package online_judge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LuckNumber1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strIn = in.next();
        Map<String, Integer> m = new HashMap();
        char[] charIn = strIn.toCharArray();
        int ind_4 = 0;
        int ind_7 = 0;
        m.put("4", ind_4++);
        m.put("7", ind_7++);
        boolean isFirst_4 = false;
        boolean isFirst_7 = false;
        for(int i=0; i<charIn.length; ++i) {
            
            if(charIn[i] == '4') m.put("4", ind_4++);
            if(charIn[i] == '7') m.put("7", ind_7++);
            if(m.get("4")>0 && m.get("7")==0) isFirst_4 = true;
            if(m.get("4")==0 && m.get("7")>0) isFirst_7 = true;
                
        }
        
        if(m.get("4") > m.get("7")) {
            System.out.println("4");
        }else if(m.get("4") < m.get("7")){
            System.out.println("7");
        }else {
            if(isFirst_4)
                System.out.println("4");
            else if(isFirst_7)
                System.out.println("4");
            else
                System.out.println("-1");
        }
    }

}
