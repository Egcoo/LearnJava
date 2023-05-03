package class7;

/**
 * @ author Egcoo
 * @ date 2023/1/18 - 15:49
 */
public class Queen {

    public static void main(String[] args) {

    }

    public static int num(int n) {
        if (n < 1) {
            return 0;
        }
        // record[0] ? record[1] ? record[2] ?
        int[] record = new int[n];
        return process1(0, record, n);
    }

    // record[0...i-1]的皇后，任何两个皇后一定都不共行，不共列，不共斜线
    // 目前来到了第 i 行
    // record[0...i-1] 表示之前的就行，放了皇后的位置
    // n代表的整体一共有多少行
    // 返回值是，摆完所有的皇后，合理的摆法有多少种

    public static int process1(int i, int[] record, int n) {
        // i == n-1 是最后一行，最后一行的下一行就是终止行
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            // 当前行在i行，尝试i行所有的列 -> j
            // 当前 i 行的皇后，放在j列，会不会和之前的皇后（0...i-1）的皇后，不共行共列或者共斜线
            // 如果是，认为无效
            // 如果不是，认为有效
            if (isVaild(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    // record[0...i-1] 你需要看，record[i....] 不需要看
    // 返回i行皇后，放在了j列，是否有效
    public static boolean isVaild(int[] record, int i, int j) {
        //这里不需要判断是否共行，只要在下一行，必不共行
        for (int k = 0; k < i; k++) {
            // 之前的某个k行的皇后 k ,record[k]  与 i,j
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}
