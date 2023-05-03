package HashTable03;

/**
 * @ author Egcoo
 * @ date 2022/8/17 - 17:13
 */
public class isAnagram242 {

    // 1.哈希表 之字典解法
    public boolean isAnagram5(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int count : record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    //1.数组对比法
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


    // 这个写法超出了运行时间限制 
    public boolean isAnagram1(String s, String t) {

        int[] record = new int[26];
        for (int i = 0; i < s.toCharArray().length; i++) {
            record[s.toCharArray()[i] - 'a'] += 1;
        }
        for (int i = 0; i < t.toCharArray().length; i++) {
            record[t.toCharArray()[i] - 'a'] -= 1;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
