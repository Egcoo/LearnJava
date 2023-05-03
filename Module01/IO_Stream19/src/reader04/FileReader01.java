package reader04;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2022/9/25 - 10:38
 */

public class FileReader01 {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        FileReader fileReader = null;
        int data = 0;

        try {
            fileReader = new FileReader(filePath);
            //循环读取，使用 read
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println("读取成功");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    @Test
    public void readFile() {
        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        FileReader fileReader = null;
        char[] data = new char[8];
        int readLen = 0;

        try {
            fileReader = new FileReader(filePath);
            //循环读取，使用 read(数组) ，返回的是实际读到的字符数
            //如果返回-1，说明文件结束

            while ((readLen = fileReader.read(data)) != -1) {
                System.out.print(new String(data, 0, readLen));
            }
            System.out.println("读取成功");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //操作结束的时候一定要关闭流，或者刷新，不然信息无法进入到文件里
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
