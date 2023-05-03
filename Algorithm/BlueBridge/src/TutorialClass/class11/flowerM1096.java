package TutorialClass.class11;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2023/3/23 - 16:20
 */
public class flowerM1096 {
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
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            //现在要做的就是想去把这个三维的东西读入
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    g[i][j] = bf.readLine().toCharArray();
                }
                // 这是读入一个换行符
                bf.readLine();
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
            out.flush();
        }
    }

    public static int bfs(PIII start, PIII end) {
        //建立一个队列,设置数组初始化默认不可到达
        Queue<PIII> queue = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        //将起点初始化为0
        dist[start.x][start.y][start.z] = 0;
        queue.add(start);
        // 设置上下左右前后六个方向的数组
        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        while (!queue.isEmpty()) {
            PIII p = queue.poll();
            //如果到达终点
            for (int i = 0; i < 6; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                int z = p.z + dz[i];

                // 如果越界
                if (x < 0 || x >= L || y < 0 || y >= R || z < 0 || z >= C) {
                    continue;
                }
                if (g[x][y][z] == '#') {
                    continue;
                }

                if (dist[x][y][z] != -1) {
                    continue;
                }
                dist[x][y][z] = dist[p.x][p.y][p.z] + 1;
                if (end.x == x && end.y == y && end.z == z) {
                    return dist[x][y][z];
                }

                // 将新状态加入队尾
                queue.add(new PIII(x, y, z));
            }
        }

        return -1;

    }
}

class PIII {
    //对应三维坐标
    int x, y, z;
    public PIII(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}