package class1;

import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2022/9/2 - 21:25
 */
public class SelectSort01 {
    public static void main(String[] args) {
        int[] arr = {12, 44, 56, 77, 54, 22, 88};
        int[] arr1 = {12, 8};
        select(arr);

        System.out.println(Arrays.toString(arr));
    }

    // 选择排序，不稳定在于两个相等的数，再排完顺序以后相对顺序可能会变化
    // 依次遍历中找到最小的数和数组最前进行替换
    // 论算法的哲学
    // 1.又简单到复杂：多尝试打印中间结果
    // 2.先局部后整体：没思路时先细分，比如选择排序，先实现大功能里的一个数字的排序
    // 3.可以最后修改变量名称

    public static int[] select(int[] arr) {

        //因为你 j 一定是 i 后面的一个数，所以 i 的值只需要到 arr.length -1 就行
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }

        return arr;
    }
}
