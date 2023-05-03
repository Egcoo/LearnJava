package homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2022/7/27 - 11:53
 */
public class homework01 {
    public static void main(String[] args) throws IOException {

        // file.mkdirs 创建多级目录，如果创建单级目录，不加s 也是可以的

        String directoryPath = "C:\\Users\\Egcoo\\Desktop\\Download\\mytemp";
        // 这里只是new 出来一个对象
        File file = new File(directoryPath);
        if (!file.exists()) {
            //创建
            if (file.mkdirs()) {
                System.out.println("创建 " + directoryPath + " 创建成功");
            } else {
                System.out.println("创建 " + directoryPath + " 创建失败");
            }
        }

        String filePath = directoryPath + "\\hello.txt";
        File file1 = new File(filePath);
        if (!file.exists()) {
            //创建文件
            if (file.createNewFile()) {
                System.out.println(file + " 创建成功~");
                //如果文件存在,我们就使用 bufferedWriter 字符流写入内容.
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
                bufferedWriter.write("hello,world~");
                bufferedWriter.close();


            } else {
                System.out.println(file + " 创建失败 ");
            }
        } else {
            //如果文件已经存在,给出提示
            System.out.println(filePath + " 已经存在,不再重复创建");
        }
    }
}
