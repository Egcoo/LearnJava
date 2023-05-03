package AcWing.Day321;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/30 - 16:21
 *
 * 一共可以分成四类，但f[i-1][j] 表示所有在第一个串中前i-1个字母出现，而且在第二个序列前j个字母出现的子序列
 * 但这个要求里不一定包含 b[j ]
 * 实际我们要求的是，a[i]不出现在子序列当中，b[j]一定出现在子序列当中
 *  f[i - 1][j - 1]  含义是不选a[j] 和 b[j] 只在 前[i-1][j-1] 中选
 */
public class public897 {
    static int N = 1010;
    static int n, m;
    static char[] a = new char[N];
    static char[] b = new char[N];

    static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        a = ("0" + bf.readLine()).toCharArray();
        b = ("0" + bf.readLine()).toCharArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                //只有两个相等才可以出现第三种情况
                if (a[i] == b[i]) {
                    f[i][j] = Math.max(f[i - 1][j - 1] + 1, f[i][j]);
                }
            }
        }

        System.out.println(f[n][m]);
    }
}
