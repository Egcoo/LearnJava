package Blue.contest12II;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/6 - 16:08
 *
 * 既然事已至此，不如现在就开始吧！
 */
public class total3491 {


    static long res = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(bf.readLine());
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                long s = 0;
                while (n % i == 0) {
                    s++;
                    n /= i;
                }
                if (s % 2 == 1) {
                    res *= i;
                }
            }
        }
        if (n > 1) {
            res *= n;
        }
        out.println(res);
        out.flush();
    }


}
