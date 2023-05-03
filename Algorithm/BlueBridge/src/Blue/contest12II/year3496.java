package Blue.contest12II;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/4/6 - 15:38
 */
public class year3496 {

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = 5;
        int year;
        while (n-- > 0) {
            year = Integer.parseInt(bf.readLine());
            int n1 = year / 1000;
            int n2 = year / 100 % 10;
            int n3 = year % 100 / 10;
            int n4 = year % 10;

            if (n1 == n3 && n4 - n2 == 1){
                cnt++;
            }
        }
        out.println(cnt);
        out.flush();
    }
}
