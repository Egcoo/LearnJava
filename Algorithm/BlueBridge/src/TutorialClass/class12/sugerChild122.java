package TutorialClass.class12;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/26 - 14:56
 *
 * 一个方程是多余的方程，n-1 个独立方程，n个未知数，-> 可以使用某个xi 表示其他所有x
 */
public class sugerChild122 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        int[] a = new int[n + 1];
        long[] c = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(bf.readLine());
        }

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += a[i];
        }
        int avg = (int) (sum / n);
        // 计算出每一个c[i] 的值
        c[1] = 0;
        c[n] = avg - a[n];
        for (int i = n - 1; i > 1; i--) {
            c[i] = c[i + 1] + avg - a[i];
        }

        //从 c[(n + 1) / 2] 这里获取中位数，减去每一个中位数的值
        Arrays.sort(c, 1, n + 1);
        int res = 0;
        //这里的c[(n + 1) / 2] 原因就是数组是从1开始的
        for (int i = 1; i <= n; i++) {
            res += Math.abs(c[i] - c[(n + 1) / 2]);
        }

        out.println(res);
        out.flush();

    }
}
