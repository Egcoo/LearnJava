package AcWing.Day321;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/30 - 20:11
 * <p>
 * 君子不立于危墙之下，不要把自己放到那个位置下，同时也要寻找风险和回报不对称的选择机会
 * Don't put yourself in that position
 * <p>
 * 风险回报比较对称的选择，就不应该把它当成一个重要的机会去看待。
 */
public class public272 {

    static int N = 3010;
    static int n;
    static long[] a = new long[N];
    static long[] b = new long[N];
    static long[][] f = new long[N][N];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(s[i - 1]);
        }
        s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            b[i] = Long.parseLong(s[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //这个是所有不包含a[i] 的公共子序列
                f[i][j] = f[i - 1][j];
                // 因为a[i]和b[j]都是数组中的最后一个元素，包含a[i] 的前提一定是和b[j] 相等
                if (a[i] == b[j]) {
                    // 以b[j] 结尾，这里就要考虑在b[j]之前那个是最大的
                    f[i][j] = 1;
                    for (int k = 1; k < j; k++) {
                        if (b[k] < b[j]) {
                            f[i][j] = Math.max(f[i][j], f[i - 1][k] + 1);
                        }
                    }
                }
            }
        }

        long res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[n][i]);
        }
        System.out.println(res);
    }
}
