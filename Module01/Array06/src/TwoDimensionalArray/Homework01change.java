package TwoDimensionalArray;

/**
 * @ author Egcoo
 * @ date 2022/1/23 - 12:12
 */

import java.util.Scanner;
public class Homework01change {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //已知有一个升序的数组，要求插入一个数据以后，依旧升序
        //思路：本质还是是数组扩容+定位
        /*
        1.先确定应该放到哪里去，先确定
        2.再扩容
        这里也用到了一个索引，用来辅助确定
         */

        //先定义一个数组，和要插入的数
        int[] arr = {10, 12, 40, 90};
       // int insertNum = 23;
        int index = -1;

        do {
            System.out.println("请输入你要添加的值：");
            int insertNum = myScanner.nextInt();

            //遍历比较，从而确定index
            for (int i = 0; i < arr.length; i++) {
                if (insertNum < arr[i]) {
                    index = i;
                    break;
                } else {
                    index = arr.length;
                }
            }

            //创建一个新数组，建立一个新的索引，插入新数据
            int[] arrNew = new int[arr.length + 1];
            for (int i = 0, j = 0; i < arrNew.length; i++) {
                if (index != i) {
                    arrNew[i] = arr[j];
                    j++;
                } else {
                    arrNew[i] = insertNum;
                }
            }
            //遍历输出数组
            arr = arrNew;
            System.out.println("=======新的数据为========");
            for (int i = 0; i < arrNew.length; i++) {
                System.out.print(arrNew[i] + " ");
            }

            //询问是否还要添加
            System.out.println("还要添加吗？ y/n ");
            char c1 = myScanner.next().charAt(0);
            if( c1 == 'n'){
                break;
            }
        }while (true);

    }
}
