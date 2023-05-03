package Blue.contest12;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/5 - 14:51
 */
public class time3416 {

    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(bf.readLine());

        n = n / 1000 % 86400;
        int hour = (int) (n / 3600);
        int minute = (int) (n % 3600 / 60);
        int second = (int) (n % 3600 % 60);

        System.out.printf("%02d:%02d:%02d", hour, minute, second);
    }
}
