package Blue.Day1;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/1 - 16:28
 * 1.枚举全排列
 * 2.枚举位数
 * 3.判断等式是否成立
 * <p>
 * 组合型枚举 + 等式的特判
 */
public class num1209 {

    static int N = 10;
    static int n;
    static int res;
    static int[] a = new int[N]; // 存一个数组
    static boolean[] st = new boolean[N]; // 表示状态，true就是使用过，false就是未使用

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        dfs3(0);
        out.println(res);
        out.flush();

    }

    public static void dfs3(int u) {
        if (u == 9) {
            for (int i = 0; i < 7; i++) {
                for (int j = i + 1; j < 8; j++) {
                    int a = cal(0, i);
                    int b = cal(i + 1, j);
                    int c = cal(j + 1, 8);
                    if (a * c + b == c * n) {
                        res++;
                    }
                }
            }

        }
        //这里的部分才是给数组的元素赋值的操作
        for (int i = 1; i <= 9; i++) {
            if (!st[i]) {
                st[i] = true;
                a[u] = i;
                // 到这里以后再回去循环，某个数字用过没有
                dfs3(u + 1);
                st[i] = false;
            }
        }

    }

    public static int cal(int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum = sum * 10 + a[i];
        }
        return sum;

    }
}
