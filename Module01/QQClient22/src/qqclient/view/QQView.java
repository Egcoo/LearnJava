package qqclient.view;

import qqclient.service.ManageClientConnectServerThread;
import qqclient.service.MessageClientService;
import qqclient.service.UserClientService;
import qqclient.utils.Utility;

/**
 * @ author Egcoo
 * @ date 2022/10/9 - 10:59
 * 客户端的菜单界面
 */
public class QQView {

    private boolean loop = true; // 控制是否显示菜单
    private String key = ""; // 接收用户的键盘输入
    private UserClientService userClientService = new UserClientService();//对象是用于登录服务/注册用户
    private MessageClientService messageClientService = new MessageClientService(); // 用于消息发送

    public static void main(String[] args){
        new QQView().mainMenu();
    }

    // 显示主菜单
    private void mainMenu() {

        while (loop) {

            System.out.println("=========欢迎登录网络通讯系统=============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.println("请输入你的选择：");
            key = Utility.readString(1); //从键盘读取一位输入

            // 根据用户的输入，来处理不同的输出
            switch (key) {
                case "1":
                    System.out.println("输入你的用户号：");
                    String userId = Utility.readString(50);
                    System.out.println("请输入密码");
                    String pwd = Utility.readString(50);
                    //这里就比较麻烦了，需要到服务端去验证该用户是否合法。
                    //这里有很多代码
                    if (userClientService.checkUser(userId, pwd)) { //只是一个暂时的，先把逻辑打通
                        System.out.println("===========欢迎 (用户 " + userId + " 登录成功) ===========");
                        while (loop) {
                            System.out.println("=========欢迎 (用户 " + userId + ") ==========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发文件");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.println("输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    //System.out.println("显示在线用户列表");
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("群发文件");
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户号(在线)：");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入想说的话：");
                                    String content = Utility.readString(100);
                                    //编写一个方法，将消息发送给服务端
                                    messageClientService.sendMessageToOne(content,userId,getterId);

                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    //System.out.println("退出系统");
                                    // 调用方法，给服务器发送一个退出系统的  message
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else { //登陆服务器失败
                        System.out.println("========登陆失败========");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}
