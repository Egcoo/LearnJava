package TutorialClass.class7;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/15 - 20:10
 * 算法
 * (枚举,模拟) O(104)
 * 由于只有八位数，而且回文串左右对称，因此可以只枚举左半边，这样只需枚举 0∼9999
 * 总共一万个数，然后判断：
 * 整个八位数构成的日期是否合法；
 * 是否在范围内
 * <p>
 * 时间复杂度
 * 一共枚举 10^4
 * 个数，判断每个数是否合法的计算量是常数级别的，因此总计算量是 O(104)。
 *
 * 月份等于0或者不合法，或者天数不合法
 * 月份不是2的时候，日期怎么处理
 * 月份是2的时候怎么处理，关于闰年的判断
 */

public class date466 {

    static int date1;
    static int date2;
    static int res;
    static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        date1 = Integer.parseInt(bf.readLine());
        date2 = Integer.parseInt(bf.readLine());

        for (int i = 0; i < 10000; i++) {
            int x = i;
            int r = i;
            // 这一步的目的是把那个回文8位数搞出来，这一步出来的所有都是回文的
            for (int j = 0; j < 4; j++) {
                r = r * 10 + x % 10;
                x /= 10;
            }

            // 判断这个数合不合法
            if (r >= date1 && r <= date2 && check(r)) {
                res++;
            }
        }
        out.println(res);
        out.flush();
    }

    //这个函数的作用是找出合法日期
    public static boolean check(int date) {
        int year = date / 10000;
        int month = date % 10000 / 100;
        int day = date % 100;

        // 月份等于0或者不合法，或者天数不合法
        if (month == 0 || month >= 13 || day == 0) {
            return false;
        }

        // 月份不等于2
        if (month != 2 && day > months[month]) {
            return false;
        }
        // 月份是2和闰年判断
        if (month == 2) {
            int leap = 0;
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                leap = 1;
            }
            if (day > 28 + leap) {
                return false;
            }
        }
        return true;
    }

}
