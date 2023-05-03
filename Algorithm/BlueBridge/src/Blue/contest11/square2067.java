package Blue.contest11;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/2 - 16:45
 * 从1，1 走到[i,j] 所有合法方案的集合，求一个数目
 */
public class square2067 {

    static int N = 35;
    static int n, m;
    static int[][] f = new int[N][N];
    static int[][] a = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        f[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        out.println(f[n][m]);
        out.flush();

    }
}
