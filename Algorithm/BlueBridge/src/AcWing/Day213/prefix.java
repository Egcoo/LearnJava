package AcWing.Day213;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2023/2/15 - 18:20
 * <p>
 * 1.看数据规模可以看出时间复杂度在O(nlogn) 级别，可以使用前缀和算法解决
 * 2.前缀和：标定两个点，后面的点枚举，当后面的点确定以后，决定是否成立的前面的点的前缀满足 S/3,前面的部分向后移动
 * 3.可以理解成是一个集合，如果我们想求整个集合的满足条件的元素个数的话，只需要求子集就可以了
 * 4.每个子集结果相加 = 结果
 * <p>
 * 给定一个长度为 n 的数组 a1,a2,…,an
 * 现在，要将该数组从中间截断，得到三个非空子数组
 * 要求，三个子数组内各元素之和都相等。
 * 请问，共有多少种不同的截断方法？
 * 输入格式
 * 第一行包含整数 n
 * 第二行包含 n
 * 个整数 a1,a2,…,an
 * 输出格式:输出一个整数，表示截断方法数量。
 * 数据范围
 * 前六个测试点满足 1≤n≤10
 * 所有测试点满足 1≤n≤10*5，  −10000≤ ai ≤10000。
 */
public class prefix {
    public static void main(String[] args) {
        // 这步先把结构定下来
        int N = 100010;
        int[] S = new int[N];

        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int tmp;

        // 防止数组越界，所以从i=1开始
        for (int i = 1; i <= n; i++) {
            // 接收传过来的数
            tmp = myScanner.nextInt();
            S[i] = S[i - 1] + tmp;
        }

        //寻找符合题意的集合
        //因为要分成三部分，至少要给前面两个数字流出两部分 0，1 所以从2开始
        //要看总和能不能被3整除，不能就直接返回0
        if (S[n] % 3 != 0) {
            System.out.println(0);
        } else {
            //最后的结果相加可能会超出int的范围
            long res = 0;
            int cnt = 0;
            // 一定不会有重复计算问题，因为 cnt 不会重复计算，cnt跟着i走
            for (int j = 2; j < n; j++) {
                if (S[j - 1] == S[n] / 3) {
                    cnt++;
                }
                if (S[j] == S[n] / 3 * 2) {
                    res += cnt;
                }
            }
            System.out.println(res);
        }
    }

}
