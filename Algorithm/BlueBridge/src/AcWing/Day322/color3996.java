package AcWing.Day322;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/31 - 15:46
 *
 * 分为两种状态，i 和 j相同 还是 i 和 j 的颜色不同
 */
public class color3996 {

    static int N = 5010;
    static int n;
    static int[] a = new int[N];
    static int[] cnt = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i - 1]);
        }



    }
}
