package Hashtable05;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author Egcoo
 * @ date 2022/8/5 - 18:45
 * 389. 找不同
 * <p>
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * 例子:
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 */

//使用map 来记录，<字符，出现的次数> , 一共遍历两次，第一次遍历 s 只是为了记录，
//等到遍历t的时候就是为了查找，每遍历到一个相同的字符，次数都 -1
//当遍历到一个 没有见过的字符（map里没有），输出
//或者在 <a字符 , 0> 的时候，又遍历到了 a字符， 也输出

public class findTheDifference {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c1 : s.toCharArray()) {
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) + 1);
                continue;
            }
            map.put(c1,1);
        }

        for (char c2 : t.toCharArray()) {
            //在 c1 中从未出现此字母
            if (!map.containsKey(c2)){
                return c2;
            }
            if (map.get(c2) == 0){
                return c2;
            }

            int newNUm = map.get(c2) - 1;
            map.put(c2,newNUm);
        }
        return 0;
    }

    //解法2 ： 字符串的替换方法
    //遍历s中的每一个字母 ， 将其在 t 中替换为空，t最后只剩一个字母
    public char findTheDifference1(String s, String t) {
        //需要使用一个包装类
        for (Character c : s.toCharArray()) {
            t = t.replaceFirst(c.toString(), "");
        }
        return t.toCharArray()[0];
    }

    //3.使用ASCII 码对应
    public char findTheDifference2(String s, String t) {
        int sSum = 0;
        int tSum = 0;
        for (char c : s.toCharArray()) {
            sSum += c;
        }
        for (char c : t.toCharArray()) {
            tSum += c;
        }

        return (char) (tSum - sSum);
    }

    //解法4：使用异或
    public char findTheDifference3(String s, String t) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return (char) result;
    }
}
