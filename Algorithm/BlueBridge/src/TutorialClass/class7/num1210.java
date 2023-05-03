package TutorialClass.class7;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/14 - 15:35
 * <p>
 * 1.这里的排列等价于没有重复取值
 * 2.连号区间 <==> Max-Min = b-a
 * 3.f
 */
public class num1210 {

    static int N = 10010;
    static int n;
    static int[] p = new int[N];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                max = Math.max(max, p[j]);
                min = Math.min(min, p[j]);

                if (max - min == j - i){
                    ans++;
                }
            }
        }
        out.println(ans);
        out.flush();
    }
}
