package TutorialClass.class5;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/12 - 16:28
 * 1212. 地宫取宝
 *
 * 表示在f[i,k,k,c] 这个集合里面，我最后一步取了所有第 [i,j]上的数字，而且最后取的一定是c
 */
public class treasure {
    static int N = 55;
    static int n, m;
    static int k;
    static int res;
    static int[][] a = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        // 目的是输入数据
        for (int i = 1; i <= n; i++) {
            String[] s1 = bf.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(s1[j - 1]);
            }
        }

        res = rec(1, 1, 0, -1);

        out.println(res % 1000000007);
        out.flush();
    }
    //curR：当前所在行
    //curC：当前所在列
    //curNum：当前宝贝数量
    //curMax：当前宝贝最大价值

    public static int rec(int curR, int curC, int curNum, int curMax) {
        // 保证不能越界
        if (curR > n || curC > m || curNum > k) {
            return 0;
        }
        if (curR == n && curC == m) {
            if (curNum == k || (a[curR][curC] > curMax && curNum + 1 == k)) {
                return 1;
            } else {
                return 0;
            }
        }
        // 遇到一个比所有宝贝价值都大的物品
        // 分别代表拿或者不拿
        if (a[curR][curC] > curMax) {
            return rec(curR, curC + 1, curNum + 1, a[curR][curC]) +
                    rec(curR, curC + 1, curNum, curMax) +
                    rec(curR + 1, curC, curNum + 1, a[curR][curC]) +
                    rec(curR + 1, curC, curNum, curMax);
        } else {
            return rec(curR, curC + 1, curNum, curMax) + rec(curR + 1, curC, curNum, curMax);
        }
    }
}
