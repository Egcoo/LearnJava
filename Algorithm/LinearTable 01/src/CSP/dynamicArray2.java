package CSP;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/8/15 - 23:48
 */
public class dynamicArray2 {
    public static void main(String[] args) {
        System.out.println("请输入动态数组的大小：");
        Scanner myScanner = new Scanner(System.in);
        //int n = myScanner.nextInt();
        int n = 5;
        /*
        判断输入 n 的合法性
          if (n < 0){
            return;
        }
         */
        char[] arr = new char[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("输入第 " + (i + 1) + " 个元素：");
            String temp = myScanner.next();
            //把 temp 的第i个char值赋值给c，类似于数组的查找。
            char c = temp.charAt(0);
            arr[i] = c;
        }

        System.out.println("动态数组共" + n + "个信息: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int k = arrMax(arr);
        System.out.println();
        System.out.println("动态数组" + n + "个数据中的最高是第" + (k + 1) + "个数据");


    }

    public static int compare(char[] a, char[] b) {
        //调用 String 类的 valueOf 函数转换
        String A = String.valueOf(a);
        String B = String.valueOf(b);
        if (A.compareTo(B) > 0)
            return 0;
        else if (A.compareTo(B) < 0)
            return -1;
        else
            return 1;
    }
    /*
    public static int arrMax(char[] a, int n) {
    }
    1.ElemType a[] 不太明白
     int arrmax(ElemType a[],int n) {}

    2. input、output 单独作为一个函数可能并不是必要的
     */
    public static int arrMax(char[] a) {
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[k] < a[i]) {
                k = i;
            }
        }
        return k;
    }
}
