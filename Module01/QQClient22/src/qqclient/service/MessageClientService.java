package qqclient.service;

import Common.Message;
import Common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @ author Egcoo
 * @ date 2022/10/19 - 11:24
 * 该类，提供和消息相关的服务方法
 */
public class MessageClientService {

    public void sendMessageToOne(String content, String senderId,String getterId){
        //构建Message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString()); //发送时间设置到message 对象
        System.out.println(senderId + " 对 " + getterId + " 说 " + content);

        //发送给服务端

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread
                    (senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
