package AcWing.Day217;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/3 - 10:23
 * <p>
 * 题目给出的是两个输入
 * 1.每个硬币只翻转一次，
 */
public class coin {

    static int N = 110;
    static char[] pre = new char[N];
    static char[] post = new char[N];
    static int count = 0;

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        pre = bf.readLine().toCharArray();
        post = bf.readLine().toCharArray();

        int n = pre.length;
        for (int i = 0; i < n - 1; i++) {
            if (pre[i] == post[i]) {
                continue;
            } else {
                pre[i] = reverse(pre[i]);
                pre[i + 1] = reverse(pre[i + 1]);
                count++;
            }
        }
        System.out.println(count);
    }

    public static char reverse(char c1) {
        if (c1 == '*') {
            return c1 = 'o';
        } else {
            return c1 = '*';
        }
    }
}
