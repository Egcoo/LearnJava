package class11;

/**
 * @ author Egcoo
 * @ date 2023/2/6 - 16:39
 * 本题是字符串转换的 动态规划写法
 */
public class DP1pro {

    public static int reverse(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        // base case 可以理解为是[0...i-1]的部分已经转化完成，构成了一个正确的解法
        dp[N] = 1;

        for (int i = N - 1; i >= 0; i--) {
            // 如果 i 没有到终止位置，
            // 可以理解为上游的转换让下游转化不下去了，拿整个分支都无法转换
            if (str[i] == '0') {
                dp[i] = 0;
            }
            // str[i] 字符不是0
            if (str[i] == '1') {
                // i 自己作为单独的部分，后续有多少种方法
                dp[i] = dp[i + 1];
                if (i + 1 < str.length) {
                    // i 和 i+1 作为单独的部分，后续有多少种方法
                    dp[i] = dp[i + 2];
                }
            }
            if (str[i] == '2') {
                // i 自己作为单独的部分，后续有多少种方法
                dp[i] = dp[i + 1];
                // i 和 i+1 作为单独的部分 并且没有超过26 ，后续有多少种方法
                if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                    dp[i] = dp[i + 2];
                }
            }
        }
        return dp[0];
    }





    public static int process(char[] str, int i) {
        // base case 可以理解为是[0...i-1]的部分已经转化完成，构成了一个正确的解法
        if (i == str.length) {
            return 1;
        }

        // 如果 i 没有到终止位置，
        // 可以理解为上游的转换让下游转化不下去了，拿整个分支都无法转换
        if (str[i] == '0') {
            return 0;
        }
        // str[i] 字符不是0
        if (str[i] == '1') {
            // i 自己作为单独的部分，后续有多少种方法
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                // i 和 i+1 作为单独的部分，后续有多少种方法
                res += process(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            // i 自己作为单独的部分，后续有多少种方法
            int res = process(str, i + 1);
            // i 和 i+1 作为单独的部分 并且没有超过26 ，后续有多少种方法
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {

                res += process(str, i + 2);
            }
            return res;
        }

        // 问题是这里只有 1 和 2 位置是可以转化的，3-9是全然不可能两位数一起转化的
        // str[i] == '3' ~ '9'
        return process(str, i + 1);
    }
}
