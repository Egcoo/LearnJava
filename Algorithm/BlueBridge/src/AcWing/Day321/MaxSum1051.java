package AcWing.Day321;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/21 - 15:08
 * if possible , don't do that shit
 * <p>
 * for (int i = 1; i <= n; i++) {
 * a[i] = Math.max(a[i] + a[i - 1], a[i - 1]);
 * }
 *
 *  无利不早起
 *  最大连续子段和问题
 */
public class MaxSum1051 {

    static int N = 50010;
    static int T;
    static int n;
    static int[] a = new int[N];
    //两个数组起到的作用其实是定位
    //f数组 从数组第一个元素开始遍历，当前的和会让整个数变大，如果让当前的数变小，则保留最大的那个数字
    //g数组，从数组最后一个元素开始遍历，当前的和会让整个数变大，如果让当前的数变小，则保留最大的那个数字
    //最后的和 f[i] + g[i+1] 遍历取最大值
    static int[] f = new int[N];
    static int[] g = new int[N];
    static long res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(bf.readLine());
            String[] s = bf.readLine().split(" ");
            Arrays.fill(f, Integer.MIN_VALUE);
            Arrays.fill(g, Integer.MIN_VALUE);

            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(s[i - 1]);
            }
            int m = 0;
            for (int i = 1; i <= n; i++) {
                m = Math.max(m, 0) + a[i];
                f[i] = Math.max(f[i - 1], m);
            }
            m = 0;
            for (int i = n; i >= 1; i--) {
                m = Math.max(m, 0) + a[i];
                g[i] = Math.max(g[i + 1], m);
            }

            for (int i = 0; i <= n ; i++) {
                System.out.print(f[i] + " ");
            }
            System.out.println();
            for (int i = 0; i <= n ; i++) {
                System.out.print(g[i] + " ");
            }
            //res 重置
            res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, f[i] + g[i+1]);
            }
            out.println(res);
            out.flush();
        }
    }
}
