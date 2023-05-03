package Socket03.TCP01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/10/2 - 10:44
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1.在本机的 9999 端口监听，等待连接
        // 细节：要求在本机没有其他服务在监听9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个socket [多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在 9999 端口等待连接");

        //2. 当没有客户端连接9999 端口时，程序会阻塞，等待连接
        // 如果有客户端连接，则会返回socket 对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务器端socket = " + socket.getClass());

        //3.通过 socket.getInputStream() 读取客户端写入的数据，显示
        InputStream inputStream = socket.getInputStream();

        //4.IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        //5.关闭流
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
