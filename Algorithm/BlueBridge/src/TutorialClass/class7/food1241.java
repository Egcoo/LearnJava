package TutorialClass.class7;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/18 - 14:38
 * <p>
 * 还是学习一个暴力解法
 * n 是有多少个店，m 是有多少条信息， T 是有多少个时刻
 */
public class food1241 {

    static int n, m, T;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        T = Integer.parseInt(s[2]);
        int[][] a = new int[T + 1][n + 1];
        int[] p = new int[n + 1];

        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().split(" ");
            a[Integer.parseInt(s1[0])][Integer.parseInt(s1[1])]++;
        }

        for (int i = 1; i < T + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a[i][j] > 0) {
                    //这一步极其重要，需要加上该店在之前时刻的累积的分数
                    a[i][j] = a[i - 1][j] + a[i][j] * 2;
                    if (a[i][j] > 5) {
                        p[j] = 1;
                    }
                } else {
                    if (a[i - 1][j] > 0) {
                        a[i][j] = a[i - 1][j] - 1;
                        if (a[i][j] <= 3) {
                            p[j] = 0;
                        }
                    }
                }
            }
        }


        for (int i = 0; i < p.length; i++) {
            res += p[i];
        }

        System.out.println(res);

    }
}
