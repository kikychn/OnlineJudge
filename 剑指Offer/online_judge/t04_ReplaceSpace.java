package online_judge;

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class t04_ReplaceSpace {

	public static String replaceSpace(StringBuffer str) {
		String newstr = null;
		if (str == null)
			return newstr;

		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == ' ') {
				str.replace(i, i + 1, "%20");
			}
		}
		newstr = str.toString();
		return newstr;
	}

	public static void main(String[] args) {
		StringBuffer str1 = new StringBuffer(" We are  happy. ");
		StringBuffer str2 = new StringBuffer("Hello");
		StringBuffer str3 = new StringBuffer(" ");
		StringBuffer str4 = new StringBuffer("    ");
		StringBuffer str5 = new StringBuffer("");
		StringBuffer str6 = null;

		System.out.println("-" + str1 + "-\n" + replaceSpace(str1));
		System.out.println("-" + str2 + "-\n" + replaceSpace(str2));
		System.out.println("-" + str3 + "-\n" + replaceSpace(str3));
		System.out.println("-" + str4 + "-\n" + replaceSpace(str4));
		System.out.println("-" + str5 + "-\n" + replaceSpace(str5));
		System.out.println("-" + str6 + "-\n" + replaceSpace(str6));
	}

}
