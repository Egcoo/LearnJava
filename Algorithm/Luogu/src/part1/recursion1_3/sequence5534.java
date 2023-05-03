package part1.recursion1_3;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/9/10 - 16:20
 */
public class sequence5534 {

    //一行 3 个整数 a1,a2,n，表示等差数列的第 1,2 项以及项数。需要求出前几项之和
    // 使用一个循环
    // 注意测试范围，数据测试的范围可能会超出 int 的大小限制，int最大也就是十位数
    //
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        long a1 = myScanner.nextInt();
        long a2 = myScanner.nextInt();
        long n = myScanner.nextInt();

        long d = a2 - a1;
        long sum = (a1 + (a1 + (n - 1) * d)) * n / 2;


        System.out.println(sum);
    }
}
