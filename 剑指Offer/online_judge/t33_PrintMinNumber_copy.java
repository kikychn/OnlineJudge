package online_judge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class t33_PrintMinNumber_copy {

	public static void main(String[] args) {
//		int[] num = { 3, 32, 321, };
//		int[] num = { 3, 5, 1, 4, 2, 45};
		int[] num = {3334,3,3333332};
		String str = PrintMinNumber(num);
		System.out.print(str);
	}
	
	public static String PrintMinNumber(int[] numbers) {
		String result = "";
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<numbers.length; ++i) {
			list.add(numbers[i]);
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer str1, Integer str2) {
				String s1 = str1+""+str2;
				String s2 = str2+""+str1;
				return s1.compareTo(s2);
			}
		});
		
		for(int i:list) {
			result += i;
		}
		return result;
	}

}
