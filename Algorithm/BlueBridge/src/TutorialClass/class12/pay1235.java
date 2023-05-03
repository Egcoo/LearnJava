package TutorialClass.class12;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/27 - 13:24
 *
 * 本质考察均值不等式
 */
public class pay1235 {

    // 数据量是十万级别，所以算法应该在O（n）或者O（nLogn）
    // 标准差描述的是数据的波动程度，
    // 需要支付的平均值是一直在变的，如果第一个人的钱小于平均值，他将全部花出，此时不够的钱则下个人均摊，如此往复
    // 所有人的钱数都足够的时候，让每个人掏平均数的钱

    static int N = 500010;
    static int n;
    static long S;
    static int[] b = new int[N];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        S = Long.parseLong(s[1]);

        int[] a = new int[n + 1];
        String[] s1 = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s1[i - 1]);
        }

        Arrays.sort(a, 1, n + 1);
        double avg = S * 1.0 / n;
        double cur = avg;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] <= cur) {
                S -= a[i];
                sum += (avg - a[i]) * (avg - a[i]);
                // 这里是更新平均值
                cur = (S * 1.0) / (n - i);
            } else {
                // 这位同学要交的钱减去平均数
                sum += (cur - avg) * (cur - avg);
            }
        }
        System.out.printf("%.4f", Math.sqrt(sum / n));

    }
}
