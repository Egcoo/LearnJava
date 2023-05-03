package Homework.work01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * @ author Egcoo
 * @ date 2022/10/5 - 16:51
 */
public class H01Server {
    public static void main(String[] args) throws IOException {

        // 1.要求在本地端口监听等待连接
        ServerSocket serverSocket = new ServerSocket(9999);

        // 2.连接不成功程序会阻塞
        Socket socket = serverSocket.accept();

        // 3.读取客户端数据,包装成字符流
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s = reader.readLine();
        String answer = "";
        if (s.equals("name")) {
            answer = "不好意思我是您的亲爹";
        } else if (s.equals("hobby")){
            answer = "java Programing";
        } else {
            answer = "who are you~";
        }

        // 5.通过输出流，写入数据列，数据通道
        OutputStream outputStream = socket.getOutputStream();
        //使用字符输出流的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer);
        // bufferedWriter.newLine(); 也是可以增加写入标记，不过要使用readLine读取
        bufferedWriter.newLine();//插入一个换行符,表示回复内容的结束
        bufferedWriter.flush(); //字符流需要手动刷新，不然数据无法写入



        bufferedWriter.close();
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
