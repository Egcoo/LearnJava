package TutorialClass.class10;

import java.io.*;
import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/3/20 - 15:15
 * 深入理解计算机系统
 */


public class flower1101 {
    static int N = 210;
    static int T, n, m;
    static char[][] g = new char[N][N];
    static int[][] dist = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            String[] s = bf.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);

            for (int i = 0; i < n; i++) {
                g[i] = bf.readLine().toCharArray();
            }

            PII start = null;
            PII end = null;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
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
            out.flush();
        }

    }

    public static int bfs(PII start, PII end) {
        // 建立一个队列
        Queue<PII> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //将数组初始化为-1，表示不可到达
            Arrays.fill(dist[i], -1);
        }

        // 表示起点已经走过了，且距离起点为0
        dist[start.x][start.y] = 0;
        queue.offer(start);

        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};//四个方向
        while (!queue.isEmpty()) {
            PII t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                //如果越界
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                if (g[x][y] == '#') {
                    continue;
                }
                // 已经遍历过了
                if (dist[x][y] != -1) {
                    continue;
                }

                // 如果这个点可以走到，则这个点距离起点的距离是上一个点距离起点的距离 + 1;
                dist[x][y] = dist[t.x][t.y] + 1;
                if (end.x == x && end.y == y) {
                    return dist[x][y];
                }

                //然后将新的状态加入队尾
                queue.offer(new PII(x, y));
            }
        }
        return -1;
    }
}

class PII { //对应C++中的Pairs<int, int>
    int x; //每个点的横坐标
    int y;  //每个点的纵坐标

    public PII(int x, int y) {
        this.x = x;
        this.y = y;
    }
}