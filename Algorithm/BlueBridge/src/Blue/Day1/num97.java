package Blue.Day1;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/1 - 18:56
 */
public class num97 {

    static int A, B;
    static int S;
    static int n;
    static int mod = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);
        if (A == 0) {
            out.println(0);
            out.flush();
            return;
        }
        if (B == 0) {
            out.println(1);
            out.flush();
            return;
        }

        n = (int) Math.pow(A, B);
        dfs5(n);
        out.println(S);
        out.flush();


    }

    public static void dfs5(int b) {
        if (b == 0) {
            return;
        }
        if (n % b == 0) {
            S += b % mod;
        }
        dfs5(b/2);

    }
}
