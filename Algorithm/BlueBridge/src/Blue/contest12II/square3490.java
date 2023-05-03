package Blue.contest12II;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/6 - 15:48
 */
public class square3490 {

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 1; i < n; i++) {
            int v = (int) Math.pow(i, 2);
            if (v % n < n / 2) {
                cnt++;
            }
        }
        out.println(cnt);
        out.flush();
    }

}
