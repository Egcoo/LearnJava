package TutorialClass.class2;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/3 - 12:09
 * <p>
 * 1.顺序无关，
 * 2.直接暴力搜索所有方案，按照该方案，对所有灯泡进行操作
 * 3.判断 --> 记录方案
 */
public class pilotBro {

    static int N = 4;
    static char[][] g = new char[N][N];

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g[i][j] = (char) Integer.parseInt(bf.readLine());
            }
        }

        for (int i = 0; i < 65535; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    
                }
            }
        }

    }

    public static int get(int x, int y) {
        return x * 4 + y;
    }
}
