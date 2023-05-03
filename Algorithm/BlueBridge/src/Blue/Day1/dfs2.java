package Blue.Day1;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/1 - 15:40
 *
 * 搜索模式无外乎就这几种，要不要，选不选
 */
public class dfs2 {

    static int N = 10;
    static int n, m;
    static int[] a = new int[N]; // 存一个数组
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);


        dfs2(1);
        out.flush();

    }

    public static void dfs2(int u) {
        if (u > m) {
            for (int i = 1; i <= m; i++) {
                out.print(a[i] + " ");
            }
            out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (i > a[u - 1]) {
                a[u] = i;
                // 到这里以后再回去循环，某个数字用过没有
                dfs2(u + 1);

                // 恢复现场
                a[u] = 0;
            }
        }

    }
}
