package TutorialClass.class11;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2023/3/24 - 19:47
 *
 * 明白了，这里的无法遍历到的位置，如果是被包围的，直接就是遍历不到，搜索根本就是搜不到
 */
public class floor1113 {
    static int N = 25;
    static int n, m;
    static char[][] g = new char[N][N];
    static int[][] dist = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] s = bf.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);

            if (n == 0 && m == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                g[i] = bf.readLine().toCharArray();
            }
            Pair start = null;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
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
        // 建立一个队列
        Queue<Pair> queue = new LinkedList<>();
        //将数组初始化为-1，表示不可到达
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        dist[start.x][start.y] = 1;
        int count = 1;
        queue.add(start);
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};//四个方向
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                // 越界了
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                // 瓷砖是白的
                if (g[x][y] == '#') {
                    continue;
                }
                // 已经遍历过了
                if (dist[x][y] != -1) {
                    continue;
                }
                count++;
                dist[x][y] = 1;
                queue.add(new Pair(x, y));
            }
        }

        return count;
    }

}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}