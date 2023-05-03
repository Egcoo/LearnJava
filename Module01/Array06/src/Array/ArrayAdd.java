package Array;

/**
 * @ author Egcoo
 * @ date 2022/1/21 - 18:07
 */

import java.util.Scanner;

public class ArrayAdd {
    public static void main(String[] args) {

        //实现动态的给数组添加元素的效果，实现对数组的扩容，
        //原始数组使用静态分配，int arr[]= {1,2,3};
        //增加元素4，直接放在元素的后面的，arr [] = {1,2,3,4}
        //用户决定是否继续添加

        /*
        1.在原有基础上改不太可能，只能重新上定义一个数组，之后引用赋值
        2.定义两个数组，
        3.for 循环可以辅助输入元素，if判断是不是要继续输入
        4.能输入东西
         */
        //缺点：效率低，每次循环都要重新创建一个数组。
        Scanner myScanner = new Scanner(System.in);
        int arr[] = {1, 2, 3};

        do {
            //遍历数组然后拷贝数组
            int arrNew[] = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                arrNew[i] = arr[i];
            }

            System.out.println("输入你要添加的元素：");
            int addNum = myScanner.nextInt();
            //将addNum赋值给最后一个元素
            arrNew[arrNew.length - 1] = addNum;
            arr = arrNew;

            //遍历输出当前数组的内容是
            System.out.println("======扩容后=======");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }

            //询问是否继续
            System.out.println("还输入吗？");
            char c1 = myScanner.next().charAt(0);
            if( c1 == 'n'){
                break;
            }
        } while (true);


    }
}
