package HRS09;
import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/4/9 - 16:09
 *
 * 这一版本我看到的问题在哪里呢，就是每个数据都是单独的，编号也没法匹配数据，
 * 但是可以通过增加其他类，来实现想要达到的效果，如果是用这样的方法，还不如直接用OOP
 */
public class CommonType {
    public static void main(String[] args) {
        /*
        这是一个房屋出租系统的项目，自己尝试写出，先写普通的版本，再改写成面向对象版本
        1.先实现用户和界面的交互。
        2.
         */

        Scanner myScanner = new Scanner(System.in);

        boolean loop = true;
        String key = "";

        //2.先实现房屋明细，就是可以查看所有房屋的信息。（1）收益入账保存和消费，保存到数组{不明白}
        //  （2）使用对象 （3）字符串简单拼接
        String details = "";

        //3.完成房源的新增
        int n = 0;
        String name = "";
        String phone = "";
        String address = "";
        int rent = 0;
        String HomeState = "";

        //4.房源的查找
        int num = 0;


        do {
            System.out.println("========房屋出租系统=========");
            System.out.println("\t\t\t 1  新 增 房 源 ");
            System.out.println("\t\t\t 2  查 找 房 屋 ");
            System.out.println("\t\t\t 3  删 除 房 屋 ");
            System.out.println("\t\t\t 4  修 改 房 屋 信 息 ");
            System.out.println("\t\t\t 5  房 源 列 表 ");
            System.out.println("\t\t\t 6  退 出 ");
            System.out.print("请选择 1 —— 6：   ");

            key = myScanner.next();

            switch (key){
                case "1":
                    System.out.println("---------新增房屋--------");
                    System.out.print("姓名：");
                    name = myScanner.next();
                    System.out.print("电话：");
                    phone = myScanner.next();
                    System.out.print("地址：");
                    address = myScanner.next();
                    System.out.print("月租：");
                    rent = myScanner.nextInt();
                    System.out.print("状态（已出租/未出租）：");
                    HomeState = myScanner.next();
                    details += n+1 +"\t" + name + "\t" +
                           phone + "\t" + address + "\t" + rent + "\t" + HomeState;
                    break;
                case "2":
                    System.out.println("---------查找房屋---------");
                    System.out.print("请输入你要查找的ID“：");
                    num = myScanner.nextInt();
                    //写到这里我突然发现，必须要使用数组，
                    // 不然没有办法查找，以及删除，确实怎么用数组我也不是很懂，应该可以用面向对象


                case "3":

                case "4":

                case "5":

                    System.out.println("---------房屋列表------------");
                    System.out.println("编号\t房主\t电话\t地址\t月租\t状态（已出租/未出租）");
                    System.out.println(details);
                    System.out.println("---------房屋列表完成---------");
                    break;
                case "6":
                    //这一段我是直接复制了零钱通里的退出部分
                    //一段代码实现一个小的功能。

                    String choice = "";
                    while (true) {
                        System.out.println("你确定要退出吗？y/n");
                        choice = myScanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }
                    if ("y".equals(choice)) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("你的输入有误，重新输入");
            }

        }while (loop);

        System.out.println("--------程序已经结束--------");
    }
}
