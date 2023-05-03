package TutorialClass.class7;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/3/17 - 15:08
 * 1.将所有时间转化成，距离当天 00：00：00 的秒
 * 2.首先，飞机飞过去，消耗的时间是(从china往usa加一个时差)   end-start+time
 * 然后，飞机从usa飞到china，然后减一个时差    end-start-time
 * 两式合并    end1-start1+end2—start2=2*t
 * t=(end1-start1+end2—start2)/2
 * 3. 时差是带正负的，这样可以更好理解
 */
public class plane1231 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            String s1 = bf.readLine();
            String s2 = bf.readLine();

            // 获取飞行时间
            int time = (get_time(s1) + get_time(s2)) / 2;
            int hour = time / 3600;
            int minute = time % 3600 / 60;
            int second = time % 60;

            System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
        }
    }

    public static int get_time(String t1) {
        if (t1.charAt(t1.length() - 1) != ')') {
            t1 += " (+0)";
        }
        // 一共会分成三部分
        String[] t2 = t1.split(" ");
        String[] t3 = t2[0].split(":");
        String[] t4 = t2[1].split(":");

        int h1 = Integer.parseInt(t3[0]);
        int m1 = Integer.parseInt(t3[1]);
        int s1 = Integer.parseInt(t3[2]);

        int h2 = Integer.parseInt(t4[0]);
        int m2 = Integer.parseInt(t4[1]);
        int s2 = Integer.parseInt(t4[2]);
        int d = t2[2].charAt(2) - '0';

        return get_second(h2, m2, s2) - get_second(h1, m1, s1) + d * 24 * 3600;
    }

    public static int get_second(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    // 我需要一段归并排序

}
