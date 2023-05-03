package socket02.TCPFileCopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

/**
 * @ author Egcoo
 * @ date 2022/7/31 - 9:27
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //1.服务端在本地监听 8888 端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端, 在8888端口监听,等待连接");
        Socket socket = serverSocket.accept();

        //3.读取客户端发送的数据
        //
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        // 4.将得到的 bytes 数组,写入到指定路径,就得到一个文件
        String destFilePath = "E:\\Java_Project\\Module01\\NetworkProgramming21\\src\\socket02\\rose.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.flush();

        // 5.向客户端回复 "收到图片"
        // 通过 socket 获取到输出流(字符)
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush();// 把内容刷新到数据通道
        socket.shutdownOutput(); // 设置写入标记

        //关闭其他资源
        writer.close();
        bis.close();
        bos.close();
        serverSocket.close();
        socket.close();



    }
}
