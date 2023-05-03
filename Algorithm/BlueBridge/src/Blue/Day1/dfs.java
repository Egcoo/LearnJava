package Blue.Day1;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/1 - 13:50
 *
 * 递归中最重要的是顺序，找到一个顺序可以不重不漏地将所有方案找出来
 */
public class dfs {

    static int N = 16;
    static int n;
    static int[] st = new int[N]; // 状态也就是有没有选择，0没确定，1 表示选，2表示不选择
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        dfs(1);

        out.flush();
    }

    public static void dfs(int u) {
        //边界条件
        if (u > n) {
            for (int i = 1; i <= n; i++) {
                if (st[i] == 1) {
                    out.print(i + " ");
                }
            }
            out.println();
            return;
        }
        //初始化

        st[u] = 2;
        dfs(u + 1);
        st[u] = 0; // 恢复现场

        st[u] = 1;
        dfs(u + 1);
        st[u] = 0;
    }
}
