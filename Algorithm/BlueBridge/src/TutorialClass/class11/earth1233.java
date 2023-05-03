package TutorialClass.class11;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2023/3/24 - 14:14
 * 分析的时候分两步走（怎么统计所有块的数量 + 限制）：1.有多少个连通块 2.多少个会被淹没
 */
public class earth1233 {

    static int N = 1010;
    static int n;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            g[i] = bf.readLine().toCharArray();
        }
        // 遍历统计所有单元的数量和边界的数量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!st[i][j] && g[i][j] == '#') {
                    if (bfs(i, j)) {
                        cnt++;
                    }
                }
            }
        }
        out.println(cnt);
        out.flush();
    }

    public static boolean bfs(int x, int y) {
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(x, y));
        st[x][y] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int total = 0;
        int bound = 0;
        while (!queue.isEmpty()) {
            pair p = queue.poll();
            total++;
            // 判断陆地是否被淹没
            boolean is_bound = false;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                // 如果越界
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                // 如果遍历过
                if (st[nx][ny]) {
                    continue;
                }
                //如果是边界
                if (g[nx][ny] == '.') {
                    is_bound = true;
                    continue;
                }
                // 加入新的值
                queue.add(new pair(nx, ny));
                st[nx][ny] = true;
            }

            if (is_bound) {
                bound++;
            }
        }
        return total == bound;
    }
}

class pair {
    int x, y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}