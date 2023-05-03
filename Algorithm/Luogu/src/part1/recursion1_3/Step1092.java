package part1.recursion1_3;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/9/12 - 14:59
 */
//这种题常见思路是先找规律，光看很难看出来，多写几个具体的例子
//k=2 : 1 2 3 5 8 13 21 34...
//k=3 : 1 2 4 7 13 24 44 81...
//k=4 : 1 2 4 8 15 29 56 108...
//k=5 : 1 2 4 8 16 31 61 120...
//  观察发现 k 是几，前几项就是等比数列，公比 = 2
  //规律：
//当n<=k时,第N项=(上一项*2)%100003;
//当n>k时 ,第N项=(上一项*2-第n-1-k项)%100003;



public class Step1092 {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int k = myScanner.nextInt();

        int mod = 100003;
        int[] a = new int[100001];
        a[0] = 1;
        a[1] = 1;
        int ans;

        for (int i = 2; i <= n; i++) {
            if (i <= k) {
                a[i] = (a[i - 1] * 2) % mod;
            } else {
                a[i] = (a[i - 1] * 2 - a[i - 1 - k]) % mod;
            }
        }
        ans = a[n] % mod;
        System.out.println(ans);

    }
}
