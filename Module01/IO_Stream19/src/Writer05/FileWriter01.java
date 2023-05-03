package Writer05;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2022/7/25 - 11:18
 */
// IO流的输入和输出是相对于硬盘来讲的，output是往硬盘里写东西
// 字节流和字符流区分的方法：字节流几乎都是动词，字符流都是名词
//
//
public class FileWriter01 {
    public static void main(String[] args) {

    }

    @Test
    public void WriteFile() {
        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter = new FileWriter(filePath);//默认是覆盖写入
            // 3) write(int):写入单个字符
            fileWriter.write('H');
            // 4) write(char[]):写入指定数组
            fileWriter.write(chars);
            // 5) write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(), 0, 3);
            // 6) write（string）：写入整个字符串
            fileWriter.write(" 你好北京~");
            fileWriter.write("风雨之后，定见彩虹");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
