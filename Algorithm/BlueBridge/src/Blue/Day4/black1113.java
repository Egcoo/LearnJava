package Blue.Day4;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2023/4/5 - 13:22
 * <p>
 * 这里的求个数和 花束那题的最短路径还是有区别的，需要一些计算结果上的调整
 */
public class black1113 {

    static int N = 25;
    static int W, H;
    static char[][] g = new char[N][N];
    static int[][] dist = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] s = bf.readLine().split(" ");
            W = Integer.parseInt(s[0]);
            H = Integer.parseInt(s[1]);

            if (W == 0 && H == 0) {
                break;
            }
            for (int i = 0; i < H; i++) {
                g[i] = bf.readLine().toCharArray();
            }

            Pair start = null;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (g[i][j] == '@') {
                        start = new Pair(i, j);
                    }
                }
            }

            int cnt = bfs(start);
            out.println(cnt);
            out.flush();

        }
    }

    public static int bfs(Pair start) {
        // 初始化队列
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            Arrays.fill(dist[i], -1);
        }
        queue.offer(start);
        dist[start.x][start.y] = 0;
        int cnt = 1;
        // 建立起来一个方向上数组
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Pair t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                //判断是否越界
                if (x < 0 || x >= H || y < 0 || y >= W) {
                    continue;
                }
                //是否是遍历到了红瓷砖
                if (g[x][y] == '#') {
                    continue;
                }
                // 这块瓷砖是不是遍历过了
                if (dist[x][y] != -1) {
                    continue;
                }

                cnt++;
                dist[x][y] = 1;
                queue.offer(new Pair(x, y));
            }
        }
        return cnt;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}