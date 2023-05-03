package TutorialClass.class4;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/12 - 16:11
 */
public class prefix {

    static int N = 100010;
    static int n, m;
    static int[] f = new int[N];
    static int[] s = new int[N];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        String[] s1 = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.parseInt(s1[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            f[i] += f[i - 1];
        }

        for (int i = 0; i < m; i++) {
            String[] s2 = bf.readLine().split(" ");
            int l = Integer.parseInt(s2[0]);
            int r = Integer.parseInt(s2[1]);

            int res = f[r] - f[l - 1];
            System.out.println(res);
        }
    }
}
