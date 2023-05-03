package DP1;

/**
 * @ author Egcoo
 * @ date 2023/1/20 - 18:13
 */
public class DP2 {

    // 背包问题最经典的写法
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
        /*
        int p2 = Integer.MIN_VALUE;
        if (rest >= w[index]) {
            p2 = v[index] + process(w, v, index + 1, rest - w[index]);
        }
         */
        return Math.max(p1, p2);
    }


    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, 0, bag);
    }

    //不变：w[] v[] bag
    //index... 最大价值
    //0.. index-1 上做了货物到选择，是的你已经达到了重量是多少 alreadyW
    // 如果返回-1 认为没有方案
    public static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        if (alreadyW > bag) {
            return -1;
        }
        // 重量没超
        if (index == w.length) {
            return 0;
        }
        // 我没有要当前的 index 货的情况下后续的最大价值
        int p1 = process(w, v, index + 1, alreadyW, bag);

        // 我要了 index 位置的货物
        int p2next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2next != -1) {
            p2 = v[index] + p2next;
        }
        return Math.max(p1, p2);
    }
}
