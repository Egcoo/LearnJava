package InputStream02;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2022/7/22 - 10:48
 */
public class FileInputStream01 {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01(){
        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        int readData = 0;
        //外部定义，扩大作用域
        FileInputStream fileInputStream = null;
        try {
            // 创建 FileInputStream 对象，用于读取 文件
            fileInputStream =  new FileInputStream(filePath);
            // 从该输入流中读取一个字节的数据，如果没有输入可用，此方法将阻止
            // 如果返回 -1，表示读取完毕
            while ((readData = fileInputStream.read()) != -1){
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readFile02(){
        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        //int readData = 0;
        byte[] buf = new byte[8]; //一次读取 8 个字节.
        int readLen = 0;


        FileInputStream fileInputStream = null;
        try {
            // 创建 FileInputStream 对象，用于读取 文件
            fileInputStream =  new FileInputStream(filePath);

            //从该输入流读取最多 b.length 字节的数据到字节数组。 此方法将阻塞，直到某些输入可用。
            //如果返回-1 , 表示读取完毕
            //如果读取正常, 返回实际读取的字节数

            while ((readLen = fileInputStream.read(buf)) != -1){
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
