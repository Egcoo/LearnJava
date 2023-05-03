package Socket03.TCPFIleCopy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/10/3 - 10:57
 */
public class Client {
    public static void main(String[] args) throws IOException {

        // 1.连接本机 8888 端口，连接成功，返回socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端返回：" + socket.getClass());

        // 2.客户端连接上以后，发送一张图片
        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\space.jpg";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(filePath.getBytes());

        // 3.设置结束标记
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

        //4.IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        // 5.客户端退出
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
