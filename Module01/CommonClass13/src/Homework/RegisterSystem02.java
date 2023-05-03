package Homework;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/7/3 - 9:25
 */
public class RegisterSystem02 {
    public static void main(String[] args) {

        //输入用户名、密码、邮箱如果信息录入正确，则提示注册成功，否则生成异常对象
        //1.用户名为2，3，4
        //2.密码长度为6，且要求全是数字
        //3.邮箱中包含@和. ,且 @ 再 .前面
        /*
        思路分析
        1.参考异常处理的时候 try-catch
        2.整体上使用 while 循环，其中只要有异常，就抛出重来
        3.先尝试整体写到 try 里然后一起 catch
         */

        Scanner myScanner = new Scanner(System.in);

        String name = "";
        String password = "";
        String mailbox = "";

        while (true) {
            System.out.println("请输入用户名：");
            name = myScanner.next();
            if (!(name.length() >= 2 && name.length() <= 4)){
                System.out.println("你的输入有误，要求长度2-4");
                continue;
            }
            System.out.println("请输入你的密码，要求密码长度为6，且要求全是数字");
            password = myScanner.next();
            try {
                int num = Integer.parseInt(password);
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数");
                continue;
            }

            System.out.println("请输入你的邮箱：");
            mailbox = myScanner.next();
            int index1 = mailbox.lastIndexOf('@');
            int index2 = mailbox.lastIndexOf('.');
            if (index1>index2){
                System.out.println("邮箱输入有误，请重新输入");
                continue;
            }
            break;
        }

    }
}
