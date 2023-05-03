package Blue.Day3;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/3 - 12:48
 * <p>
 * 虽然策略是选取最小值和最大值，但最小值和最大值在更新的过程中，配合区间长度的更新实现了所谓连号区间的效果
 */
public class num1210 {
    static int N = 10010;
    static int n;
    static int[] p = new int[N];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(s[i - 1]);
        }

        // 每次循环更新max 和 min
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j <= n; j++) {
                max = Math.max(max, p[j]);
                min = Math.min(min, p[j]);
                if (max - min == j - i) {
                    ans++;
                }
            }

        }


        out.println(ans);
        out.flush();

    }
}
