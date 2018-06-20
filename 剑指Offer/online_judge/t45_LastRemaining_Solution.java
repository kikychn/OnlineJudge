package online_judge;
/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 */
public class t45_LastRemaining_Solution {
	public static void main(String[] args) {
		int n = 5, m = 3;
		System.out.print(LastRemaining_Solution(n, m));
	}

	public static int LastRemaining_Solution(int n, int m) {
		if (n < 1 || m < 1)
			return -1;

		int last = 0;
		for (int i = 2; i <= n; ++i) {
			last = (last + m) % i;
		}

		return last;
	}
}
