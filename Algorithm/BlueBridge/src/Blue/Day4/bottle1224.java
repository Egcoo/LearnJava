package Blue.Day4;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/4 - 20:59
 */
public class bottle1224 {

    static int N = 10010;
    static int n;
    static int[] b = new int[N];
    static boolean[] st = new boolean[N];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        String[] s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            b[i] = Integer.parseInt(s[i - 1]);
        }

        // 找出一共有多少个环
        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                for (int j = i; !st[j]; j = b[i]) {
                    st[j] = true;
                }
            }
        }

        out.println(n - cnt);
        out.flush();

    }
}
