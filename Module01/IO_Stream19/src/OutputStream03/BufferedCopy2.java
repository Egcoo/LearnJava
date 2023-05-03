package OutputStream03;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2022/9/27 - 14:40
 */

// 从源文件路径拷贝到目标路径
public class BufferedCopy2 {
    public static void main(String[] args) {

        String srcFilePath = "C:\\Users\\Egcoo\\Desktop\\Download\\rose.jpg";
        String desFilePath = "C:\\Users\\Egcoo\\Desktop\\Download\\rose2.jpg";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(desFilePath));
            byte[] bt = new byte[1024];
            int readLen = 0;
            while ((readLen = bis.read(bt)) != -1) {
                bos.write(bt, 0, readLen);

            }
            System.out.println("文件拷贝完毕");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
