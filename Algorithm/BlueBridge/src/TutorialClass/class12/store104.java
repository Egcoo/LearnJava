package TutorialClass.class12;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/25 - 15:06
 * <p>
 * 仓库到所有商店的距离综合是最小,集合分组模型
 */
public class store104 {

    static int N = 100010;
    static int n;
    static long res;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");

        int[] des = new int[n];
        for (int i = 0; i < n; i++) {
            des[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(des, 0, n);
        int c = des[n / 2];

        for (int i = 0; i < n; i++) {
            res += Math.abs(des[i] - c);
        }
        out.println(res);
        out.flush();
    }
}
