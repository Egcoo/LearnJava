package Socket03.TCPFIleCopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/10/3 - 10:57
 */
public class Server {
    public static void main(String[] args) throws IOException {

        //1.编写一个服务端，在 8888 端口监听
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在 8888 端口等待连接.....");

        // 2.没有客户端连接，程序会阻塞，
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());

        //3. 服务端接受图片
        // 通过 socket.getInputStream() 读取客户端写入的数据，显示
        String desFilePath = "E:\\Java_Project\\Module01\\NetworkProgramming21\\src\\Socket03\\TCPFIleCopy\\space.jpg";
        FileOutputStream fileOutputStream = new FileOutputStream(desFilePath);
        InputStream inputStream = socket.getInputStream();

        //4.IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            fileOutputStream.write(buf,0,readLen);
        }

//        输入的时候不需要设置结束标记
//        socket.shutdownOutput();
        // 5.服务端接收到客户端发送的图片，保存以后，回复 “收到图片” 后退出

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到图片".getBytes());

        System.out.println("服务端退出");

        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();


    }
}
