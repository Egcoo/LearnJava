package AcWing.Day222;

import java.io.*;
import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/2/27 - 20:55
 */
public class hashTable {
    static int N;
    static HashSet<Integer> hashSet = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {
        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //N = Integer.parseInt(bf.readLine());
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        while (N-- > 0) {
            //String s = bf.readLine();
            String s = scanner.next();
            //int i = Integer.parseInt(bf.readLine());
            int i  = scanner.nextInt();

            if (s.equals("I")) {
                hashSet.add(i);
            } else {
                if (hashSet.contains(i)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
