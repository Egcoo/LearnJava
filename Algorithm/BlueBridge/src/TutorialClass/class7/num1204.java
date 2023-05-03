package TutorialClass.class7;

import java.io.*;
import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/3/15 - 16:16
 */
public class num1204 {

    //1、通过对输入的编号进行排序
    //
    //2、从小到大遍历
    //（1）由于重号只会出现一个，因此当a[i] == a[i - 1]时，a[i]表示重号
    //（2）由于断号只会出现一个，因此一定会空缺一个数，则当a[i] == a[i - 1] + 2时，a[i] - 1表示断号
    static int N = 100010;
    static int n;
    static int[] a = new int[N];
    static int k = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());

        while (n-- > 0) {
            String[] s = bf.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                a[k++] = Integer.parseInt(s[i]);
            }
        }

        Arrays.sort(a, 0, k);
        //断号
        int res1 = -1;
        //重号
        int res2 = -1;
        for (int i = 1; i < k; i++) {
            if (a[i] == a[i - 1]) {
                res2 = a[i];
            }
            if (a[i] >= a[i - 1] + 2) {
                res1 = a[i] - 1;
            }
        }

        out.println(res1 + " " + res2);
        out.flush();
    }

    //1、开一个数组f[]记录i数字是否出现过
    //
    //2、由于重号只有一个，则输入所有数时，若f[i]为true，则表示该数为重号
    //
    //3、由于断号只有一个，则从最小值minv遍历到最大值maxv，若f[i]为false，则表示该数为断号
    static boolean[] st = new boolean[N];

    // 方法2
    public static void test() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        int res1 = 0, res2 = 0;

        while (n-- > 0) {
            String[] s = bf.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                a[k] = Integer.parseInt(s[i]);
                if (st[a[k]]) {
                    res1 = a[k];
                } else {
                    st[a[k]] = true;
                }
                k++;
            }
        }

        int start = 0;
        while (!st[start]) {
            start++;
        }
        for (int i = start; i < st.length ; i++) {
            if (!st[i]){
                res2 = i;
                break;
            }
        }
        out.println(res1 + " " + res2);
        out.flush();

    }
}
