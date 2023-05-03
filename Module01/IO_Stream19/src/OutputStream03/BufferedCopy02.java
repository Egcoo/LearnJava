package OutputStream03;

import java.io.*;

/**
 * @ author Egcoo
 * @ date 2022/7/26 - 10:51
 */
public class BufferedCopy02 {
    public static void main(String[] args) {

        String srcFilePath = "C:\\Users\\Egcoo\\Desktop\\Download\\lijie2.jpg";
        String destFilePath = "C:\\Users\\Egcoo\\Desktop\\Download\\rose2.jpg";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            //循环读取的文件,并写入到 destFilePath
            byte[] buff = new byte[1024];
            int readLen = 0;
            //当返回 -1 时,就表示文件读取完毕
            while ((readLen = bis.read(buff)) != -1){
                bos.write(buff,0,readLen);
            }
            System.out.println("文件拷贝完毕");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bis != null){
                    bis.close();
                }
                if (bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}
