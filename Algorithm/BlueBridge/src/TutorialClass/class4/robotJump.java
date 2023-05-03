package TutorialClass.class4;

import java.io.*;
import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/3/4 - 20:20
 * <p>
 * 1.看是否具有二段性，不仅是数据是否具有二段性，最后的结果也可以从一个范围里求出来
 * 2.初始化E0,可以满足；E' >= E0 也一定可以满足要求
 * 3.最小值就是0，一定取不到0，能量最大值就是100000，如果初始值是100000，那么就一定不会递减
 * 因为有范围限制，初始值一定在两个范围之间
 */
public class robotJump {

    static int N;
    static int[] h = new int[N];

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        //一步直接把string数组变为int数组
        String[] strings = bf.readLine().split(" ");
        h = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        int l = 0, r = 100000;

        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(r);
    }

    public static boolean check(int e) {
        for (int i = 0; i < N; i++) {
            e = e * 2 - h[i];
            if (e >= 100000) {
                return true;
            } else if (e < 0) {
                return false;
            }
        }
        return true;
    }
}
