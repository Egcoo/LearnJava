package TutorialClass.class3;

import java.io.*;
import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/3/3 - 14:10
 * <p>
 * 1.左端点：大于等于x的第一个位置
 */
public class range {

    static int N = 100010;
    static int n;
    static int q;
    static int[] array = new int[N];

    public static void main(String[] args) throws IOException {
        test();
    }
    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        q = Integer.parseInt(s[1]);

        String[] strings = bf.readLine().split(" ");
        array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(bf.readLine());
            // 找出二分的左端点和右端点
            int l = 0, r = n - 1;
            // 确定左区间的范围
            while (l < r) {
                int mid = (l + r) / 2;
                if (array[mid] >= x) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            if (array[r] == x) {
                System.out.print(r + " ");
                // 寻找二分的右端点
                r = n - 1;
                while (l < r) {
                    // 因为写的是l = mid，所以需要补上1
                    int mid = (l + r + 1) / 2;
                    if (array[mid] <= x) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                System.out.print(r);
                System.out.println();
            } else {
                System.out.println("-1 -1");
            }
        }
    }


}
