package Basics01;

import class1.SelectSort01;

import java.util.Arrays;
import java.util.Random;

/**
 * @ author Egcoo
 * @ date 2022/9/3 - 10:28
 */

// 1.对数器
// 2.产生足够多的随机样本
// 3，用确定正确的算法计算样本结果
// 4.对比验证算法的结果

    // 这个之后的作用就是可以被继承，然后重写 check 方法。
public class DataChecker {

    public static void main(String[] args) {
        check();
    }

    public static int[] generateRandomArray(){
        Random r = new Random();

        int [] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }

    public static void check(){
        int[] arr = generateRandomArray();
        int[] arr2 = generateRandomArray();

        System.arraycopy(arr,0,arr2,0,arr.length);
        Arrays.sort(arr);
        SelectSort01.select(arr2);

        boolean same = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]){
                same = false;
            }
        }
        System.out.println(same);
    }
}
