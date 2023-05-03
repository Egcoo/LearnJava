package Blue.Day4;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2023/4/5 - 13:59
 */
public class master1096 {

    static int N = 110;
    static int L, R, C;
    static char[][][] g = new char[N][N][N];
    static int[][][] dist = new int[N][N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] s = bf.readLine().split(" ");
            L = Integer.parseInt(s[0]);
            R = Integer.parseInt(s[1]);
            C = Integer.parseInt(s[2]);

            if (L == 0 && R == 0 && C == 0) break;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    g[i][j] = bf.readLine().toCharArray();
                }
            }

            PIII start = null;
            PIII end = null;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (g[i][j][k] == 'S') {
                            start = new PIII(i, j, k);
                        } else if (g[i][j][k] == 'E') {
                            end = new PIII(i, j, k);
                        }
                    }
                }
            }

            int distance = bfs(start, end);
            if (distance == -1) {
                out.println("Trapped!");
            } else {
                out.println("Escaped in " + distance + " minute(s).");
            }
        }
    }

    public static int bfs(PIII start, PIII end) {
        Queue<PIII> queue = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        queue.offer(start);
        dist[start.x][start.y][start.z] = 0;
        // 设置六个方向的坐标数组
        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        while (!queue.isEmpty()) {
            PIII t = queue.poll();
            for (int i = 0; i < 6; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                int z = t.z + dz[i];
                if (x < 0 || x >= L || y < 0 || y >= R || z < 0 || z >= C) {
                    continue;
                }
                if (g[x][y][z] == '#') {
                    continue;
                }
                if (dist[x][y][z] != -1) {
                    continue;
                }
                dist[x][y][z] = dist[t.x][t.y][t.z] + 1;
                if (x == end.x && y == end.y && z == end.z) {
                    return dist[x][y][z];
                }
                queue.offer(new PIII(x, y, z));
            }
        }

        return -1;
    }
}

class PIII {
    int x, y, z;

    public PIII(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}