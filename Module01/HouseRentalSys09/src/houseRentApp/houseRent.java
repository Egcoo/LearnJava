package houseRentApp;

import HouseView.houseView; //想在一个类里构建其他类，必须导入你想导入的类所在的包

/**
 * @ author Egcoo
 * @ date 2022/4/11 - 11:04
 */
public class houseRent {
    public static void main(String[] args) {
        //houseView houseView = new houseView();
        new houseView().mainMenu();
        System.out.println("============退出系统=========");
    }
}
