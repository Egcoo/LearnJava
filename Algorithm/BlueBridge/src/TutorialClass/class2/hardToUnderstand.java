package TutorialClass.class2;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/2 - 19:11
 * 1.顺序任意
 * 2.每个格子最多摁一次
 * 3.只要第一行的操作固定完以后，第二行的操作一定被第一行灯的亮灭状态所唯一确定
 * 4.每一行的操作完全被上一行的状态唯一确定
 * 5.为什么要枚举第一行，而不是直接从第二行开始，美剧第一行的按法是用来减少步数的
 * 如果直接从第二行开始，就已经固定了答案，这样的解法不一定是最少的，甚至可能超出范围而没有解
 */
public class hardToUnderstand {

    static int N = 5;
    static char[][] g = new char[N][N];
    static char[][] backup = new char[N][N];

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        while (T > 0) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    g[i][j] = (char) Integer.parseInt(bf.readLine());
                    ;
                }
            }
            // 题意超过六步就算是不符合要求
            int res = 10;
            //操作是涉及到位运算，32位足够表示所有的数字
            for (int op = 0; op < 32; op++) {
                backup = Arrays.copyOf(g, g.length);
                int step = 0;
                for (int i = 0; i < 5; i++) {
                    if ((op >> 1 & 1) > 0){
                        step++;
                    }
                }
            }
        }
    }
}
