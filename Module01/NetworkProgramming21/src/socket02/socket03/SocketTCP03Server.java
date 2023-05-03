package socket02.socket03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/7/29 - 12:15
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1.在本机的 9999 端口监听，等待连接
        // 细节：要求在本机没有其他服务在监听9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个socket [多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接....");

        //2. 当没有客户端连接9999 端口时，程序会阻塞，等待连接
        // 如果有客户端连接，则会返回socket 对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());


        //3.通过 socket.getInputStream() 读取客户端写入的数据，显示
        InputStream inputStream = socket.getInputStream();
        // 4.IO读取,使用字符流, 使用 InputStreamReader 将 inputStream 转换成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);//输出


        // 5.通过输出流，写入数据列，数据通道
        OutputStream outputStream = socket.getOutputStream();
        //使用字符输出流的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client 字符流");

        // bufferedWriter.newLine(); 也是可以增加写入标记，不过要使用readLine读取
        bufferedWriter.newLine();//插入一个换行符,表示回复内容的结束
        bufferedWriter.flush(); //字符流需要手动刷新，不然数据无法写入



        //6.关闭流和 socket
        bufferedReader.close();
        bufferedWriter.close(); //这个不关闭就没法保存，导致没法输出内容
        socket.close(); //
        serverSocket.close();//关闭
    }
}
