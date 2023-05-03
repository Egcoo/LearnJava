package qqServer.service;

import Common.Message;
import Common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @ author Egcoo
 * @ date 2022/10/11 - 15:44
 * 该类的一个对象和某个客户端保持通讯
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId; // 连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() { // 这里时run 的状态，可以发送/接收消息
        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + " 保持通信，读取数据......");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                // 后面会使用 message, 根据 message 的类型，做相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    // 客户端要在线用户列表
                    System.out.println(message.getSender() + " 要在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    // 返回 message
                    // 构建 一个 message对象 返回个客户端
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    // 返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) { //发送消息
                    //根据 message 获取getter id,然后再得到对应的线程
                    ServerConnectClientThread serverConnectThread =
                            ManageClientThreads.getServerConnectThread(message.getGetter());
                    //得到对应 socket 的对象输出流，将 message 对象转发给指定的客户端
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectThread.getSocket().getOutputStream());
                    oos.writeObject(message);// 如果客户不在线，可以保存到数据库


                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) { //客户端退出

                    System.out.println(message.getSender() + " 退出 ");
                    // 将这个客户端对应线程，从集合删除
                    ManageClientThreads.removeServerConnectClient(message.getSender());
                    socket.close(); //关闭连接
                    //退出循环
                    break;
                } else {

                    System.out.println("其他类型 message, 暂时不处理");
                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }

        }

    }


}
