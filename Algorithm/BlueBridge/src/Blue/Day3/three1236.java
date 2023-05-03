package Blue.Day3;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/4/3 - 14:04
 *
 * 算法2（二分法）
 *
 *     1、对3个数组分别进行从小到大排序
 *
 *     2、找到a[]数组中最小的大于等于bi的元素位置la，便可知小于bi的个数为num1
 *
 *     3、找到c[]数组中最大的小于等于bi的元素位置lb，便可知大于bi的个数为num2
 *
 *     4、由于a[]和c[]互斥，通过乘法原理可知符合条件的个数为num1 * num2
 *     注意：当la == 0 或者 lb == n + 1时，则表示不符合条件
 *
*     对于好几个数组的比较可以选择一个标的，以中间的一个数组作为对照组
 */
public class three1236 {

    // 十年OI一场空，不开long long见祖宗
    static int N = 10010;
    static int n;
    static int[] A = new int[N];
    static int[] B = new int[N];
    static int[] C = new int[N];
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] a = bf.readLine().split(" ");
        String[] b = bf.readLine().split(" ");
        String[] c = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(a[i - 1]);
            B[i] = Integer.parseInt(b[i - 1]);
            C[i] = Integer.parseInt(c[i - 1]);
        }
        Arrays.sort(A, 1, n + 1);
        Arrays.sort(B, 1, n + 1);
        Arrays.sort(C, 1, n + 1);

        int mid = 0;
        for (int i = 1; i <= n; i++) {
            int la = 0, ra = n + 1;
            while (la < ra) {
                mid = (la + ra) / 2;
                if (A[mid] >= B[i]) {
                    ra = mid;
                } else {
                    la = mid + 1;
                }
            }

            int lb = 0, rb = n + 1;
            while (lb < rb) {
                mid = (lb + rb + 1) / 2;
                if (C[mid] <= B[i]) {
                    lb = mid;
                } else {
                    rb = mid - 1;
                }
            }
            if (la == 0 || lb == n + 1) {
                continue;
            }
            ans += (long) (la - 1) * (n - lb);
        }

        out.println(ans);
        out.flush();
    }
}
