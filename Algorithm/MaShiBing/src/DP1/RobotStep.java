package DP1;

/**
 * @ author Egcoo
 * @ date 2022/9/8 - 14:31
 */
public class RobotStep {

    //问题描述是现有一个机器人，在一排连续的的数字（比如1-7）的某一个面前（比如3），
    // 最后的目的地是到某一个数字（比如4）
    // 一共走n步，从当前的数字到目的地，一共有几种方式
    // 但是在1 处只可以向右走，在n处只可以向 左走

    // 解决方式可以使用暴力递归，递归的一个很重要的思路就是尝试，
    // 包括函数中应该有的参数的多少很多时候也是试出来的

    public static void main(String[] args) {
        System.out.println(ways(4, 2, 4, 4));
    }


    public static int ways(int N, int start, int aim, int K) {

        return progress(start, K, aim, N);
    }


    //机器人当前来到的位置是 cur
    // 机器人还需要 rest 步需要走
    // 最终的目标是 aim
    // 有哪些位置 ？ 1-N
    // 返回：机器人从 cur 出发，走过 test 步以后，最终停在aim的方法数，是多少？
    public static int progress(int cur, int rest, int aim, int N) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return progress(2, rest - 1, aim, N);
        }
        if (cur == N) {
            return progress(N - 1, rest - 1, aim, N);
        }
        //停在中间位置上
        return progress(cur - 1, rest - 1, aim, N) +
                progress(cur + 1, rest - 1, aim, N);

    }


}
