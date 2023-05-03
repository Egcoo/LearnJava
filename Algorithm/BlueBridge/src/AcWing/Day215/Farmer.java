package AcWing.Day215;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/2/20 - 20:45
 * 1.暴力解法
 * 1)为了找到一个最小的k，枚举一下每个k是否满足条件
 * 2)枚举第一个子串
 * 3)枚举第二个子串
 * 4)看第一个和第二个子串是否相等
 * 搁置，看不懂
 * <p>
 * 2.二分法
 * 1）利用二段性将字符串分为 <ans不满足|| k || K>ans都满足 三部分，我们要找到那个k
 * 2）
 */
public class Farmer {

    public static void main(String[] args) {
        farm1();
    }

    static int N;
    static String str;

    public static void farm1() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        str = scanner.next();
        int l = 1;
        int r = N;
        while (l < r) {
            int mid = (l + r) / 2;
            //如果mid成立说明，长度为mid的子串只出现一次，那么>=mid的子串也成立
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(r);

    }

    public static boolean check(int mid) {
        HashSet<String> set = new HashSet<>();
        // 枚举一下每一个字符串
        for (int i = 0; i < N - mid + 1; i++) {
            String s = str.substring(i, mid+i);
            if (set.contains(s)) {
                //如果有重复的子串，直接return false
                return false;
            }else {
                set.add(s);
            }
        }

        return true;
    }


    public static void farm() {
        // 1.暴力解法
        //找到最小的不能满足找到与他一样的子串的子串即可
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = scanner.next();
        char[] chars = str.toCharArray();

        // 为什么这里的 k从1开始而且 <=N
        for (int k = 1; k <= N; k++) {
            //判断是不是存在两个相同的串
            boolean flag = false;
            //任何一个字符串最多有 N - k + 1 个子串（同等规模）
            for (int i = 0; i < N - k + 1; i++) {
                for (int j = i + 1; j < N - k + 1; j++) {
                    //这里判断两个串是不是完全相同
                    //如果相同，就不符合题意，直接退出
                    boolean same = true;
                    for (int l = 0; l < k; l++) {
                        if (chars[i + l] != chars[j + l]) {
                            same = false;
                            break;
                        }
                    }
                    //两个串相同
                    if (same) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            //如果找不到两个相同的子串，表示k是成立的，因为k是从小到大枚举的，第一个找到的k就是最小的
            if (!flag) {
                System.out.println(k);
                break;
            }
        }
    }

}
