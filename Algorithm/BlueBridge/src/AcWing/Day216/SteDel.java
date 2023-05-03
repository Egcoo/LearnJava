package AcWing.Day216;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/2/21 - 19:29
 * <p>
 * 双指针写法
 * <p>
 * 每一段都是独立的
 */
public class SteDel {

    static int n;
    static String str;

    public static void del() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        str = scanner.next();
        char[] chars = str.toCharArray();


        // 大循环套一个小循环
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int slow = i;
            int fast = i;
            //这里判断的标准是 fast == x 也就是i==x 的时候才进入循环，否则直接下一轮
            while (chars[fast] == 'x') {
                if ((fast - slow) >= 2) {
                    count++;
                    break;
                }
                fast++;
            }
        }
        // y总解法
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'x') {
                int j = i + 1;
                while (j < n && chars[j] == 'x') {
                    j++;
                }
                count += Math.max(j - i - 2, 0);
                // 因为i最后还要++，所以i = j - 1;
                i = j - 1;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        del();
    }
}
