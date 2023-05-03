package Blue.contest12;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/5 - 15:08
 * 由实际含义可以，f[i][j]=f[i][-j] 因
 * 为可以通过镜像的操作而得到，故而f[i][j-w]=f[i][w-j]=f[i][abs(j-w)]。就避免了数组下标为负数的情况
 *
 * 小心涉及到数据范围相加的题，这个时候尽量开double倍
 */
public class weight3417 {

    static int N = 110;
    static int n;
    static int[] w = new int[N];
    static int sum;
    static boolean[][] f = new boolean[N][200010];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(s[i - 1]);
            sum += w[i];
        }

        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (f[i - 1][j] || f[i - 1][j + w[i]] || f[i - 1][Math.abs(j - w[i])]) {
                    f[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= sum; i++) {
            if (f[n][i]) {
                ans++;
            }
        }
        out.println(ans);
        out.flush();

    }
}
