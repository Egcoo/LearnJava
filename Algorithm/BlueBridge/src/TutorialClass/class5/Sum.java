package TutorialClass.class5;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/8 - 12:46
 * <p>
 * 1.尽力分析
 * 2.*打表找规律
 */
public class Sum {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        int res = 0;
        for (int i = 1; i <= 1000; i++) {
            if (!dfs(i, n, m)) {
                res = i;
            }
        }
        System.out.println(res);
    }


    public static boolean dfs(int m, int p, int q) {
        if (m == 0) {
            return true;
        }

        if (m >= p && dfs(m - p, p, q)) {
            return true;
        }
        if (m >= q && dfs(m - q, p, q)) {
            return true;
        }

        return false;
    }

}
