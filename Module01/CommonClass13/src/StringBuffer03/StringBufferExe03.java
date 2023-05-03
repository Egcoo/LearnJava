package StringBuffer03;

/**
 * @ author Egcoo
 * @ date 2022/6/30 - 10:42
 */
public class StringBufferExe03 {
    public static void main(String[] args) {

        /*
        要求：价格的小数点前面的每三位用逗号隔开，再输出

        思路分析
        1.定义一个 Scanner 对象，接受用户输入价格（String）
        2.希望使用到 StringBuffer 的 insert，需要将 String 转换成 StringBUffer
        3.然后使用相关方法进行字符串的处理
         */

//        Scanner myScanner = new Scanner(System.in);

        String price = "87654321.56";
        StringBuffer sb = new StringBuffer(price);
        //先找到小数点，然后在该位置的前三位插入 insert 即可
        /*
        int i = sb.lastIndexOf(".");
        sb = sb.insert(i-3,",");

         */
        for (int i = sb.lastIndexOf(".") - 3; i > 0; i -= 3) {
            sb = sb.insert(i,",");
        }

        System.out.println(sb);
    }
}
