package TutorialClass.class15;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/28 - 19:12
 * <p>
 * 1.对于数列来讲，每一项与第一项的差值一定是d的倍数
 * 2.求一个数列的最短宽度就是找出最大公约数
 */
public class series1246 {
    static int N = 100010;
    static int n;
    static long[] a = new long[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(s[i]);
        }

        Arrays.sort(a, 0, n);
        int d = 0;
        for (int i = 1; i < n; i++) {
            d = gcd(d, (int) (a[i] - a[i - 1]));
        }
        if (d == 0) {
            out.println(n);
        } else {
            out.println((a[n - 1] - a[0]) / d + 1);
        }
        out.flush();

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
