package TutorialClass.class2;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/2/28 - 21:00
 * <p>
 * 带分数，一个数字用整数 + 分数表示，其中 1-9只能使用一次
 * 1.枚举全排列
 * 2.枚举位数
 * 3.判断等式是否成立
 */
public class fraction {

    static int N = 10;
    static int target; // 所给出的目标数
    static int[] num = new int[N]; //保存全排列的结果
    static boolean[] used = new boolean[N]; //生成标记全排列的过程中是否使用过
    static int cnt = 0; // 计数，输出最后的结果

    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(bf.readLine());
        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int u) {
        // 把两层循环分成三段
        if (u == 9) {
            for (int i = 0; i < 7; i++) {
                for (int j = i + 1; j < 8; j++) {
                    int a = calc(0, i);
                    int b = calc(i + 1, j);
                    int c = calc(j + 1, 8);
                    // 注意判断条件，因为C++中除法是整除，所以要转化为加减乘来计算
                    if (a * c + b == c * target) {
                        cnt++;
                    }
                }
            }
            return;
        }

        //搜索模板
        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;//标记使用
                num[u] = i;
                dfs(u + 1);
                used[i] = false;//还原现场
            }
        }
    }

    // 计算一段数是多少
    public static int calc(int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res = res * 10 + num[i];
        }
        return res;
    }
}
