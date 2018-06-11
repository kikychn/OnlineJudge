package online_judge;

public class t42_LeftRotateString {
	public static void main(String[] args) {
		String str = "abcXYZdef";
		int n = 3;
		System.out.print(LeftRotateString2(str, n));

	}

	public static String LeftRotateString(String str, int n) {
		if (str == null || str.length() == 0)
			return "";

		n = n % str.length();
		StringBuffer sb = new StringBuffer(str.substring(0, n));
		StringBuffer sb1 = new StringBuffer(str.substring(n, str.length()));
		sb1.append(sb);

		return sb1.toString();
	}

	public static String LeftRotateString2(String str, int n) {
		if (str == null || str.length() == 0)
			return "";

		n = n % str.length();
		str = str + str.substring(0, n);

		return str.substring(n, str.length());
	}
}
