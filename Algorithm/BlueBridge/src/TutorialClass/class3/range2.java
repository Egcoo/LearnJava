package TutorialClass.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ author Egcoo
 * @ date 2023/3/4 - 19:01
 * <p>
 * 共一行，包含一个浮点数 n。
 * 输出格式
 * 共一行，包含一个浮点数，表示问题的解。
 * <p>
 * 注意，结果保留 6位小数。
 */
public class range2 {

    static double n;
    static double l = -10000;
    static double r = 10000;

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Double.parseDouble(bf.readLine());

        while (r - l >= 1e-8) {
            double mid = (l + r) / 2;
            if (mid * mid * mid >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.printf("%.6f%n", l);
    }

}
