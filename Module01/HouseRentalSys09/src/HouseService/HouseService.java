package HouseService;

/**
 * @ author Egcoo
 * @ date 2022/4/11 - 10:16
 */

import domain.House;

/**
 * 1.定义House的数组，保存house 对象
 * 2.相应 House view的各种调用。
 * 3，完成对房屋信息的各种操作。【增删改查】
 */
public class HouseService {
    private House[] houses; //用于保存 House 对象
    private int houseNum = 1; //用来记录目前的编号，但是为什么是1，因为目前有一个初始值
    private int idCounter = 1; //用来记录，更新 newHouse的 id，这个是在界面层看到的信息

    public HouseService(int size) {
        //new house
        houses = new House[size]; //当创建house 是指定数组的大小

        //测试输入一个
        houses[0] = new House(1, "jack", "11112", "海淀区", 3000, "已出租");

    }

    //add 方法，接受新对象，返回Boolean
    public boolean addHouse(House newHouse) { //但是你先需要考虑数组长度的问题
        if (houseNum == houses.length) {
            System.out.println("数组已满，不可添加");
            return false;
        }
        houses[houseNum++] = newHouse;
        //同时你还要设置一个 id 增长机制
        newHouse.setID(++idCounter); //这里的编号是能在界面看到的。
        return true;

    }

    //del方法，删除一个房屋信息
    public boolean del(int delID) {
        //应当先找到删除房屋信息所对应的下标，
        //下标和房屋编号压根就不是一回事
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (delID == houses[i].getID()) {
                index = i;
            }
        }
        if (index == -1) { //说明这个编号在数组中不存在
            return false;
        }
        //若找到，这里就需要使用数组的删减
        for (int i = index; i < houseNum - 1; i++) { //这里就要把 i = index 从你指定的地方开始替换
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null;
        return true;

    }

    //searchHouse 通过序号查找房屋
    public boolean searchHouse(int searchID){
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (searchID == houses[i].getID()) {
                index = i;
            }
        }
        if (index == -1) { //说明这个编号在数组中不存在
            return false;
        }else {
            System.out.println(houses[index]);
            return true;
        }
    }

    //更好的代码实现
    //课后作业：查找方式换成按地区查找，数据更多
    public House findId(int findID){
        for (int i = 0; i < houseNum; i++) {
            if (findID == houses[i].getID()){
                return houses[i];
            }
        }
        System.out.println();
        return null;
        /* 这是相应的界面层的实现
        int findID = Utility.readInt();
        //然后调用方法
        House house = houseService.findId(findID)
        if (house != null){
            System.out.println(house);
        }else{
            System.out.println("查找房屋信息失败");
        }
         */
    }


    //list方法，返回houses
    public House[] list() {
        return houses;
    }
}
