package Transform07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ author Egcoo
 * @ date 2022/9/29 - 13:42
 */

//演示使用 InputStreamReader 转换流解决中文乱码问题
// 将字节流 FileInputStream 转成字符流 InputStreamReader , 可以指定编码 gbk/utf-8

public class InputStreamReader02 {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news3.txt";
        // 1.把FileInputStream -> InputStreamReader
        // 2.指定编码gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");
        //传入BufferedReader
        BufferedReader bff = new BufferedReader(isr);

        // 4.读取
        String s = bff.readLine();
        System.out.println(s);
        // 5.关闭外层流
        bff.close();

    }
}
