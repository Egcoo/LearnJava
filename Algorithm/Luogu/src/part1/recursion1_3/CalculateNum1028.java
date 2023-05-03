package part1.recursion1_3;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/9/8 - 15:18
 */
public class CalculateNum1028 {
    //关于递归和递推这个东西还是有点迷惑，现在的思路就是可以尝试着先找找规律
    //就是把几种情况写下来，看看其中的规律是什么
    //f[1]=1
    //f[2]=2=f[1]+1
    //f[3]=2=f[1]+1
    //f[4]=4=f[1]+f[2]+1
    //f[5]=4=f[1]+f[2]+1


    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int n = myScanner.nextInt();;
        int[] f = new int[1001];

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i/2 ; j++) {
                f[i] += f[j]; //每一位叠加，递推
            }
            f[i]++;
        }

        System.out.println(f[n]);
    }
}
