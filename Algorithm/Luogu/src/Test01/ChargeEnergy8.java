package Test01;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/11/13 - 14:54
 */
public class ChargeEnergy8 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int pre = 0, p = 0, res = 0;
        String s = "";
        int u = 0, i = 0;
        int n = myScanner.nextInt();
        while (n > 0) {
            s = myScanner.next();
            u = myScanner.nextInt();
            i = myScanner.nextInt();
            int cur = SumTime(s);
            res += p * (cur - pre);
            pre = cur;
            p = u * i;

            n--;
        }

        System.out.println(res);
    }

    public static int SumTime(String s1) {
        char[] s = s1.toCharArray();
        int hour = (s[0] - '0') * 10 + (s[1] - '0');
        int minute = (s[3] - '0') * 10 + (s[4] - '0');
        int second = (s[6] - '0') * 10 + (s[7] - '0');
        return hour * 60 * 60 + minute * 60 + second ;
    }
}

/*
#define int long long

int n;
int last = 0, p = 0;	// 上次时间戳与功率
int ans = 0;

// 时间字符串转化为秒作为时间戳
int toSecond(string s) {
    int h = (s[0] - '0' + 0) * 10 + (s[1] - '0' + 0);
    int m = (s[3] - '0' + 0) * 10 + (s[4] - '0' + 0);
    int second = (s[6] - '0' + 0) * 10 + (s[7] - '0' + 0);
    return second + m * 60 + h * 60 * 60;
}

signed main() {
    string s;
    int u, i;
    cin >> n;
    while (n--) {
        cin >> s >> u >> i;
        int second = toSecond(s);
        ans += p * (second - last);
        last = second;
        p = u * i;
    }
    cout << ans << endl;
    return 0;
}


 */