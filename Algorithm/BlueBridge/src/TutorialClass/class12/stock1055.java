package TutorialClass.class12;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/25 - 14:30
 * <p>
 * 相邻两天，后一天比前一天大，则交易一次
 */
public class stock1055 {

    static int N = 100010;
    static int n;
    static int[] price = new int[N];
    static int res = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i + 1 < n; i++) {
            int dt = price[i + 1] - price[i];
            if (dt > 0) {
                res += dt;
            }
        }
        out.println(res);
        out.flush();
    }
}
