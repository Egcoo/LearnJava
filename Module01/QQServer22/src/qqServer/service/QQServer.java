package qqServer.service;

import Common.Message;
import Common.MessageType;
import Common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ author Egcoo
 * @ date 2022/10/11 - 14:56
 * 这里是服务器，在监听9999，等待客户端连接，并保持通信
 */
public class QQServer {

    // 客户端监听需要有一个 ServerSocket
    private ServerSocket ss = null;

    // 创建一共集合，内存放多个用户，如果是这些用户登录，就认为是合法的。
    // HashMap 没有处理线程安全，因此在多线程情况下是不安全的
    // concurrentHashMap 处理的线程安全，即线程同步处理，在多线程情况下是安全的
    //
    private static ConcurrentHashMap<String, User> validUser = new ConcurrentHashMap<>();

    static { // 在静态代码块中，初始化，validUser
        validUser.put("100", new User("100", "123456"));
        validUser.put("200", new User("200", "123456"));
        validUser.put("300", new User("300", "123456"));
        validUser.put("至尊宝", new User("至尊宝", "123456"));
        validUser.put("紫霞", new User("紫霞", "123456"));
        validUser.put("哪吒", new User("哪吒", "123456"));
    }

    //验证用户是否有效的方法
    private boolean checkUser(String userId, String passwd) {

        User user = validUser.get(userId);
        //过关的验证方式
        if (user == null) { // 说明userId 没有存在在 validUser 的Key中
            return false;
        }
        if (!user.getPasswd().equals(passwd)) {
            return false;
        }
        return true;
    }

    public QQServer() {
        // 注意：端口可以写在配置文件
        try {
            System.out.println("服务端在 9999 端口监听.....");
            ss = new ServerSocket(9999);

            while (true) { // 当和某个客户端连接后，会继续监听，因此 while
                Socket socket = ss.accept();
                //得到 socket 关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                User u = (User) ois.readObject(); // 读取客户端发送的 User 对象

                //得到 socket 关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                // 创建一个Message 对象， 准备回复客户端
                Message message = new Message();
                // 验证
                // 这里只是一个强制性的，暂时验证程序
                if (checkUser(u.getUserId(), u.getPasswd())) {
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    // 将 message 对象回复客户端
                    oos.writeObject(message);
                    //创建一个线程 和客户端保持通讯，而且该线程需要持有 socket 对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUserId());
                    //启动线程
                    serverConnectClientThread.start();
                    // 把该线程对象放入到一个集合中管理
                    ManageClientThreads.addClientThread(u.getUserId(), serverConnectClientThread);


                } else { // 如果验证登录失败
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    // 将 message 对象回复客户端
                    oos.writeObject(message);
                    // 登录失败 ，socket保留就没有意义
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果服务器退出循环，说明服务器不再监听，因此关闭ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
