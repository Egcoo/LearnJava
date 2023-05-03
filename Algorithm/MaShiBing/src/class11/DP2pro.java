package class11;

/**
 * @ author Egcoo
 * @ date 2023/2/6 - 17:00
 */
public class DP2pro {

    public static int dpWay(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        //dp[N][.......] = 0
        //这是一张二维表，只知道最后一行的值，从底下往上面推
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) { //rest < 0
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                //剩余的空间必须比 货物所占的空间要大
                if (rest - w[index] >= 0) {
                    p2 = v[index] + dp[index + 1][rest - w[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }


    public static int maxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }

    // 只剩下 rest 的空间了
    // index... 货物的自由选择，但是剩余的空间不要小于0
    // 返回 index... 货物能够获取的最大价值
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        // rest >= 0
        if (index == w.length) {
            return 0;
        }
        //有货也有空间
        // 不要index 处货物的价值
        // 单独调取 p1 不会违规，而p1的后续有可能违规的
        int p1 = process(w, v, index + 1, rest);
        int p2 = -1;
        int p2Next = process(w, v, index + 1, rest - w[index]);
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }
}
