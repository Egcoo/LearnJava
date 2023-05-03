package TutorialClass.class5;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/12 - 15:00
 * 1015 摘花生
 * 状态表示
 * 1）集合：所有从起点，走到[i,j] 的路径
 * 2）属性：Max
 * 状态计算
 * a[i,j]是原数组，f[i,j]是结果数组
 * f[i,j] 只有可能来自左边和上边，也即f[i-1,j] 和 f[i,j-1],所以我们基本思路就是求
 * f[i,j] = Max(f[i-1,j]+ a[i,j] , f[i,j-1] + a[i,j] )
 * 最后输出最大值，f[R][C]
 */
public class peanutCount {

    static int N = 110;
    static int T;
    static int R, C;
    static int[][] f = new int[N][N];
    static int[][] a = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int len = 0; len < T; len++) {
            String[] s = bf.readLine().split(" ");
            R = Integer.parseInt(s[0]);
            C = Integer.parseInt(s[1]);
            for (int j = 1; j <= R; j++) {
                String[] s1 = bf.readLine().split(" ");
                for (int k = 1; k <= C; k++) {
                    a[j][k] = Integer.parseInt(s1[k - 1]);
                }
            }

            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    f[i][j] = Math.max(f[i][j - 1] + a[i][j], f[i - 1][j] + a[i][j]);
                }
            }

            System.out.println(f[R][C]);
        }
    }
}
