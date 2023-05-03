package reader04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2022/9/26 - 15:16
 */
public class BufferedReader02 {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        //创建 bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;
        //说明
        // 1.bufferedReader.readLine() 是按行读取
        // 2.当返回 null，文件表示读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流，这里只需要关闭最外部的流即可
        bufferedReader.close();
    }
}
