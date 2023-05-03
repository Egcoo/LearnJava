package Blue.Day4;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2023/4/4 - 19:17
 */
public class flower1101 {

    static int N = 210;
    static int T, R, C;
    static char[][] g = new char[N][N];
    static int[][] dist = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bf.readLine());
        while (T-- > 0) {
            String[] s = bf.readLine().split(" ");
            R = Integer.parseInt(s[0]);
            C = Integer.parseInt(s[1]);
            for (int i = 0; i < R; i++) {
                g[i] = bf.readLine().toCharArray();
            }

            PII start = null;
            PII end = null;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (g[i][j] == 'S') {
                        start = new PII(i, j);
                    } else if (g[i][j] == 'E') {
                        end = new PII(i, j);
                    }
                }
            }

            int distance = bfs(start, end);
            if (distance == -1) {
                out.println("oop!");
            } else {
                out.println(distance);
            }
        }

        out.flush();
    }

    // bfs主要还是基于队列
    //1. 是否越界
    //2. 是否已经遍历过了
    //3. 是否是边界
    //4. 更新你当前遍历的值的状态
    //5. 然后将新的状态加入队尾
    //6. 满足你的条件就结束
    public static int bfs(PII start, PII end) {
        Queue<PII> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[start.x][start.y] = 0;
        queue.offer(start);
        // 四个方向
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            PII t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                if (x < 0 || x >= R || y < 0 || y >= C) {
                    continue;
                }
                if (dist[x][y] != -1) {
                    continue;
                }
                if (g[x][y] == '#') {
                    continue;
                }
                // 如果这个点可以走到，则这个点距离上一个点的距离就要 + 1
                dist[x][y] = dist[t.x][t.y] + 1;
                if (x == end.x && y == end.y) {
                    return dist[x][y];
                }
                // 然后将新的状态加入到队尾
                queue.offer(new PII(x, y));
            }
        }
        return -1;
    }
}

class PII {
    int x;
    int y;

    public PII(int x, int y) {
        this.x = x;
        this.y = y;
    }
}