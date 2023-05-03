package Transform07;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ author Egcoo
 * @ date 2022/7/27 - 10:50
 */
public class PrintWriter03 {
    public static void main(String[] args) throws IOException {
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(
                new FileWriter("C:\\Users\\Egcoo\\Desktop\\Download\\news2.txt"));
        printWriter.print("hi, 北京你好~~~~");
        printWriter.close();//flush + 关闭流, 才会将数据写入到文件..

    }
}
