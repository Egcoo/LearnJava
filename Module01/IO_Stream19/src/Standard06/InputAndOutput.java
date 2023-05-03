package Standard06;

/**
 * @ author Egcoo
 * @ date 2022/9/29 - 8:42
 */
public class InputAndOutput {
    public static void main(String[] args) {

        //System 类的 public final static InputStream in = null;
        //编译类型 System.in InputStream
        //System.in 运行类型 BufferedInputStream
        System.out.println(System.in.getClass());


        // 2.编译类型 PrintStream
        // 3.运行类型 PrintStream
        // 表示标准输入 显示器
        System.out.println(System.out.getClass());

    }
}
