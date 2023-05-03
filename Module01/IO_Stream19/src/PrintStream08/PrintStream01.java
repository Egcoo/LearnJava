package PrintStream08;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @ author Egcoo
 * @ date 2022/9/30 - 16:21
 */
public class PrintStream01 {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        //在默认情况下， PrintStream 输出数据的位置是 标准输出，即显示器
        out.println("hello,rose");

        out.write("无限进步".getBytes());
        // 必须要close 才能真正将内容写入，因为close 底层源码里才是 write方法
        out.close();


        //同时我们也可以修改打印输出流的位置/设备
        System.setOut(new PrintStream("C:\\Users\\Egcoo\\Desktop\\Download\\news5.txt"));
        System.out.println("人的现代性关系");


    }
}
