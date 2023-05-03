package properties08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @ author Egcoo
 * @ date 2022/7/27 - 11:40
 */
public class properties03 {
    public static void main(String[] args) throws IOException {
        //使用 Properties 类来创建 配置文件, 修改配置文件内容
        Properties properties = new Properties();
        //创建
        //1.如果该文件没有 key 就是创建
        //2.如果该文件有 key ,就是修

        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤姆");//注意保存时，是中文的 unicode 码值
        properties.setProperty("pwd", "888888");
        //将 k-v 存储文件中即可
        properties.store(new FileOutputStream("E:\\Java_Project\\Module01\\IO_Stream19\\src\\mysql2.properties"), null);
        System.out.println("保存配置文件成功~");
    }
}
