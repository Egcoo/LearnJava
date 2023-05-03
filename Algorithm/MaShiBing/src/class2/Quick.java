package class2;

import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/1/2 - 17:38
 * <p>
 * 快排的特点就是一次搞定一批数
 */
@SuppressWarnings("all")
public class Quick {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 3, 67, 54, 32, 2, 18};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // 快排这里的一个随机选取数的程序，可以让其时间复杂度降到 N*log2N
    public static void quickSort(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //将 arr[L...R]排好序
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1); // <区
            quickSort(arr, p[1] + 1, R); // >区
        }
    }

    //这是一个处理 arr[L...R]的函数
    //默认以 arr[R] 做划分，arr[R] -> p     <p  ==p  >p
    //返回等于区域（左边界，右边界），所以返回一个长度为2的数组 res,res[0] res[1]
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1; // <区右边界
        int more = R; // >区左边界
        while (L < more) { // L表示当前数的位置 arr[R] -> 划分值
            if (arr[L] < arr[R]) { //
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        //荷兰国旗问题
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int M, int R) {
        int temp = arr[M];
        arr[M] = arr[R];
        arr[R] = temp;
    }

}
