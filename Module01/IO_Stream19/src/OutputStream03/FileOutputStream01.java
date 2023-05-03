package OutputStream03;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2022/9/24 - 11:47
 */
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    /*
    演示使用 FileOutputStream 将数据写入到文件中，如果不存在，先创建文件
    1.fileOutputStream = new FileOutputStream(filePath); 写入内容会覆盖原先内容
    fileOutputStream = new FileOutputStream(filePath，true); 写入方式是追加而非覆盖
     */
    @Test
    public void writeFile(){
        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filePath);
            //写入一个字节
            fileOutputStream.write('h');
            //写入字符串
            String str = "晒太阳";
            fileOutputStream.write(str.getBytes());
            //str.getBytes() 可以把字符串-》字符数组

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
