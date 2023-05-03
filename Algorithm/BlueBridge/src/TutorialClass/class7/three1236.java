package TutorialClass.class7;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/14 - 16:40
 * <p>
 * 1.找到问题中最重要的变量，一个变量和其他都能建立关系。
 */
public class three1236 {

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

        int aa = 1, cc = 1;
        for (int i = 1; i <= n; i++) {
            int key = B[i];
            while (aa <= n && A[aa] < key) {
                aa++;
            }
            while (cc <= n && C[cc] <= key) {
                cc++;
            }

            ans += (long) (aa - 1) * (n - cc + 1);
        }

        out.println(ans);
        out.flush();
    }
}
