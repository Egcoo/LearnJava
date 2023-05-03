package TutorialClass.class7;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/16 - 16:39
 * <p>
 * 从1开始也是可以的，但从1开始需要上取整
 */
public class distance1219 {

    static int res;
    static int w, m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        w = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        n = Integer.parseInt(s[2]);
        m -= 1;
        n -= 1;

        int x1 = m / w;
        int x2 = n / w;
        int y1 = m % w;
        int y2 = n % w;
        if (x1 % 2 == 1) {
            y1 = w - 1 - y1;
        }
        if (x2 % 2 == 1) {
            y2 = w - 1 - y2;
        }

        res = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        out.println(res);
        out.flush();
    }
}
