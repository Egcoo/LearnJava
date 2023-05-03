package Blue.Day3;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/3 - 19:50
 * <p>
 * 这里是怎么知道要就 -1的，因为在下面的推导过程，发现还是从0开始不需要考虑过多的边界条件
 */
public class distance1219 {

    static int w, m, n;
    static int ans;

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

        ans = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        out.println(ans);
        out.flush();
    }
}
