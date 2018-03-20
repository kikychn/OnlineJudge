
public class TEST {

    public static void main(String[] args) {

        System.out.println("default int array:");
        int num[] = new int[3]; // ���������飬Ĭ��Ԫ��Ϊ0
        for (int i = 0; i < 3; ++i) {
            System.out.println(num[i]);
        }

        System.out.println("default boolean array:");
        boolean a[] = new boolean[3];// ���������飬Ĭ��Ԫ��Ϊfalse
        for (int i = 0; i < 3; ++i) {
            System.out.println(a[i]);
        }

        System.out.println("string length:");
        System.out.println("123".length());
        System.out.println("".length());
        String str = null;
        // System.out.println(str.length());

        double x = 0.0;
        double y = 0.00;
        System.out.println(x == y);
    }

}
