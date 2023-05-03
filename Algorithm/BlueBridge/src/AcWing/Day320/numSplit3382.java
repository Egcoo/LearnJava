package AcWing.Day320;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/18 - 20:26
 * 相当于是完全背包问题
 * f[i][j]=∑j=w[i]N   f[i][j−w[i]]
 * <p>
 * 这里 w[i] 相当于 2 的次幂
 * <p>
 * 最后转化为一维即可，注意顺序（亲测不转化会爆内存，2e7 大概 80M）
 */
public class numSplit3382 {

    static int N = 1000010;
    static int n;
    static int mod = (int) 1e9;
    static int[] a = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        f[0] = 1;
        for (int i = 1; i <= n; i *= 2) {
            for (int j = i; j <= n; j++) {
                f[j] = (f[j] + f[j - i]) % mod;
            }
        }

        out.println(f[n]);
        out.flush();
    }
}
