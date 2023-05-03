package socket02.TCPFileCopy;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/7/31 - 9:27
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端 socket 返回= " + socket.getClass());

        //1.创建读取磁盘文件的输入流
        String FilePath = "C:\\Users\\Egcoo\\Desktop\\Download\\lijie2.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FilePath));
        //bytes 就是 FilePath 对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //2.通过 socket 获取到输入流,将 byte 数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes); //将文件对应的字节数组写入到数据通道
        bis.close();
        socket.shutdownOutput();//设置写入数据的结束标志,非常重要,否则服务器端就会出现卡顿

        //====================================================


        //3.接受从服务端发回的消息
        InputStream inputStream = socket.getInputStream();
        //使用 StreamUtils 的方法,直接将 inputStream  读取到的内容 转成字符串
        String string = StreamUtils.streamToString(inputStream);
        System.out.println(string);

        //关闭相关的流
        inputStream.close();
        bos.close();
        socket.close();

    }
}
