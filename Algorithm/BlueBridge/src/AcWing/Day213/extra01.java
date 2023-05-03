package AcWing.Day213;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2023/2/17 - 9:48
 * <p>
 * 蓝桥题库-灵能传输
 * 前缀和；往相加的这个位置上靠啊
 * 1.第i次交换的结果，就是将s[i-1] 和 s[i] 做交换
 * 2.因为 a[0] 和 a[n] 并不参与交换，所以就会出现两次
 * 3.
 */
public class extra01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] res = new int[T];
        int n = 0;
        int N = 300010;
        long[] a = new long[N];
        long[] s = new long[N];

        for (int i = 0; i < T; i++) {
            n = scan.nextInt();
            for (int j = 1; j <= n; j++) {
                a[j] = scan.nextInt();
            }


        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
