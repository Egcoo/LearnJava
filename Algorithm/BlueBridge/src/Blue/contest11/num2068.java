package Blue.contest11;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/2 - 19:13
 *
 * 观察时间复杂度 ： 数据量是十万，必定只能枚举一个数组
 * 总结： 三个比较奇怪的的东西
 * 1. (a[i]%K) * 10^j % k == (a[i]) * 10^j % k
 * 2. 负数求余的公式 (k - t) % k)
 * 3. 涉及到的判重
 */
public class num2068 {

    static int N = 100010;
    static int n, k;
    static int[] a = new int[N];
    static int[][] S = new int[11][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        // 数组的预处理
        for (int i = 0; i < n; i++) {
            long t = a[i] % k;
            for (int j = 0; j < 11; j++) {
                S[j][(int) t]++;
                t = t * 10 % k;
            }

        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            long t = a[i] % k;
            int len = Integer.toString(a[i]).length();
            res += S[len][(int) ((k - t) % k)];

            long r = t;
            while (len-- > 0) {
                r = r * 10 % k;
            }
            if (r == (k - t) % k) {
                res--;
            }
        }


        out.println(res);
        out.flush();
    }

}
