package class11;

/**
 * @ author Egcoo
 * @ date 2023/2/6 - 17:17
 * <p>
 * DP3 属于是两张图，用一张图去推导另一张图
 */
public class DP3pro {

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }
        // s[i][i]] = 0
        for (int i = 0; i < N; i++) {
            int L = 0;
            int R = i;
            while (L < N && R < N) {
                f[L][R] = Math.max(arr[L] + s[L + 1][R], arr[R] + s[L][R - 1]);
                s[L][R] = Math.min(f[L + 1][R], f[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(f[0][N - 1], s[0][N - 1]);
    }
}
