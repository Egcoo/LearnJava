package TutorialClass.class11;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/22 - 15:27
 * <p>
 * 算法的时间复杂度不大的话可以多开一些空间，防止出现卡边界的问题
 */
public class CBT1240 {

    static int N = 150010;
    static int n;
    static int[] a = new int[N];
    static long[] b = new long[20];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine().trim());

        String[] s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i - 1]);
        }
        for (int i = 1; i <= 150000; i++) {
            a[i] += a[i - 1];
        }
        int m = 0;
        for (int i = 1; i <= n; i *= 2) {
            m++;
        }

        b[1] = a[1];
        for (int i = 2; i <= m; i++) {
            b[i] = a[(int) Math.pow(2, i) - 1] - a[(int) Math.pow(2, i - 1) - 1];
        }

        long res = Integer.MIN_VALUE;
        long max = Integer.MIN_VALUE;
        int depth = 0;


        for (int i = 1; i <= m; i++) {
            res = Math.max(res, b[i]);
            if (res > max) {
                max = res;
                depth = i;
            }
        }
        out.println(depth);
        out.flush();
    }
}
