package Homework.work01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/10/5 - 16:51
 */
public class H01Client {
    public static void main(String[] args) throws IOException {

        //1.连接本地服务器(IP, 端口)
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 2.连接上时候通过 socket 写入
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        // 3.开始向其中写入内容
        writer.write("name");
        writer.newLine();// 插入一个换行符表示内容结束
        writer.flush(); // 刷新一下保证内容已经写入

        //4.获取socket的 关联输入流,读取数据(字节),并显示
        InputStream inputStream = socket.getInputStream();
        // 4.IO读取
        BufferedReader Reader = new BufferedReader(new InputStreamReader(inputStream));
        String s = Reader.readLine();
        System.out.println(s);



        Reader.close();
        writer.close();
        outputStream.close();
        socket.close();
    }
}
