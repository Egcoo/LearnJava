package TutorialClass.class1;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2023/2/25 - 21:01
 * <p>
 * 1.从 1∼n 这 n 个整数中随机选出 m 个，输出所有可能的选择方案。
 * 2.依次枚举那个位置放那个数，在枚举的时候保证后面的数一定是大于前面的数字的
 * 3.人为添加顺序，始终保持升序选择。只需要保证每次新加的数字是大于前面的数字的
 *
 * 按照组合型枚举的意思就是一组数的所有排列只算一种排列
 *
 * 这里其实是不需要这个判重数组的 used[], 因为我们的判断标准就是后面的数字比前面的大，那么就一定不会重复
 */
public class dfs2 {

    static int N = 26;
    static int n, m;
    static int[] state = new int[N];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        dfs(1);
    }

    public static void dfs(int u) {
        if (u > m) {
            for (int i = 1; i <= m; i++) {
                System.out.print(state[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (i > state[u - 1]) {
                state[u] = i;
                dfs(u + 1);
                // 恢复现场
                state[u] = 0;
            }
        }
    }

}
