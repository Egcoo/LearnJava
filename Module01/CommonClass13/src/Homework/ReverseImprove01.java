package Homework;

/**
 * @ author Egcoo
 * @ date 2022/7/2 - 11:55
 */
public class ReverseImprove01 {
    public static void main(String[] args) {

        //测试
        String str = "abcdef";
        System.out.println("===交换前===");
        System.out.println(str);
        try {
            str = reverse(str,0,0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("===交换后===");
        System.out.println(str);
    }

    //利用索引进行交换赋值,例如交换 bcde
    //例如：abcdef -> aecdbf -> aedcbf
    //
    //
    //
    public static String reverse(String str, int start, int end) {
        /*
        1.对输入的参数做一个验证
        一个重要的编程技巧！！！
        （1）写出正确的情况
        （2）然后取反即可
        （3）这样写，你的思路就不会乱
         */
        if (!(str != null && start >= 0 && end > start && end < str.length())) {
            throw new RuntimeException("参数不正确");
        }

        char[] chars = str.toCharArray();
        char temp = ' ';//交换辅助变量
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }
}
