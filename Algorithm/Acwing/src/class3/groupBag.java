package class3;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/7 - 20:13
 */
public class groupBag {

    static int N = 110;
    static int n, m;
    static int[] s = new int[N];
    static int[][] v = new int[N][N];
    static int[][] w = new int[N][N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s0 = bf.readLine().split(" ");
        n = Integer.parseInt(s0[0]);
        m = Integer.parseInt(s0[1]);

        // 读入每一个物品的状态
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(bf.readLine());
            for (int j = 0; j < s[i]; j++) {
                String[] s1 = bf.readLine().split(" ");
                v[i][j] = Integer.parseInt(s1[0]);
                w[i][j] = Integer.parseInt(s1[1]);
            }
        }
        // 默认f[0][0~m] 考虑0件物品，总体积不超过m 那么总价值一定是0，因为java默认就是0，所以我们就不需要考虑
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= s[i]; k++) {
                    //f[i][j] 代表的就是第i个不选
                    if (j >= v[i][k]) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }

        System.out.println(f[n][m]);
    }
}
