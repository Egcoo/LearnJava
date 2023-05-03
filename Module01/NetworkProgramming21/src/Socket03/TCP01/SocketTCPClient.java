package Socket03.TCP01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/10/2 - 10:58
 */
public class SocketTCPClient {
    public static void main(String[] args) throws IOException {

        //思路
        //1.连接服务器 （IP ，端口）
        //解读：连接本机的 9999 端口，如果连接成功，返回 socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回= " + socket.getClass());

        // 2.连接上后，生成socket ，通过socket.getOutputStream()
        // 得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 3.通过输出流，将数据写入数据通道
        outputStream.write("hello,world".getBytes());

        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");

    }
}
