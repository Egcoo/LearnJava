package part1.recursion1_3;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/9/8 - 16:03
 */
public class SelectNum1036 {
    /*

    有点类似于动态规划那种，需要把中间结果记录下来，等到用到的时候就直接返回
    如果 a≤0 或 b≤0或 c≤0 就返回值1
    如果 a>20 或 b>20 或 c>20 就返回 w(20,20,20)
    如果 a<b 并且 b<c 就返回w(a,b,c−1)+w(a,b−1,c−1)−w(a,b−1,c)
    其它的情况就返回 w(a−1,b,c)+w(a−1,b−1,c)+w(a−1,b,c−1)−w(a−1,b−1,c−1)
     */

    static int[][][] rpt = new int[25][25][25];

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int a, b, c;

        while (true) {
            a = myScanner.nextInt();
            b = myScanner.nextInt();
            c = myScanner.nextInt();
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            if(a>20) a=21;
            if(b>20) b=21;
            if(c>20) c=21;
            //w(1, 1, 1) = 2
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (rpt[a][b][c] != 0) {
            return rpt[a][b][c];
        } else if (a > 20 || b > 20 || c > 20) {
            rpt[a][b][c] =  w(20, 20, 20);
        } else if (a < b && b < c) {
            rpt[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            rpt[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return rpt[a][b][c];

    }
}
