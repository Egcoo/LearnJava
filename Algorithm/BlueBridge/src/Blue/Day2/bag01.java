package Blue.Day2;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/2 - 14:49
 *
 */
public class bag01 {

    static int N = 1010;
    static int n, m;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++) {
            String[] s1 = bf.readLine().split(" ");
            v[i] = Integer.parseInt(s1[0]);
            w[i] = Integer.parseInt(s1[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        out.println(f[n][m]);
        out.flush();

    }
}
