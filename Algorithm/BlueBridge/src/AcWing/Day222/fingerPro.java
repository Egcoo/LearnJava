package AcWing.Day222;

import java.io.*;
import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/2/27 - 16:34
 *
 * BufferedReader 对Scanner的改良版
 */
public class fingerPro {

    static String N1; //输入二进制的数字
    static String N2; //输入三进制的数字
    static HashSet<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {
        finger();
    }

    public static void finger() throws IOException {
        //Scanner scanner = new Scanner(System.in);
        //N1 = scanner.next();
        //N2 = scanner.next();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N1 = br.readLine();
        N2 = br.readLine();
        char[] x = N1.toCharArray();
        char[] y = N2.toCharArray();

        for (int i = 0; i < x.length; i++) {
            // 每次都重新开一个数组
            String s = N1;
            char[] chars = s.toCharArray();
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
