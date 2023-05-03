package class4;

import java.io.*;
import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/3/9 - 15:24
 * <p>
 * 我们的状态表示是所有以 f[i] 结尾的上升子序列
 * 单纯靠着一条信息可以完成一个暴力解法
 *
 * 我们只是把存在的类取一个max，最后一个数是a[i],倒数第2个数是a[j],这样的上升子序列的最大值
 * 整个计算过程的每一步一定是基于之前的结果。
 * 而且需要把每一步的过程保存，这也是一个问题，求最大值的时候分类之间是可以重复的，但求数量的时候是不可以重复的
 *
 *  划分依据：找到最后一个不同点
 */
public class subsequence {

    static int n = 1010;
    static int N;
    static int[] f = new int[n];
    static int[] arr = new int[n];

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        String[] strings = bf.readLine().split(" ");
        f = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            arr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (f[j] < f[i]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, arr[i]);
        }
        System.out.println(res);
    }
}
