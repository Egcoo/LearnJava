package Blue.Day1;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/2 - 12:23
 */
public class two790 {

    static double n;
    static double l = -10000;
    static double r = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Double.parseDouble(bf.readLine());

        while (r-l >= 10e-8) {
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
