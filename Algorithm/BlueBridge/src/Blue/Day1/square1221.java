package Blue.Day1;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/2 - 12:43
 */
public class square1221 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        for (int a = 0; a * a <= n; a++) {
            for (int b = a; b * b + a * a <= n; b++) {
                for (int c = b; b * b + a * a + c * c <= n; c++) {
                    int t = n - (a * a + b * b + c * c);
                    int d = (int) Math.sqrt(t);
                    if (d*d == t) {
                        out.println(a + " " + b + " " + c + " " + d);
                        out.flush();
                        return;
                    }
                }
            }
        }


    }
}
