package TutorialClass.class1;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2023/2/25 - 20:04
 * <p>
 * 依次枚举每个位置放那个数字
 */
public class dfs1 {

    static int N = 10;
    static int n;
    static int[] state = new int[N];
    static boolean[] used = new boolean[N]; //ture 表示用过，false表示没用过

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(1);
    }

    public static void dfs(int u) {
        //先处理边界条件
        if (u > n) {
            for (int i = 1; i <= n; i++) {
                System.out.print(state[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            // 判断这个数是否被用过
            if (!used[i]) {
                state[u] = i;
                used[i] = true;
                dfs(u + 1);

                // 恢复现场
                state[u] = 0;
                used[i] = false;
            }
        }
    }
}
