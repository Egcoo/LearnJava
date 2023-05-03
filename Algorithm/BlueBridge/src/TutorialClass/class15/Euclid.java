package TutorialClass.class15;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/28 - 18:44
 */
public class Euclid {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a, b, x, y;
        String[] s = bf.readLine().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);

        int res = gcd(a, b);
        System.out.println(res);


    }

    //欧几里得算法，求最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd2(b, a % b);
    }

    // 扩展欧几里得算法，除了可以求最小公约数，还可以求出一组解 满足 ax + by = d
    // 但是具体在java里这个这个怎么表示出来，见过比较好的方式是用类或数组来模拟指针
    public static int exgcd(int a, int b, int x, int y) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        int d = exgcd(b, a % b, y, x);
        y -= a / b * x;
        return d;
    }

}
