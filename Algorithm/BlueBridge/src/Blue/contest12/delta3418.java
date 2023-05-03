package Blue.contest12;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/6 - 13:15
 * shoplifter
 */
@SuppressWarnings("all")
public class delta3418 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        for (int k = 16; ; k--) {
            if (check(k)) {
                break;
            }
        }
    }

    public static boolean check(int k) {
        //二分该斜行，找到大于等于该值的第一个数
        // 左边界2k，右边界max(l,n)  取二者最大即可
        long l = 2 * k, r = Math.max(l, n);
        while (l < r) {
            long mid = (l + r) / 2;
            if (C(mid, k) >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (C(r, k) != n) {
            return false;
        }
        //C(r,k) : 底数为r，说明目前在第 r+1行，上面有r行
        // 每一行都比上一行多1一个数，是个等差数列，求和公式为（a1 + an） * n/2
        // 指数为 k，说明目前处在第k个斜行，对于到第k+1个数
        System.out.println((r + 1) * r / 2 + k + 1);
        return true;
    }

    public static long C(long a, long b) {
        long res = 1;
        for (long i = a, j = 1;j <= b; i--, j++) {
            res = res * i / j;
            //大于n已经无意义
            if (res > n) {
                return res;
            }
        }
        return res;
    }

}
