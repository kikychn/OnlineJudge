package online_judge;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
import java.util.ArrayList;
import java.util.Collections;

public class Permutation_28 {

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> ans = Permutation(str);

        for (int i = 0; i < ans.size(); ++i) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() <= 0)
            return res;

        char[] chars = str.toCharArray();
        Permutation(res, chars, 0);
        Collections.sort(res);

        return res;
    }

    public static void Permutation(ArrayList<String> res, char[] chars, int begin) {
        if (begin == chars.length - 1)
            res.add(new String(chars));

        for (int i = begin; i < chars.length; ++i) {
            if (i == begin || chars[i] != chars[begin]) {
                swap(chars, i, begin);
                Permutation(res, chars, begin + 1);
                swap(chars, i, begin);
            }
        }
    }

    public static void swap(char[] ch, int x, int y) {
        char temp = ch[x];
        ch[x] = ch[y];
        ch[y] = temp;
    }
}
