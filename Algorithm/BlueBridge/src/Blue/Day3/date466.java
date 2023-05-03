package Blue.Day3;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/3 - 16:46
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
            for (int j = 0; j < 4; j++) {
                r = r * 10 + x % 10;
                x /= 10;
            }
            if (r >= date1 && r <= date2 && check(r)) {
                res++;
            }
        }
        out.println(res);
        out.flush();
    }

    public static boolean check(int date) {
        int year = date / 10000;
        int month = date % 10000 / 100;
        int day = date % 100;

        //月份=0或者不合法或者天数不合法
        if (month == 0 || month > 13 || day == 0) {
            return false;
        }
        //月份不是2
        if (month != 2 && day > months[month]) {
            return false;
        }
        //闰年
        if (month == 2) {
            int leap = 0;
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                leap = 1;
            }
            if (day > 28 + leap) {
                return false;
            }
        }
        return true;
    }
}
