package qqServer.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @ author Egcoo
 * @ date 2022/10/11 - 20:00
 * 该类用于管理和客户端通讯的线程
 */
public class ManageClientThreads {

    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<>();

    //添加线程对象到集合
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hashMap.put(userId, serverConnectClientThread);
    }

    //根据userId 返回ServerConnectClientThread线程
    public static ServerConnectClientThread getServerConnectThread(String userId) {
        return hashMap.get(userId);
    }

    //增加一个方法，从集合中，移除某个线程对象
    public static void removeServerConnectClient(String userId){
        hashMap.remove(userId);
    }



    // 这里编写方法，可以返回在线用户列表
    public static String getOnlineUser() {
        // 遍历集合， 遍历 hashmap 的key
        Iterator<String> iterator = hashMap.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }

}
