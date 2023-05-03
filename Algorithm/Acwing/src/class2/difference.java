package class2;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/2/22 - 19:51
 */
public class difference {

    static int N = 100010;
    static int n, m;
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void diff() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        //构造差分数组
        for (int i = 1; i <= n; i++) {
            insert(i, i, a[i]);
        }

        while (m-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            insert(l, r, c);
        }

        // 最后输出所有的结果
        for (int i = 1; i <= n; i++) {
            b[i] = b[i - 1];
            System.out.println(b[i]);
        }

    }

    public static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }

}
