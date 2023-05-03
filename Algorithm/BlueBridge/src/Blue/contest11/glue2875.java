package Blue.contest11;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/4/4 - 15:47
 */
public class glue2875 {

    static int N = 100010;
    static int n;
    static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i - 1]);
        }

        Arrays.sort(a, 1, n + 1);

        long res = 0;
        for (int i = 1; i <= n ; i++) {
            res += (long) a[i] * a[i - 1];
            a[i] = a[i] + a[i-1];
        }

        out.println(res);
        out.flush();

    }
}
