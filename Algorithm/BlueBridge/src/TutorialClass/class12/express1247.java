package TutorialClass.class12;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/28 - 14:39
 * 要点：可以通过加括号的方式实现任意多个括号
 * 1.如果m= 0，全部加
 * 2.如果 m>0 （分为m个- 和 1个-， 可以构造出来 1~M个负号，按照题意可以构造出来一个树）
 * 3. m>0  至少减去一个数，至少加一个数（最开始那个数）
 */
public class express1247 {

    static int N = 200010;
    static int n, m;
    static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        int k = n + m + 1;
        String[] s1 = bf.readLine().split(" ");
        for (int i = 1; i <= k; i++) {
            a[i] = Integer.parseInt(s1[i - 1]);
        }

        Arrays.sort(a, 1, k + 1);
        long res = 0;

        // 如果一个负号没有，全部加
        if (m == 0) {
            for (int i = 1; i <= k; i++) {
                res += a[i];
            }
        } else {
            //至少减去一个数，至少加一个数（最开始那个数）
            res = a[k] - a[1];
            for (int i = 2; i < k; i++) {
                res += Math.abs(a[i]);
            }
        }
        out.println(res);
        out.flush();

    }
}
