package online_judge;
/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 *
 */
public class NumberOf1Between1AndN_Solution_32 {

	public static void main(String[] args) {
		int n = 12;
		int result = NumberOf1Between1AndN_Solution(n);
		System.out.print(result);
	}

	public static int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
		// method1, O(nlogn)
//		for (int i = 1; i <= n; ++i) {
//			int num = i;
//			while (num != 0) {
//				if (num % 10 == 1)
//					++count;
//				num = num / 10;
//			}
//		}

		// method2, O(nlogn)
//		while (n > 0) {
//			String str = String.valueOf(n);
//			char[] chars = str.toCharArray();
//			for (int i = 0; i < chars.length; ++i) {
//				if (chars[i] == '1')
//					++count;
//			}
//			n--;
//		}

		/**
		 * 分析数字规律进行求解：（534） 个位：对于个位数字来说，每次增长1便会发生一次变动，一次循环为0-9,并且一次循环中会出现一次数字1.
		 * 对于534来说，在个位上会有53次的0-9循环（534/10=53），
		 * 因此会有53次的1出现，又由于最后一个数字为4，则会出现一个0-4的循环并且循环中会有一个数字1出现，因此总共有53+1=54次数字1
		 *
		 * 十位：对于十位数字来说，只有个位完成一次0-9的循环十位数字才会发生一次变动。而十位数字一次0-9的循环对应着百位数字的一次改变。百位数字为5，因此十位数字
		 * 总共有5次0-9循环（534/100=5），因此在0-9的循环中会有50次数字1的出现，十位数字为3，则会有额外的一次0-3循环。循环中出现数字1可以低音各位的一次0-9
		 * 循环，故共有50+10=60次数字1的出现
		 *
		 * 百位：由于没有千位数字，故百位数字不存在0-9的循环。而百位数字为5，故有0-5的循环，循环中有数字1，百位数字1对应着十位和各位的0-9循环，故有1*10*10=100次
		 * 数字1的出现。
		 *
		 * 共有： 54 + 60 + 100 = 214
		 *
		 * 总结： 个位：当各位数字为0时，有多少次0-9循环，就会出现多少次数字1. 不为0时则额外加上1 其他位数字：
		 * 1、为0时，数字1的出现次数为0-9循环的次数*当前位（十位则乘以10，百位则乘以100）
		 * 2、为1时，数字1的出现次数为0-9循环的次数*当前位（十位则乘以10，百位则乘以100）再加上该数字前一个数字加1。（如14，会有10,11,12,13,14）
		 * 3、大于1时，数字1的出现次数为0-9循环的次数*当前位（十位则乘以10，百位则乘以100）再加上当前的位数（+10/100/1000.....）
		 **/
		// method3, O(logn)
		int base = 1;
		int round = n;
		while (round > 0) {
			int weight = round % 10;
			round = round / 10;

			count += round * base;
			if (weight == 1) {
				count += (n % base) + 1;
			} else if (weight > 1) {
				count += base;
			}

			base = base * 10;
		}

		return count;
	}

}
