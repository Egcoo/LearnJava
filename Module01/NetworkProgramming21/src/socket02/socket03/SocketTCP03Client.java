package socket02.socket03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/7/29 - 12:16
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {

        //思路
        //1.连接服务器 （IP ，端口）
        //解读：连接本机的 9999 端口，如果连接成功，返回 socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回= " + socket.getClass());
        // 2.连接上后，生成socket ，通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        // 3.通过输出流，写入数据列，数据通道
        //outputStream.write("hello,sever".getBytes()); ---> 变为字符流
        // outputStreamWriter 这是一个转换流

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,world 字符流");
        bufferedWriter.newLine();//插入一个换行符,表示内容的结束,注意:要求对方使用 readLine();
        bufferedWriter.flush(); //如果使用字符流,要求手动刷新,否则数据不会写入数据通道

        /*
        //设置结束标记
        socket.shutdownOutput();

         */

        //4.获取socket的 关联输入流,读取数据(字节),并显示
        InputStream inputStream = socket.getInputStream();
        // 4.IO读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        // 5.关闭流对象和 socket ，必须关闭
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        System.out.println("客户端退出......");
    }
}
