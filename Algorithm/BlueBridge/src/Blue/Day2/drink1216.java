package Blue.Day2;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/2 - 15:46
 */
public class drink1216 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        int cnt = 0;
        while (n >= 3) {
            cnt += n;
            n = (n / 3) + (n % 3);
        }
        out.println(cnt);
        out.flush();

    }
}
