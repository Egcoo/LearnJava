package CSP;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/8/15 - 11:30
 */
public class dynamicArray {
    public static void main(String[] args) {
        System.out.println("请输入动态数组的大小：");
        Scanner myScanner = new Scanner(System.in);
        //int test = myScanner.nextInt();
        int n = 10;
        /*
          if (n < 0){
            return;
        }
         */
        int[] arr = new int[n];

        //解释 (Math.random() * 101);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);

        }

        System.out.println("动态数组共" + n + "个信息: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int k = arrMax(arr, n);
        System.out.println();
        System.out.println("动态数组" + n + "个数据中的最高是第" + (k + 1) + "个数据");


    }

    public static int compare(int a, int b) {
        if (a == b)
            return 0;
        else if (a < b)
            return -1;
        else
            return 1;
    }

    public static int arrMax(int[] a, int n) {
        int i, k;
        k = 0;
        for (i = 0; i < n; i++) {
            if (compare(a[k], a[i]) < 0) {
                k = i;
            }
        }
        return k;
    }
}
