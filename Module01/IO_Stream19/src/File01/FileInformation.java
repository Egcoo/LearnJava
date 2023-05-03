package File01;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @ author Egcoo
 * @ date 2022/9/24 - 9:33
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info(){
        //先创建文件
        File file = new File("C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt");

        //调用相应方法，得到对应信息
        System.out.println("文件名字=" + file.getName());
        //文件绝对路径
        System.out.println("文件绝对路径 = " + file.getAbsolutePath());
    }

    //无思想，只是单纯的api 的调用
    //
    // file.mkdir 是创建一级目录，file.mkdirs 是创建多级目录
    //


}
