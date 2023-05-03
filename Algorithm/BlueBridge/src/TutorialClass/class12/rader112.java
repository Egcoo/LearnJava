package TutorialClass.class12;

import java.io.*;
import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2023/3/26 - 15:57
 * <p>
 *     因为我们可以将所有区间都排个序,也就是按照每条线的终点坐标从小到大排序,
 *     那么我们只需要保存最近的雷达,如果说这个最近的雷达都无法访问这座小岛,那么我们就可以在a[i].r的位置上开辟一个新的雷达.
 * 1.先将所有端点按照右端点排序
 * 2.按照排序的顺序扫描每一个线段
 *  1）如果上一个点不在区间中，则选右端点
 *  2) 如果上一个点在区间中，则跳过
 */
public class rader112 {

    static int N = 1010;
    static int n, d;
    static Pair[] pair = new Pair[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s1 = bf.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        d = Integer.parseInt(s1[1]);

        boolean failed = false;
        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            if (y > d) {
                failed = true;
            } else {
                double len = Math.sqrt(d * d - y * y);
                double l = x - len;
                double r = x + len;
                pair[i] = new Pair(l, r);
            }
        }
        if (failed) {
            out.println("-1");
        } else {
            Arrays.sort(pair, 0, n);
            double end = pair[0].r;
            int res = 0;
            for (int i = 1; i < n; i++) {
                // 如果这个点的右边界是小于下一个点的左边界,大于就不用管
                if (end < pair[i].l) {
                    res++;
                    end = pair[i].r;
                }
            }
            out.println(res);
        }

        out.flush();
    }
}

class Pair implements Comparable<Pair> {
    double l, r;

    public Pair(double l, double r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Pair o) {
        // TODO 自动生成的方法存根
        return Double.compare(r, o.r);
    }
}