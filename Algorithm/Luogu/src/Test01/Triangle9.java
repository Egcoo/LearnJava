package Test01;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/11/13 - 15:27
 */
public class Triangle9 {
    static int m = 0, n = 0;
    static int len;

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //int m = 0, n = 0;
        String[] a = new String[15];
        int ans = 0;
        //int len;
        //cin >> m >> n;
        m = myScanner.nextInt();
        n = myScanner.nextInt();
        for (int i = 0; i < m; i++)
            a[i] = myScanner.next();
        for (len = Math.min(m, n); len >= 2; len--) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans += (check(i, j, 1, 0) & check(i, j, 0, 1) & check(i + len - 1, j, -1, 1));
                    ans += (check(i, j, 1, 0) & check(i, j, 0, -1) & check(i + len - 1, j, -1, -1));
                    ans += (check(i, j, -1, 0) & check(i, j, 0, 1) & check(i - len + 1, j, 1, 1));
                    ans += (check(i, j, -1, 0) & check(i, j, 0, -1) & check(i - len + 1, j, 1, -1));
                }
            }
        }
        System.out.println(ans);

    }

    public static int check(int i, int j, int iadd, int jadd) {
        char[][] a = new char[i][j];
        char ch = a[i][j];
        for (int k = 0; k < len - 1; k ++) {
            i += iadd;
            j += jadd;
            if (i < 0 || i >= m || j < 0 || j >= n) return 0;
            if (ch != a[i][j]) return 0;
        }
        return 1;
    }
}

/*
#include <bits/stdc++.h>
using namespace std;
const int N = 15;

int m, n;
string a[N];
int ans = 0;
int len;

// 检查：从 [i][j] 开始的 len 个字符是否一致，iadd 与 jadd 分别表示 i 与 j 每一步的偏移量
bool check(int i, int j, int iadd, int jadd) {
    char ch = a[i][j];
    for (int k = 0; k < len - 1; k ++) {
        i += iadd;
        j += jadd;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (ch != a[i][j]) return false;
    }
    return true;
}

int main() {
    cin >> m >> n;
    for (int i = 0; i < m; i ++)
        cin >> a[i];
    // 枚举长度
    for (len = min(m, n); len >= 2; len --) {
	    // 枚举顶点
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                // 顶点在左上
                ans += (check(i, j, 1, 0) && check(i, j, 0, 1) && check(i + len - 1, j, -1, 1));
                // 顶点在右上
                ans += (check(i, j, 1, 0) && check(i, j, 0, -1) && check(i + len - 1, j, -1, -1));
                // 顶点在左下
                ans += (check(i, j, -1, 0) && check(i, j, 0, 1) && check(i - len + 1, j, 1, 1));
                // 顶点在右下
                ans += (check(i, j, -1, 0) && check(i, j, 0, -1) && check(i - len + 1, j, 1, -1));
            }
        }
    }
    cout << ans << endl;
    return 0;
}


 */