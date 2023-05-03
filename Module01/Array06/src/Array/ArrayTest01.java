package Array;

/**
 * @ author Egcoo
 * @ date 2022/1/21 - 10:22
 */

import java.util.Scanner;

public class ArrayTest01 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //定义输入一个double数组并且输出
        double scores[] = new double[5];

        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个元素的值");
            scores[i] = myScanner.nextDouble();
        }

        System.out.println("数组的情况如下：");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("第" + (i + 1) + "个元素的值为：" + scores[i]);
        }
    }
}
