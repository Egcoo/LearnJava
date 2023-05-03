package Blue.Day1;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/1 - 14:45
 */
public class dfs1 {

    static int N = 10;
    static int n;
    static int[] a = new int[N]; // 存一个数组
    static boolean[] st = new boolean[N]; // 表示状态，true就是使用过，false就是未使用
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        dfs1(1);
        out.flush();

    }

    public static void dfs1(int u) {
        if (u > n) {
            for (int i = 1; i <= n; i++) {
                out.print(a[i] + " ");
            }
            out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!st[i]){
                st[i] = true;
                a[u] = i;
                // 到这里以后再回去循环，某个数字用过没有
                dfs1(u + 1);

                // 恢复现场
                a[u] = 0;
                st[i] = false;
            }
        }

    }
}
