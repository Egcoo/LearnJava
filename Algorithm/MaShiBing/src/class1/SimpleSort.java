package class1;

import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2022/12/30 - 19:34
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 67, 54, 32, 2, 18};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    //插入排序 像是斗地主摸牌划牌，拿到一张牌给放到合适的位置再拿下一张
    // 不同的排序导致的时间复杂度不太一样
    // 两层循环，外层i=1 && i < arr.length(做到 0-i有序) 内层 j = i-1
    // 内层判断条件 j>=0 && arr[j] > arr[j + 1] j--
    //
    public static void insertionSort(int[] arr) {
        //首先是合法性检验
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {//做到 0-i有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }

        }
    }


    //一个邪门问题2：一个数组中，有两个数出现奇数次，其余全部偶数次，找出来两个奇数次。
    //涉及到计算机基础的位运算
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //eor = a^b
        //eor != 0
        //eor必然有一个位置上是1
        int rightOne = eor & (~eor + 1); // 提取出最右边的1
        int onlyOne = 0;//eor`
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) == 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }


    //一个邪门的交换逻辑,就这样也可以交换过来
    /*
    a = a^b; a=甲^乙 b=乙
    a = a^b; a=甲^乙 b=甲^乙^乙 = 甲
    a = a^b; a=甲^乙^甲=甲^甲^乙 = 0^乙 = 乙
    前提是a和b所指向的内存是两块东西。
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /*
    1.冒泡是每轮先出来最大的值
    2.两层循环，外层i=arr.length-1 内层j<i
    3.内层判断条件：arr[j] > arr[j + 1] 就交换
     */
    public static void bubbleSort(int[] arr) {
        //首先是合法性检验
        if (arr == null || arr.length < 2) {
            return;
        }
        //第一个循环是在（0，arr.length-1）长度上做交换，
        for (int i = arr.length - 1; i > 0; i--) {
            //具体到某一轮做交换
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /*
    1.合法性判断，数组为空或者只有一个数直接退出
    2.两层循环，外层<arr.length -1;  内层j=i+1 而且 <=arr.length-1
    2.5 新变量 minIndex +  minIndex = arr[j] < arr[minIndex] ? j : minIndex;
    3.内层循环每次找出数组中最小值的下标，跳出内层循环做交换
     */
    public static void selectSort(int[] arr) {
        //首先是合法性检验
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
    }
}
