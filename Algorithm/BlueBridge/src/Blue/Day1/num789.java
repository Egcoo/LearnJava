package Blue.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ author Egcoo
 * @ date 2023/4/1 - 20:25
 */
public class num789 {

    static int N = 100010;
    static int n;
    static int q;
    static int[] array = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        q = Integer.parseInt(s[1]);

        s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(s[i]);
        }

        while (q-- > 0) {
            int t = Integer.parseInt(bf.readLine());
            int l = 0, r = n - 1;

            while (l < r) {
                int mid = (l + r) / 2;
                if (mid > t) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (r == t) {
                System.out.print(r + " ");
                r = n - 1;
                while (l < r) {
                    int mid = (l + r + 1) / 2;
                    if (mid < t) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                System.out.print(r);
            } else {
                System.out.println("-1 -1");
            }
        }
    }
}

