package AcWing.Day313;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/30 - 13:58
 * 给定两个整数 n 和 k，请你判断在 [2,n] 的范围内是否存在不少于 k 个质数，满足可以表示为两个相邻质数与 1 的和。
 */
public class num3792 {

    static int N = 1010;
    static int T;
    static int n, k;
    static int[] primes = new int[N]; // 存所有的质数
    static int cnt = 0; // 记录质数的个数
    static boolean[] st = new boolean[N]; // 记录质数是否被筛过，0没被筛过，1被筛过

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bf.readLine());
        getPrimes(1000);
        while (T-- > 0) {
            String[] s = bf.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            k = Integer.parseInt(s[1]);

            int res = 0;
            for (int i = 2; i <=  n; i++) {
                if (!st[i]) {
                    for (int j = 1; j < cnt; j++) {
                        if (primes[j-1] + primes[j] + 1 == i) {
                            res++;
                            break;
                        }
                    }
                }
            }
            if (res >= k) {
                out.println("YES");
            } else {
                out.println("NO");
            }

        }

        out.flush();

    }

    public static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] * i <= n; j++) {
                st[primes[j] * i] = true; // 把质数的i倍筛掉
                if (i % primes[j] == 0) {
                    // 通过最小质因子筛选
                    break;
                }
            }
        }
    }
}
