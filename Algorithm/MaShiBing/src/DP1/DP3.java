package DP1;

/**
 * @ author Egcoo
 * @ date 2023/1/24 - 17:43
 */
public class DP3 {


    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 先手在0-n-1上获得的分数，和后手在n-1上获得的分数
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));

    }

    public static int s(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
    }
}
