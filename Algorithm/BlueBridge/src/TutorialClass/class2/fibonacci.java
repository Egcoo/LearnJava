package TutorialClass.class2;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/1 - 20:25
 *  递推解法
 */
public class fibonacci {

    static int N = 50;
    static int[] f = new int[N];
    static int n;
    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        f[1] = 0;
        f[2] = 1;
        for (int i = 3; i <= n ; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(f[i] + " ");
        }
    }
}
