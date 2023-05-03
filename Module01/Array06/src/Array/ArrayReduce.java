package Array;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/1/21 - 20:34
 */
public class ArrayReduce {
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
        int arr[] = {1, 2, 3,4 ,5};

        while (true){
                    //询问是否继续
                    System.out.println("要缩减吗？");
                    char c1 = myScanner.next().charAt(0);
                    if(arr.length == 1){
                        System.out.println(" shut the fuck up,就这一个了");
                        break;
                    }
                    if( c1 == 'n'){
                        break;
                    }

                    //遍历数组然后拷贝数组
                    int arrNew[] = new int[arr.length - 1];
                    for (int i = 0; i < arrNew.length; i++) {
                        arrNew[i] = arr[i];
                    }

                    arr = arrNew;

                    //遍历输出当前数组的内容是
                    System.out.println("======缩减后=======");
                    for (int i = 0; i < arrNew.length; i++) {
                        System.out.print(arrNew[i] + " ");
                    }

                }

    }
}