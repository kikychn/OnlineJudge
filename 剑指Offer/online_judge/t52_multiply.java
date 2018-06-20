package online_judge;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 *
 */
public class t52_multiply {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int[] b = multiply(a);
		for (int i = 0; i < b.length; ++i) {
			System.out.print(b[i] + " ");
		}
	}

	public static int[] multiply(int[] A) {
		if (A == null || A.length == 0)
			return A;

		int[] B = new int[A.length];
		int[] C = new int[A.length];
		int[] D = new int[A.length];
		C[0] = 1;
		for (int i = 1; i < C.length; ++i) {
			C[i] = C[i - 1] * A[i - 1];
		}
		D[D.length - 1] = 1;
		for (int i = D.length - 2; i >= 0; --i) {
			D[i] = D[i + 1] * A[i + 1];
		}
		for (int i = 0; i < B.length; ++i) {
			System.out.println(C[i] + " " + D[i]);
			B[i] = C[i] * D[i];
		}

		return B;
	}
}
