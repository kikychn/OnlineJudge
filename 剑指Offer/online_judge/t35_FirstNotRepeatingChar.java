package online_judge;
/**
 * 第一个只出现一次的字符
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
import java.util.HashMap;

public class t35_FirstNotRepeatingChar {

	public static void main(String[] args) {
		String str = "abaccdeff";
		System.out.print(FirstNotRepeatingChar2(str));
	}

	public static int FirstNotRepeatingChar(String str) {
		int pos = -1;
		if (str == null || str.length() == 0)
			return pos;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			if (map.containsKey(str.charAt(i))) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			if (map.get(ch) == 1) {
				pos = i;
				break;
			}
		}

		return pos;
	}

	public static int FirstNotRepeatingChar2(String str) {
		int pos = -1;
		if (str == null || str.length() == 0)
			return pos;

		int[] a = new int[256];
		for (int i = 0; i < str.length(); ++i) {
			a[str.charAt(i)]++;
		}

		for (int i = 0; i < str.length(); ++i) {
			if (a[str.charAt(i)] == 1) {
				pos = i;
				break;
			}
		}

		return pos;
	}

}
