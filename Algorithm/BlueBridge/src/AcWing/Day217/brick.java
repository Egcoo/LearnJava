package AcWing.Day217;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/2/21 - 19:55
 * <p>
 * 阅读题目的时候画图很重要
 * 1.每个位置要么操作0次，要么操作1次，不可能操作两次，操作两次就等同于没有操作
 * 2.操作顺序无影响
 * 3.如果第一个砖块和我们的目标颜色相同的话，那就必然不能操作，反之就必须要操作一次，第一个操作次数是唯一确定的
 * 4.递推到最后只会操作n-1次
 */
public class brick {

    static int n;
    static String str;

    public static void Brick() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            n = scanner.nextInt();
            str = scanner.next();
            //两种方案都判断一下，能不能变成黑色或者白色
            if (!check('B') && !check('W')) {
                System.out.println();
                System.out.println(-1);
            }
        }
    }

    public static boolean check(char c) {
        String s = str;
        char[] chars = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<Integer>();
        //因为你一次性要搞两个所以中间的判断标准是 i+1
        for (int i = 0; i + 1 < n; i++) {
            //交换的时候要注意地址交换和值交换
            if (chars[i] != c) {
                chars[i] = update(chars[i]);
                chars[i + 1] = update(chars[i + 1]);
                list.add(i);
            }
        }
        if (chars[chars.length - 1] != c) {
            return false;
        } else {
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.print((list.get(i) + 1) + " ");
            }
            return true;
        }
    }

    public static char update(char c) {
        if (c == 'W') {
            return 'B';
        } else {
            return 'W';
        }
    }


    public static void main(String[] args) {
        Brick();
    }
}
