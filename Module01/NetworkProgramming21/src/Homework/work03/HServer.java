package Homework.work03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/10/7 - 15:28
 */
// 这两个是一个原生态的文件下载
public class HServer {
    public static void main(String[] args) throws Exception {

        // 1.服务端监听本地 8888 端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端 8888 端口等待连接");
        Socket socket = serverSocket.accept();

        // 2.读取客户端发送的的信息，也就是文件名，直接读取就行
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s = reader.readLine();
        String ans = "space";

        BufferedInputStream FileInput = null;
        BufferedOutputStream FileOutput = null;
        // 3.这里作为发送文件的分隔
        // 其实这里的 if 里中的循环语句可以精简，目的是找到最终返回文件的地址
        // 实际的操作语句可以拿到外面
        if (s.equals(ans)) {
            //1.先从本地拿到要传送的文件
            String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\space.jpg";
            FileInput = new BufferedInputStream(new FileInputStream(filePath));
            // 将输入流转变成字节数组
            byte[] bytes = StreamUtils.streamToByteArray(FileInput);

            // 2.然后通过socket 输出流将字节数组发送到客户端
            FileOutput = new BufferedOutputStream(socket.getOutputStream());
            FileOutput.write(bytes);
            FileOutput.flush(); // 设置写入标记

        } else {
            //1.先从本地拿到要传送的文件
            String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\rose.jpg";
            FileInput = new BufferedInputStream(new FileInputStream(filePath));
            // 使用工具类StreamUtils，将输入流转变成字节数组
            byte[] bytes = StreamUtils.streamToByteArray(FileInput);

            // 2.然后通过socket 输出流将字节数组发送到客户端
            FileOutput = new BufferedOutputStream(socket.getOutputStream());
            FileOutput.write(bytes);
            FileOutput.flush(); // 设置写入标记

        }

        //3.接受从服务端发回的消息
        inputStream = socket.getInputStream();
        //使用 StreamUtils 的方法,直接将 inputStream  读取到的内容 转成字符串
        String string = socket02.TCPFileCopy.StreamUtils.streamToString(inputStream);
        System.out.println(string);

        // 3.关闭获取本地文件的流
        FileInput.close();
        FileOutput.close();
        // 最后一步关流
        inputStream.close();
        reader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端正常退出。");
    }
}
