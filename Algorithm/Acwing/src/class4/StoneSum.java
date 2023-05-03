package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ author Egcoo
 * @ date 2023/3/11 - 15:28
 * <p>
 * 最后一步一定是 [i,k],[k+1，j] 进行合并
 * f[i,j] 是Min(f[i,k] + f[k+1，j] + s[j] - s[j-1]) k 的枚举范围从i 到 j-1
 */
public class StoneSum {

    static int N = 310;
    static int n;
    static int[] s = new int[N];
    static int[][] f = new int[N][N];

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(str[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            s[i] += s[i - 1];
        }

        // 这里是遍历长度，从2开始是因为如果是1的话，那么合并石子就没有代价，代价就是0
        for (int len = 2; len <= n; len++) {
            // 从起点开始
            for (int i = 1; i + len - 1 <= n; i++) {
                // 这里 i + len - 1保证后面最后一个数是空出来的
                int r = i + len - 1;
                // 提前预设一个最大值
                f[i][r] = Integer.MAX_VALUE;
                for (int k = i; k < r; k++) {
                    f[i][r] = Math.min(f[i][r], f[i][k] + f[k + 1][r] + s[r] - s[i - 1]);
                }
            }
        }

        System.out.println(f[1][n]);

        // 区间DP模板,第一层枚举长度
        for (int len = 0; len <= n; len++) {
            // 第二层枚举起点
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                //区间长度为1也就是0
                if (len == 1) {
                    f[i][j] = 0;
                    continue;
                }
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + s[j] - s[i - 1]);
                }

            }
        }
    }
}
