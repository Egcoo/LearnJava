package HouseView;

import HouseService.HouseService; //导入HouseService类才能再这个界面层中，构建HS对象和展示信息
import Utils.Utility;
import domain.House;

/**
 * @ author Egcoo
 * @ date 2022/4/10 - 12:59
 */
public class houseView {

    boolean loop = true;
    char key = ' ';

    //得先有 houseService对象 才能调用其方法。
    private HouseService houseService = new HouseService(10);


    //编写addHouse(),接收输入，创建house 对象，调用house 方法
    public void addHouse() {
        System.out.println("==========添加房屋============");
        System.out.print("姓名：");
        String name = Utility.readString(12);
        System.out.print("电话：");
        String phone = Utility.readString(11);
        System.out.print("地址：");
        String address = Utility.readString(10);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);

        //然后创建一个house 对象，注意 id 是自动分配。
        House newHouse = new House(0, name, phone, address, rent, state);

        if (houseService.addHouse(newHouse)) {
            System.out.println("========添加成功=========");
        } else {
            System.out.println("========添加失败=========");
        }
    }


    //编写delHouse 方法，接受输入的id ，调用service 中的del方法
    public void delHouse() {
        System.out.println("==========添加房屋============");
        System.out.println("请输入删除房屋的编号（-1退出）：");
        int delID = Utility.readInt();
        if (delID == -1) {
            System.out.println("==========放弃删除房屋============");
            return;
        }
        char choice = Utility.readConfirmSelection(); //方法本身就含有输出和判断信息
        if (choice == 'Y') { //在其中调用service 的方法信息
            if (houseService.del(delID)) {
                System.out.println("=========删除房屋信息成功========");
            } else {
                System.out.println("=========编号不存在，删除失败======");
            }
        } else {
            System.out.println("==========删除房屋失败============");
        }
    }

    //完成程序退出
    public void exit() {
        //这里我们使用 utility 的方法来退出
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    //房屋出租的查找
    public void searchHouse(){
        System.out.println("=========查找房屋信息========");
        System.out.print("输入你想要查找房屋的序号（-1退出）:   ");
        int searchID = Utility.readInt();
        if (searchID == -1) {
            System.out.println("==========放弃删除房屋============");
            return;
        }
        houseService.searchHouse(searchID);
    }

    //编写 houseList展示房屋列表
    public void houseList() {
        System.out.println("---------房屋列表------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（已出租/未出租）");
        House[] list = houseService.list(); //得到所有的房屋信息
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                break;
            }
            System.out.println(list[i]); //因为toString方法，已经重写过了
        }

        System.out.println("---------房屋列表完成---------");
    }

    public void mainMenu() {

        do {
            System.out.println("========房屋出租系统=========");
            System.out.println("\t\t\t 1  新 增 房 源 ");
            System.out.println("\t\t\t 2  查 找 房 屋 ");
            System.out.println("\t\t\t 3  删 除 房 屋 ");
            System.out.println("\t\t\t 4  修 改 房 屋 信 息 ");
            System.out.println("\t\t\t 5  房 源 列 表 ");
            System.out.println("\t\t\t 6  退 出 ");
            System.out.print("请选择 1 —— 6：   ");

            key = Utility.readChar();

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    searchHouse();
                    break;
                case '3':
                    delHouse();
                    break;

                case '4':
                    System.out.println("---------修改房屋信息---------");
                    break;

                case '5':
                    houseList();
                    break;
                case '6':
                    //这一段我是直接复制了零钱通里的退出部分
                    //一段代码实现一个小的功能。

//                    char choice = ' ';
//                    while (true) {
//                        System.out.println("你确定要退出吗？y/n");
//                        choice = Utility.readChar();
//                        if ("y".equals(choice) || "n".equals(choice)) {
//                            break;
//                        }
//                    }
//                    if ("y".equals(choice)) {
//                        loop = false;
//                    }

                    exit();
                    break;
                default:
                    System.out.println("你的输入有误，重新输入");
            }

        } while (loop);
    }
}
