package Blue.Day3;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/3 - 20:04
 */
public class date1229 {

    static int a, b, c;
    static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split("/");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);

        for (int i = 19600101; i < 20591231; i++) {
            int year = i / 10000;
            int month = i % 10000 / 100;
            int day = i % 100;

            if (check(year, month, day)) {
                if ((year % 100 == a && month == b && day == c) ||
                        (month == a && day == b && year % 100 == c) ||
                        (day == a && month == b && year % 100 == c)) {
                    System.out.printf("%d-%02d-%02d\n", year, month, day);
                }
            }

        }
    }

    public static boolean check(int year, int month, int day) {
        if (month == 0 || month >= 13 || day == 0) {
            return false;
        }
        if (month != 2 && day > months[month]) {
            return false;
        }
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
