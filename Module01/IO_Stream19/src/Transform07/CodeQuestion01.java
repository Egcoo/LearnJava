package Transform07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2022/7/27 - 9:34
 */
public class CodeQuestion01 {
    public static void main(String[] args) throws IOException {

        //读取 "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt" 文件到程序
        //思路
        //1. 创建字符输入流 BufferedReader [处理流]
        //2.使用 bufferedReader 对象读取
        //3, 默认情况下 ,读取文件是按照 utf-8 编码

        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String s = br.readLine();
        System.out.println("读取到的内容:" + s);
        br.close();

    }
}
