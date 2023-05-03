package class4;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/8 - 18:37
 * 线性三角形问题，给出一个数字金字塔，贯穿整个路径的和
 * 输入格式
 * 第一行包含整数n，表示三角形的层数
 * 接下来n行，每行包含若干整数，其中第i行表示数字三角形第 i 行包含的整数
 * <p>
 * 输出格式
 * 输出一个整数，表示最大路径和
 * 数据范围
 * 1<= n <= 500
 * -10000 <= 三角形中的整数 <= 10000
 */
public class LinearDP {

    static int N = 510;
    static int n;
    static int[][] a = new int[N][N];
    static int[][] f = new int[N][N];

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        //接收数据
        for (int i = 1; i <= n; i++) {
            String[] s = bf.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }

        //设置初始状态,因为线性推导
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i + 1; j++) {
                f[i][j] = Integer.MIN_VALUE;
            }
        }

        //线性DP最重要的一步，最后结果值的推导
        f[1][1] = a[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = Math.max(f[i - 1][j - 1] + a[i][j], f[i - 1][j] + a[i][j]);
            }
        }

        // 遍历最后一行的结果
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[n][i]);
        }

        System.out.println(res);
    }
}
