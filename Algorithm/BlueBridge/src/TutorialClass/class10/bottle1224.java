package TutorialClass.class10;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/20 - 21:21
 * <p>
 * 分为两种情况
 * 1.交换同一个换内的点 ---> 裂成两个环
 * 2.交换不同环中的点 ---> 合并两个环称为一个环
 */
public class bottle1224 {

    static int N = 10010;
    static int n;
    static int[] b = new int[N];
    static boolean[] st = new boolean[N];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        String[] s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            b[i] = Integer.parseInt(s[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                cnt++;
                // j == i 遇到遍历过的就会直接退出来
                for (int j = i; !st[j]; j = b[j]) {
                    st[j] = true;
                }
            }
        }

        out.println(n - cnt);
        out.flush();

    }
}
