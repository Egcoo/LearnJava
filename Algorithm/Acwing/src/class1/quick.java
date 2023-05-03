package class1;

import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/2/20 - 15:18
 */
public class quick {

    public static void quickSort(int q[], int l, int r) {
        if (l >= r) {
            return;
        }
        int x = q[l];
        //因为你上来就要加或者减，所以相应的i,j 需要做出一点修改
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (q[i] < x);
            do {
                j--;
            } while (q[j] > x);
            if (i < j) {
                swap(q, i, j);
            }
        }
        //这里不能调换是因为 i 和 j 可以不相等，不能这么做
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }

    public static void swap(int[] arr, int M, int R) {
        int temp = arr[M];
        arr[M] = arr[R];
        arr[R] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 67, 54, 32, 2, 18};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
