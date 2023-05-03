package TutorialClass.class5;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/8 - 14:13
 * <p>
 * 1.蚂蚁感冒问题，更像是脑筋急转弯。
 * 2.可以理解为穿过，而不是掉头
 */
public class antCold {

    static int N = 55;
    static int n;
    static int[] x = new int[N];

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(s[i]);
        }

        // 分别表示左边向右走的蚂蚁和右边向左走的数量
        int left = 0;
        int right = 0;
        for (int i = 1; i < n; i++) {
            if (Math.abs(x[i]) < Math.abs(x[0]) && x[i] > 0) {
                left++;
            } else if (Math.abs(x[i]) > Math.abs(x[0]) && x[i] < 0) {
                right++;
            }
        }

        if (x[0] > 0 && right == 0 || x[0] < 0 && left == 0) {
            System.out.println(1);
        } else {
            System.out.println(right + left + 1);
        }

    }
}
