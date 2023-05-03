package TwoDimensionalArray;

/**
 * @ author Egcoo
 * @ date 2022/1/23 - 10:26
 */

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //整体的思路还是扩容＋冒泡

         /*
        1.在原有基础上改不太可能，只能重新上定义一个数组，之后引用赋值
        2.定义两个数组，
        3.for 循环可以辅助输入元素，if判断是不是要继续输入
        4.能输入东西
         */
        int[] arr = {10, 12, 400, 90};

        do {
            //先定义一个新数组把原数组拷贝
            int[] arrNew = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                arrNew[i] = arr[i];
            }
            //接收新的元素
            System.out.println("输入新元素：");
            int addNum = myScanner.nextInt();
            arrNew[arrNew.length - 1] = addNum;
            //
            arr = arrNew;
            //
            //冒泡排序新数组
            for (int count = 0; count < arrNew.length - 1; count++) {
                for (int i = 0; i < arrNew.length - 1 - count; i++) {
                    if (arrNew[i] > arrNew[i + 1]) {
                        int temp = arrNew[i];
                        arrNew[i] = arrNew[i + 1];
                        arrNew[i + 1] = temp;
                    }
                }
            }
            //遍历新数组
            System.out.println("=========新数组是：");
            for (int i = 0; i < arrNew.length; i++) {
                System.out.print(arrNew[i] + " ");
            }
            System.out.println("还输入吗？");
            char c1 = myScanner.next().charAt(0);
            if (c1 == 'n') {
                break;
            }
        } while (true);

    }
}
