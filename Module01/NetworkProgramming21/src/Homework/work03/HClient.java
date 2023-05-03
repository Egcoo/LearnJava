package Homework.work03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/10/7 - 15:27
 */
public class HClient {
    public static void main(String[] args) throws Exception {

        //1.客户端连接服务端的 8888 端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端连接成功！");

        // 2.客户端向服务端发送信息，连接上后生成 socket ，通过 socket.getOutputStream();
        OutputStream outputStream = socket.getOutputStream();
        // 3.通过字符流写入数据通道
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        // 4.设置用户自定义信息
        Scanner myScanner = new Scanner(System.in);
        String MusicName = myScanner.next();

        // 5.写入数据
        writer.write(MusicName);
        writer.newLine(); //插入一个换行符，表示写入内容的结束，不过需要对方使用 readLine() 读取
        writer.flush(); // 刷新使数据真正写入

        // ===================================================
        // 1.读取服务端回送的文件
        BufferedInputStream FileRead = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(FileRead);
        // 2.将得到的字节数组写入一个指定路径
        String desFilePath = "E:\\Java_Project\\Module01\\NetworkProgramming21\\src\\Homework\\work03\\" + MusicName + ".jpg";
        BufferedOutputStream FileWrite = new BufferedOutputStream(new FileOutputStream(desFilePath));
        FileWrite.write(bytes);
        FileWrite.flush(); // 刷新使数据写入

        //====================================================
        // 5.向客户端回复 "收到图片"
        // 通过 socket 获取到输出流(字符)
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush();// 把内容刷新到数据通道
        socket.shutdownOutput(); // 设置写入标记


        // 6.客户端最后一步：关流
        writer.close();
        // 3.这里就给读取回送文件的流关闭
        FileRead.close();
        FileWrite.close();
        socket.close();
        System.out.println("客户端正常退出");


    }
}
