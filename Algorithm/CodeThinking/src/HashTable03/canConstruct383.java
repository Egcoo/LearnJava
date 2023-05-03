package HashTable03;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/8/18 - 18:15
 */
public class canConstruct383 {
    public static void main(String[] args) {
        canConstruct("aa", "ab");
        System.out.println();
    }

    //1.数组匹配
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
