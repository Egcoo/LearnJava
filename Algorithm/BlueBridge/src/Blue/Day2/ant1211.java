package Blue.Day2;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/2 - 14:01
 */
public class ant1211 {

    static int N = 55;
    static int n;
    static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        //这里更应该计算的是向已经感冒蚂蚁靠近的个数，这个方法会更好一些
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i]) < Math.abs(a[0]) && a[i] > 0) {
                left++;
            } else if (Math.abs(a[i]) > Math.abs(a[0]) && a[i] < 0) {
                right++;
            }
        }

        if (left == 0 && a[0] < 0 || right == 0 && a[0] > 0) {
            out.println(1);
        }else {
            out.println(left + right + 1);
        }
        out.flush();


    }
}
