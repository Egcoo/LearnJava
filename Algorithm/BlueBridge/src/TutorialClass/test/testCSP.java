package TutorialClass.test;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2023/5/28 - 15:27
 */
public class testCSP {

    static int column = 8;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        int[] res = new int[n];
        String[] st = new String[n];
        for (int i = 0; i < n; i++) {
            st[i] = "";
            for (int j = 0; j < column; j++) {
                st[i] += bf.readLine();
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (st[i - 1].equals(st[j])) {
                    res[i - 1]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }

    }
}
