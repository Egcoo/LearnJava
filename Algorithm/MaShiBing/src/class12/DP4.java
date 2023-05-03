package class12;

import java.util.HashMap;

/**
 * @ author Egcoo
 * @ date 2023/2/2 - 15:43
 * <p>
 * 暴力递归改动态规划成本是最低的
 * 边界条件：
 * 1.剩余字符串是空的 return 0；
 * 3.字符是“xyz” 而 我的字符是“abc” ， abc通过xyz来搞定的话还剩余abc
 */
public class DP4 {

    public static int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        // stickers -> [26] [26]
        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                map[i][c - 'a']++;
            }
        }

        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return process(dp, map, target);
    }

    //dp 傻缓存，如果t已经算过了，直接返回dp中的值
    //t 剩余的目标
    //0..N 每一个字符串所含字符的词频统计
    public static int process(HashMap<String, Integer> dp, int[][] map, String rest) {
        if (dp.containsKey(rest)) {
            return dp.get(rest);
        }

        // 以下就是正式的递归调用过程
        // ans -> 搞定rest，使用最少的贴纸数量
        int ans = Integer.MAX_VALUE;
        int n = map.length;
        int[] tmap = new int[26];
        char[] target = rest.toCharArray();
        for (char c : target) {
            target[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            // 这张贴纸必须包含target的一张字符才指的试试
            // 如果真存在最小方案，消去a的时刻前移后移是，插在中间还是做离散都不会影响
            if (map[i][target[0] - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tmap[j] > 0) {
                    for (int k = 0; k < Math.max(0, tmap[j] - map[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }

            String s = sb.toString();
            // 剩余字符串求一个后续的贴指数
            int tmp = process(dp, map, s);
            if (tmp == -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        dp.put(rest, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(rest);
    }

}
