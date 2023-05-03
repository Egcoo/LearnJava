package socket02.socket02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/7/29 - 12:16
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {

        //思路
        //1.连接服务器 （IP ，端口）
        //解读：连接本机的 9999 端口，如果连接成功，返回 socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回= " + socket.getClass());
        // 2.连接上后，生成socket ，通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        // 3.通过输出流，写入数据列，数据通道
        outputStream.write("hello,sever".getBytes());
        //设置结束标记
        socket.shutdownOutput();

        //4.获取socket的 关联输入流,读取数据(字节),并显示
        InputStream inputStream = socket.getInputStream();
        // 4.IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readLen));//根据独到的实际长度显示内容
        }
        // 5.关闭流对象和 socket ，必须关闭
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出......");
    }
}
