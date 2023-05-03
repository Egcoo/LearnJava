package TutorialClass.class10;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ author Egcoo
 * @ date 2023/3/19 - 21:01
 */
public class isHot1238 {

    static int n, d, k;
    static final int N = 100010;
    static boolean[] isHot = new boolean[N];
    static int[] score = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        d = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        int[][] thumbup = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] arr1 = bf.readLine().split(" ");
            thumbup[i][0] = Integer.parseInt(arr1[0]);
            thumbup[i][1] = Integer.parseInt(arr1[1]);
        }

        //Arrays.sort(thumbup, (x, y) -> x[0] - y[0]);
        Arrays.sort(thumbup, Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(thumbup[i][j]);
            }
        }

        // j 循环要做的就是时间段的划分，保证当前的划分要求一定是满足 [T, T+D)
        // while 循环用于修正划分，将D调节到满足 [T, T+D) 的区间内
        // score[thumbup[j][1]]-- 目的是把不属于这个时间段内的数据剔除
        // 若时间不满足要求，j会向前移动找到下一个满足要求的划分，并退回之前的cnt，也就是score[thumbup[j][1]]--
        for (int i = 0, j = 0; i < n; i++) {
            while (j < i && thumbup[i][0]- thumbup[j][0] > d - 1) {
                score[thumbup[j][1]]--;
                j++;
            }
            score[thumbup[i][1]]++;
            if (score[thumbup[i][1]] >= k) {
                isHot[thumbup[i][1]] = true;
            }
        }


        for (int i = 0; i < N; i++) {
            if (isHot[i]) {
                System.out.println(i);
            }
        }
    }
}
