package AcWing.Day321;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/30 - 15:53
 *
 * //DP 过程中的每一步一定是对前面过程的复用
 */
public class max895 {

    static int N = 1010;
    static int n;
    static int[] a = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        String[] s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i - 1]);
        }

        //DP 过程中的每一步是对前面体系的复用，这也是记忆化搜索
        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[i]);
        }
        out.println(res);
        out.flush();

    }
}
