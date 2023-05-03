package Blue.Day4;

import java.io.*;
import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/4/4 - 16:02
 */
public class log1238 {

    static int N = 100010;
    static int n, d, k;
    static int[] score = new int[N];
    static boolean[] isHot = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        d = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        int[][] thumbup = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s1 = bf.readLine().split(" ");
            thumbup[i][0] = Integer.parseInt(s1[0]);
            thumbup[i][1] = Integer.parseInt(s1[1]);
        }

        Arrays.sort(thumbup, Comparator.comparingInt(x -> x[0]));
        for (int i = 0, j = 0; i < n; i++) {
            // 这一步是把 i 之前的不符合这个时间区间的数据剔除掉
            while (j < i && thumbup[i][0] - thumbup[j][0] > d - 1) {
                score[thumbup[j][1]]--;
                j++;
            }
            score[thumbup[i][1]]++;
            if (score[thumbup[i][1]] >= k) {
                isHot[thumbup[i][1]] = true;
            }

        }
        for (int i = 0; i < n; i++) {
            if (isHot[i]) {
                out.println(i);
            }

        }
        out.flush();
    }
}
