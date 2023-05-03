package Homework;

import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2022/7/2 - 10:30
 */
public class ReverseString01 {
    public static void main(String[] args) {
        //将字符指定位置进行反转，比如将 abcdef 转换成 aedcbf
        //思路分析
        //1.需要用到索引下标
        //2.先截取，完了再转成字符数组，后利用循环将其反转负值，
        // 最后使用StringBuffer 的方法直接拼接。
        //
        //

        String s1 = "abcdef";
        String reverse = reverse(s1, 1, 5);

        System.out.println("==========交换后的字符========");
        System.out.println(reverse);

    }

    public static String reverse(String str, int start, int end) {
        //1.先将字符串要反转的部分截取
        String substring = str.substring(start, end);
        //2.将截取的部分拆分成单个的字符
        char[] chars = substring.toCharArray();
        //3.字符数组复制，后利用循环将其反转负值
        char[] chars1 = Arrays.copyOf(chars, chars.length);
        for (int i = 0; i < chars.length; i++) {
            chars1[i] = chars[chars.length - 1 - i];
        }
        //4.将 char数组重新转回字符串
        String s = String.valueOf(chars1);
        //5.将 str 转换成StringBuffer ，为了使用StringBuffer的 replace替代方法
        StringBuffer stringBuffer = new StringBuffer(str);
        //6.用完以后，再将其转换为String，或则和减少使用内敛变量，直接输出也可

        //String replace = String.valueOf(stringBuffer.replace(start, end, s));

        return String.valueOf(stringBuffer.replace(start, end, s));
    }
}
