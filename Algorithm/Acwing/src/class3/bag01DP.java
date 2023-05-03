package class3;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/6 - 19:01
 * 谨记：DP问题是没有模板的，更多是一种思想，按照现场分析的情况会更多一些
 *
 * 优化方向：f[i] 只用到了 f[i-1]这一层，我们计算f[i][j]的时候，只用到了f[i - 1][j]和f[i - 1][j - v[i]]
 * 都是<= j 的，而不是在j的两侧
 *
 * 代码的优化方向：简化维度，保证精简以后的代码实际的作用和原先的是一样的。
 */
public class bag01DP {

    static int N = 1010;
    static int n, m;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[][] f = new int[N][N];

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        // 读入每一个物品的状态
        for (int i = 1; i <= n; i++) {
            String[] s1 = bf.readLine().split(" ");
            v[i] = Integer.parseInt(s1[0]);
            w[i] = Integer.parseInt(s1[1]);
        }

        // 默认f[0][0~m] 考虑0件物品，总体积不超过m 那么总价值一定是0，因为java默认就是0，所以我们就不需要考虑
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        System.out.println(f[n][m]);

    }
}
