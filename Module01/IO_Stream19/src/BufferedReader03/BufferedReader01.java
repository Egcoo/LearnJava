package BufferedReader03;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @ author Egcoo
 * @ date 2022/7/25 - 16:39
 */
//处理流包装节点流，既可以消除不同节点流之间的差异，也可以提供更便捷的方法来实现输入输出。
// 处理流（包装流）性能主要体现在以下两个方面
// 1.性能的提高：主要以增加缓冲的方式来提高输入输出的效率
// 2.操作的便捷：处理流可能提供了一系列的方法来一次性输入输出大批量的数据，使用更加灵活方便

public class BufferedReader01 {
    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        //创建 bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        //读取
        String line; //按行读取, 效率高
        //说明
        //1. bufferedReader.readLine() 是按行读取文件
        //2. 当返回 null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流,这里注意,只需要关闭 BufferedReader ,因为底层会自动去关闭 节点流

        /*
        public void close () throws IOException {
            synchronized (lock) {
                if (in == null)
                    return;
                try {
                    in.close();//in 就是我们传入的 new FileReader(filePath), 关闭了.

                    } finally {
                    in = null;
                    cb = null;
                }
            }
        }
        */


        bufferedReader.close();
    }
}
