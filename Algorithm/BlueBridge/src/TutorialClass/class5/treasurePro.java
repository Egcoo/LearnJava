package TutorialClass.class5;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/14 - 14:24
 * <p>
 * 地宫取宝四维数组四重循环解法
 */
public class treasurePro {

    static int N = 55;
    static int n, m;
    //所取的物品个数 0-12 一共13个数， 物品价值也是13个数，
    //如果我们不要第一个物品，我们记录价值的时候应该要取负数，但因为数组不能有负数的下标
    // 我已我们把每个物品的价值都 +1，把范围扩大为1~13，用0代表不选择第一个物品时的价值
    static int k;
    static int MOD = 1000000007;
    //a数组存的是原始状态
    static int[][] a = new int[N][N];
    static int f[][][][] = new int[N][N][13][14];

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
                a[i][j]++;
            }
        }
        f[1][1][1][a[1][1]] = 1;
        f[1][1][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                for (int u = 0; u <= k; u++) {
                    for (int v = 0; v <= 13; v++) {
                        int val = f[i][j][u][v];
                        val = val + f[i - 1][j][u][v] % MOD;
                        val = val + f[i][j - 1][u][v] % MOD;
                        if (u > 0 && v == a[i][j]) {
                            //因为要取，所以u>0，即个数>0。v==w[i][j]是因为取完之后是c
                            for (int c = 0; c < v; c++) {
                                //这个判断里面的循环的c'是枚举的我所取物品中最后一个的数目，c'是一定小于w[i][j]的。
                                //循环c' < c  c'用c表示
                                val = (val + f[i - 1][j][u - 1][c]) % MOD;
                                val = (val + f[i][j - 1][u - 1][c]) % MOD;
                            }
                        }
                        f[i][j][u][v] = val;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= 13; i++) {
            ans = (ans + f[n][m][k][i]) % MOD;
        }
        //由题意，n m k固定，所以只根据价值循环一遍，把方案数加起来就可以。
        //f[n][m][k][0]表示什么物品都没拿，它的值是0，所以从1开始循环和从0开始循环是不影响结果的。
        out.println(ans);
        out.flush();
    }
}
