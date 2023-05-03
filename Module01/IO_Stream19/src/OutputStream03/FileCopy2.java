package OutputStream03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2022/9/25 - 9:41
 */
public class FileCopy2 {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\car.png";
        String desFilePath = "C:\\Users\\Egcoo\\Desktop\\Download\\car2.png";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(desFilePath);
            //创建数组用于读取
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buf)) != -1) {
                //读入就写入到文件
                //即为一边读一边写
                fileOutputStream.write(buf, 0, len);
            }

            System.out.println("创建成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
