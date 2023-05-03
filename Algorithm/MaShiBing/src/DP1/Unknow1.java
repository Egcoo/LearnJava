package DP1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2023/1/20 - 15:57
 */
public class Unknow1 {


    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process(str, 0, ans, path);
        return ans;
    }

    //寻找其子串(如果寻找不重复的子串，就把 list 换成 hashSet)
    // str固定，不变
    // index 此时来到的位置，要 or 不要
    // 如果index 来到了str的终止位置，把沿途路径所形成的答案，放入ans中
    // 之前做出的选择，就是path
    public static void process(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process(str, index + 1, ans, path);
        String yes = path + String.valueOf(str[index]);
        process(str, index + 1, ans, yes);

    }

    // 用递归实现所有的字符串所有的排列

    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process1(chs, 0, res);
        return res;
    }

    // str[0...i-1] 已经做好决定
    // str[i...] 都有机会来到i位置
    // i 终止位置，str当前的样子，就是一种结果 -> ans
    public static void process1(char[] str, int i, ArrayList<String> ans) {
        if (i == str.length) {
            ans.add(String.valueOf(str));
        }
        for (int j = 0; j < str.length; j++) {
            swap(str, i, j);
            process1(str, i + 1, ans);
            swap(str, i, j);
        }
    }

    public static void swap(char[] str, int i, int j) {

    }
}
