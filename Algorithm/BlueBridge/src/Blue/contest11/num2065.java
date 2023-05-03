package Blue.contest11;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/2 - 16:24
 */
public class num2065 {

    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(bf.readLine());
        while (n > 0) {
            out.print(n + " ");
            n /= 2;
        }

        out.flush();
    }
}
