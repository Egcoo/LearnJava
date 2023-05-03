package AcWing.Day214;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2023/2/17 - 14:55
 * 数组V长度在不断变化
 * 1.你要进行n次操作，最后数组长度一定是n，所以我们模拟出一个差分数组b，数组长度直接为n
 * 2.每次操作要对一个区间操作一遍，相当于要对区间里的每一个数字操作一次，
 * 3.相当于对差分数组b相应区间全部加上1，
 * 3.
 * 4.如果超过了数组长度的话，视为对当前整个数组操作一遍
 */
public class Difference {
    public static void main(String[] args) {
        int N = 200010;
        int n;
        int[] b = new int[N];
        Scanner myScanner = new Scanner(System.in);
        int T = myScanner.nextInt();
        while (T-- > 0) {
            n = myScanner.nextInt();
            for (int i = 1; i <= n; i++) {
                b[i] = 0;
            }
            for (int i = 1; i <= n; i++) {
                //x 就是数组中的a[i]
                int x;
                x = myScanner.nextInt();
                //看x是否超出i的大小
                x = Math.min(x, i);
                int l = i - x + 1;
                int r = i;
                b[l]++;
                //
                b[r + 1]--;
            }
            for (int i = 1; i <= n; i++) {
                b[i] += b[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                if (b[i] == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }

    }
}
