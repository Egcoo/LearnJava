package class2;

import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/1/2 - 15:10
 */
public class Sort {
    public static void main(String[] args) {
        /*
        int[] arr = {1, 3, 4, 2, 5};
        int sum = smallSum(arr);
        System.out.println(sum);
         */
        int[] arr = {4, 5, 6, 3, 67, 54, 32, 2, 18};
        process(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    //小和问题
    // 一个组的的内部不会产生小和，只有左组和右组合跨的时候才会产生小和
    // 虽然可以改成一个 n*logN 的好的解法，但是排序的过程就没有稳定性了
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process1(arr, 0, arr.length - 1);
    }

    public static int process1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) / 2);
        return process1(arr, L, mid) +
                process1(arr, mid + 1, R) +
                merge1(arr, L, mid, R);
    }

    public static int merge1(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            //注意相等的时候先搞右侧的数
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return res;
    }

    //----------------归并排序------------------------
    /*
    归并（Merge）排序的实质：比较信息的行为是往下传递的
    1）整体是一个简单递归，左边排好序，右边排好序，让整体有序
    2.在整个范围上准备一个辅助空间，谁小拷贝谁
    3.左边<=右边 的时候都先拷贝左边，目的是保持整个数组稳定
    4.到那侧越界，把剩余部分直接拷贝进去（两个while只会中一个）
    5.完了再拷贝回原数组
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) / 2);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }
}
