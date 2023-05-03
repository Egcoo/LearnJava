package Blue.contest11;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/2 - 16:29
 *
 * 非常简单的一道模拟题，考察ascii码
 * 49 对应 ‘1’ 65对应 ‘A’ 97对应 ‘a’
 */
public class code2066 {
    static int N = 110;
    static String n;
    static char[] a = new char[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        a = bf.readLine().toCharArray();


        for (int i = 0; i < a.length; i++) {
            if (a[i] - 57 <= 0) {
                int l = Integer.parseInt((a[i] - '0') + "");
                for (int j = 0; j < l - 1; j++) {
                    out.print(a[i - 1]);
                }
            } else {
                out.print(a[i]);
            }

        }
        out.flush();
    }
}
