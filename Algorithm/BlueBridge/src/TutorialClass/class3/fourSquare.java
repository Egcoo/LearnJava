package TutorialClass.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @ author Egcoo
 * @ date 2023/3/4 - 19:46
 * 1.数据范围小于5000000，因为我们求的是平方，所以数据范围会在2300左右
 * 2.最多只能枚举两次，三次的结果是8*10^9 就会超时
 * 3.采用时间换空间的方法，c和d的结果存起来，a和b去寻找，同时去找到字典序最小的组合
 */
public class fourSquare {
    static int N;
    static HashMap<Object, Integer> Obj = new HashMap();

    public static class Stru {
        int c;
        int d;

        public Stru(int c, int d) {
            this.c = c;
            this.d = d;
        }
    }

    public void test2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for (int c = 0; c * c <= N; c++) {
            for (int d = c; c * c + d * d <= N; d++) {
                Stru stru = new Stru(c, d);
                if (!Obj.containsValue(c * c + d * d)) {
                    Obj.put(stru, d * d + c * c);
                }

            }
        }
        for (int a = 0; a * a <= N; a++) {
            for (int b = a; b * b + a * a <= N; b++) {
                int t = N - (a * a + b * b);
                if (Obj.containsValue(t)) {
                    for (Object key : Obj.keySet()) {
                        int value = Obj.get(key);
                        if (t == value) {
                            Stru stru = (Stru) key;
                            System.out.println(a + " " + b + " " + stru.c + " " + stru.d);
                            return;
                        }
                    }
                }
            }
        }
    }

    // 方法1：暴力解法
    // 在关键数据上会有TLE
    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        for (int a = 0; a * a <= N; a++) {
            for (int b = a; b * b + a * a <= N; b++) {
                for (int c = b; b * b + a * a + c * c <= N; c++) {
                    int t = N - (b * b + a * a + c * c);
                    int d = (int) Math.sqrt(t);
                    if (d * d == t) {
                        System.out.println(a + " " + b + " " + c + " " + d);
                        return;
                    }
                }
            }
        }

    }
}