package Test01;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/11/13 - 14:30
 * 输入一个由小写英文字母组成的字符串，请将其中的元音字母（a, e, i, o, u)转换成大写，其它字母仍然保持小写。
 * 输入格式
 * 　　输入一行包含一个字符串。
 * 输出格式
 * 　　输出转换后的字符串。
 * 样例输入
 * lanqiao
 * 样例输出
 * lAnqIAO
 */
public class ToUpperCase07 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String s1 = myScanner.next();

        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a'){
                chars[i] = 'A';
            }
            if (chars[i] == 'e'){
                chars[i] = 'E';
            }
            if (chars[i] == 'i'){
                chars[i] = 'I';
            }
            if (chars[i] == 'o'){
                chars[i] = 'O';
            }
            if (chars[i] == 'u'){
                chars[i] = 'U';
            }
        }
        System.out.println(chars);

    }


//    bool check(char ch) {
//        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
//    }
//
//    int main() {
//        string s;
//        cin >> s;
//        for (char &ch : s) {
//            if (check(ch))
//                ch = toupper(ch);
//        }
//        cout << s << endl;
//        return 0;
//    }

}
