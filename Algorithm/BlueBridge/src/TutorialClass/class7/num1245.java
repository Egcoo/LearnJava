package TutorialClass.class7;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/15 - 15:47
 */
public class num1245 {

    static int n;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= n; i++) {
            int x = i;
            while (x > 0) {
                int t = x % 10;
                x /= 10;
                if (t == 2 || t == 0 || t == 1 || t == 9) {
                    res += i;
                    break;
                }
            }
        }
        out.println(res);
        out.flush();

    }
}
