package TutorialClass.class1;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/2/25 - 16:47
 * <p>
 * 递归实现指数型枚举
 */
public class dfs {
    static int N = 16;
    static int n;
    // 记录每一个状态，0表示还没考虑，1表示选它 ，2表示不选
    static int[] st = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs1(1);

    }

    public static void dfs1(int u) {
        if (u > n) {
            for (int i = 1; i <= n; i++) {
                if (st[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        st[u] = 2;
        dfs1(u + 1); // 表示不选
        st[u] = 0; // 恢复到未被选择的状态

        st[u] = 1;
        dfs1(u + 1); // 表示选
        st[u] = 0; // 恢复到未被选择的状态

    }
}
