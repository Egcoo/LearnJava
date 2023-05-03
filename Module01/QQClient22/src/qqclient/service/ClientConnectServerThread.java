package qqclient.service;

import Common.Message;
import Common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/10/9 - 12:46
 */
public class ClientConnectServerThread extends Thread {
    //该线程需要持有 Socket
    private Socket socket;

    // 构造器可以接受一个Socket 对象

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为Thread需要在后台和服务器通讯，做成无限循环
        while (true) {
            try {
                System.out.println("客户端线程，等待从服务器端的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务端没有会送消息就会组测在这里
                //阻塞性网络编程的效率是比较低的
                Message message = (Message) ois.readObject();
                //注意：后面我们要使用 message
                // 这个是Message 的业务类型，之后要做相应的业务处理
                // 如果读取到相应的是服务端返回的在线用户列表
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //输出在线列表信息，并显示
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("====== 当前在线用户列表======");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) { //普通的聊天消息
                    //把从服务器转发的消息，显示到控制台
                    System.out.println("\n" + message.getSender() + " 对 " + message.getGetter() +
                             " 说：" + message.getContent());

                } else {
                    System.out.println("是其他类型的数据，暂时不处理......");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //更好得到socket
    public Socket getSocket() {
        return socket;
    }

}
