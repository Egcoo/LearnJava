package AcWing.Day222;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/2/26 - 13:58
 * <p>
 * 思路：二进制所有的结果都用 set 来存储，三进制也尝试所有结果，2进制30种和三进制60种情况，只会有一种交集，
 * 要去取那个交集
 * 注意：可能会产生前导零的问题，比如0111和  22都代表 8，实际上是错误的结果
 * 正确的二进制数第一位一定不可能是0
 */
public class ClumsyFinger {

    static String N1; //输入二进制的数字
    static String N2; //输入三进制的数字
    static HashSet<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) {
        finger();
    }

    public static void finger() {
        Scanner scanner = new Scanner(System.in);
        N1 = scanner.next();
        N2 = scanner.next();
        char[] x = N1.toCharArray();
        char[] y = N2.toCharArray();

        for (int i = 0; i < x.length; i++) {
            // 每次都重新开一个数组
            String s = N1;
            char[] chars = s.toCharArray();
            // 这是一个小技巧，可以完成字符的 ‘0’ 和 ‘1’ 的转换
            //if (chars[i] == '0') {
            //    chars[i] = '1';
            //} else {
            //    chars[i] = '0';
            //}
            chars[i] ^= 1;
            if (chars.length > 1 && chars[0] == '0') {
                continue;
            }
            set.add(base(chars, 2));
        }

        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < 3; j++) {
                String s = N2;
                char[] chars = s.toCharArray();
                // 这个判断就是要在剩下的选择中挑剩余的两种
                if ((chars[i] - '0') != j) {
                    chars[i] = (char) (j + '0');
                    if (chars.length > 1 && chars[0] == '0') {
                        continue;
                    }
                    int n = base(chars, 3);
                    if (set.contains(n)) {
                        System.out.println(n);
                        return;
                    }
                }
            }
        }

    }

    public static int base(char[] chars, int b) {
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = res * b + (chars[i] - '0');
        }
        return res;
    }
}
