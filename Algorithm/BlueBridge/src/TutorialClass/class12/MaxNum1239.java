package TutorialClass.class12;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/27 - 19:07
 * <p>
 * 比较吊诡的一点：贪心问题几乎都有 排序
 * 一个问题如果找不到相应的模型处理，一般就会放到模拟或者贪心
 */
public class MaxNum1239 {

    static int N = 100010;
    static int mod = 1000000009;
    static int n, k;
    static int[] a = new int[N];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(a, 1, n + 1);

        // 主要步骤开始
        long res = 1;
        int l = 1;
        int r = n;
        int sign = 1;
        // 由于四种情况中，只有k<n 而且是奇数的时候需要特判，别的时候都可以转化为双指针
        // 而且这个奇数组合中，最大的数一定取
        if (k % 2 == 1) {
            res = a[r];
            r--;
            k--;
            if (res < 0) {
                sign = -1;
            }
        }

        while (k > 0) {
            long x = (long) a[l] * a[l + 1];
            long y = (long) a[r] * a[r - 1];
            // 选择更大的一对
            if (x * sign > y * sign) {
                res = x % mod * res % mod;
                l += 2;
            } else {
                res = y % mod * res % mod;
                r -= 2;
            }
            k -= 2;
        }
        out.println(res);
        out.flush();

    }
}
