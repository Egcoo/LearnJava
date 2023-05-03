package class4;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/10 - 16:12
 * <p>
 * 一共可以分成四类，但f[i-1][j] 表示所有在第一个串中前i-1个字母出现，而且在第二个序列前j个字母出现的子序列
 * 实际我们要求的是，a[i]不出现在子序列当中，b[j]一定出现在子序列当中
 *  可能除了直接变成 string数组以外，变成char数组也会好一些
 *
 *  区间DP：求最大值或者最小值的时候分出的子区间是可以重复求解的，但求数量的时候就不行了
 *
 */
public class publicSequence {

    static int N = 1010;
    static int n, m;
    static char A[] = new char[N], B[] = new char[N];
    static int[][] f = new int[N][N];

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        A = ("0" + bf.readLine()).toCharArray();
        B = ("0" + bf.readLine()).toCharArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (A[i] == B[j]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }

        System.out.println(f[n][m]);
    }

    public static void main(String[] args) throws IOException {
        test();
    }
}
