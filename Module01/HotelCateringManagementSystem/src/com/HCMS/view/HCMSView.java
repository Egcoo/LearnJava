package com.HCMS.view;

import com.HCMS.domain.*;
import com.HCMS.service.BillService;
import com.HCMS.service.DiningTableService;
import com.HCMS.service.EmployeeService;
import com.HCMS.service.MenuService;
import com.HCMS.utils.Utility;

import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/11/22 - 17:22
 * 遵循原则 ：先写框架，后完善结构
 */
public class HCMSView {

    // 控制是否退出菜单
    private boolean loop = true;
    // 接受用户的选择
    private String key = "";
    // 因为你需要使用employeeService,所以需要定义一个对象
    private EmployeeService employeeService = new EmployeeService();
    // 因为你需要使用diningTable,所以需要定义一个对象
    private DiningTableService diningTableService = new DiningTableService();
    // 定义 MenuService 属性
    private MenuService menuService = new MenuService();
    // 定义 BillService 属性
    private BillService billService = new BillService();


    public static void main(String[] args) {
        new HCMSView().mainMenu();
    }

    // 显示主菜单
    public void mainMenu() {

        while (loop) {

            System.out.println("==============酒店餐饮管理系统================");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 2 退出系统");
            System.out.print("输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("输入员工号：");
                    String empId = Utility.readString(50);
                    System.out.print("输入登录密码：");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);

                    if (employee != null) { // 只要不为空，说明用户存在
                        System.out.println("==============登录成功[" + employee.getName() + "]================ \n");
                        // 显示二级菜单(循环操作)，也需要循环
                        while (loop) {
                            System.out.println("==============餐饮管理系统================");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    ListDiningTable();
                                    break;
                                case "2":
                                    //System.out.println("\t\t 2 预定餐桌");
                                    orderDiningTable();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    loop = false;
                                    System.out.println("\t\t 9 退出系统");
                                    break;
                                default:
                                    System.out.println("你输入有误，请重新输入");
                                    break;
                            }
                        }

                    } else {
                        System.out.println("==============登陆失败================");
                    }
                    break;
                case "2":
                    loop = false; //
                    break;
                default:
                    System.out.println("你输入有误，请重新输入");
            }
        }

        System.out.println("你退出了系统~");
    }

    //显示所有餐桌状态
    public void ListDiningTable() {
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            //这里默认会调用对象的 toString方法,修改tostring方法
            System.out.println(diningTable);
        }
        System.out.println("======显示完毕=======");
    }

    //2.完成预定餐桌
    public void orderDiningTable() {
        System.out.println("==========预定餐桌===========");
        System.out.println("请选择要预定的餐桌编号(-1退出)：");
        int orderId = Utility.readInt();
        if (orderId == -1) {
            System.out.println("============取消预订===============");
            return;
        }
        // 选择语句
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {

            // 根据orderId 返回对应的DiningTable 对象，如果为null，说明对象不存在
            DiningTable diningTable = diningTableService.getDiningTableById(orderId);
            if (diningTable == null) {
                System.out.println("预定餐桌不存在");
                return;
            }

            // 判断餐桌是否为“空”
            if (!("空".equals(diningTable.getState()))) { // 说明当前座位不为空
                System.out.println("===========该餐桌已经预定或者正在就餐==========");
                return;
            }

            System.out.print("输入预定人的名字：");
            String orderName = Utility.readString(50);
            System.out.print("预定人电话：");
            String orderTel = Utility.readString(50);

            //说明可以预定，更新餐桌状态
            if (diningTableService.orderDiningTable(orderId, orderName, orderTel)) {
                System.out.println("=========预定成功============");
            } else {
                System.out.println("===========预定失败=========");
            }

        } else {
            System.out.println("=========取消预订===========");
        }
    }

    // 3 显示所有菜品
    public void listMenu() {
        List<Menu> list = menuService.list();
        System.out.println("\n菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : list) {
            System.out.println(menu);
        }

        System.out.println("===========显示完毕============");
    }

    //4 要求对餐桌号，菜品编号做出合理性检验，如果不合理，给出提示信息
    public void orderMenu() {
        System.out.println("============点餐服务=============");
        System.out.print("请输入点餐的桌号(-1退出): ");
        int orderDiningTableId = Utility.readInt();
        if (orderDiningTableId == -1) {
            System.out.println("=============取消点餐============");
            return;
        }
        System.out.print("请输入点餐的菜品号(-1退出): ");
        int orderMenuId = Utility.readInt();
        if (orderMenuId == -1) {
            System.out.println("=============取消点餐============");
            return;
        }
        System.out.print("请输入点餐的菜品量(-1退出): ");
        int orderNums = Utility.readInt();
        if (orderNums == -1) {
            System.out.println("=============取消点餐============");
            return;
        }

        // 验证餐桌号是否存在
        DiningTable diningTable = diningTableService.getDiningTableById(orderDiningTableId);
        if (diningTable == null) {
            System.out.println("============餐桌不存在=============");
            return;
        }

        // 验证菜品编号
        Menu menu = menuService.getMenuById(orderMenuId);
        if (menu == null) {
            System.out.println("=========菜品号不存在=========");
            return;
        }

        // 点餐
        if (billService.orderMenu(orderMenuId, orderNums, orderDiningTableId)) {
            System.out.println("=========点餐成功===============");
        } else {
            System.out.println("=========点餐失败===============");
        }
    }

    // 5 查看账单信息
    public void listBill() {
        /*
        List<Bill> bills = billService.list();
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
        for (Bill bill : bills) {
            System.out.println(bill);
        }
        System.out.println("\n================显示完毕====================");
         */

        //映射bill 表所有的字段和 menu菜品的名字字段
        List<MultiTableBean> multiTableBeans = billService.list2();
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态\t\t菜品名\t\t价格");
        for (MultiTableBean bill : multiTableBeans) {
            System.out.println(bill);
        }
        System.out.println("\n================显示完毕====================");
    }

    // 6 是先结账功能
    // 1) 对餐桌号进行校验 2）修改bill表的state 3）修改diningTable信息 4）不需要增加新表，不需要增加新类，需要增加方法。
    public void payBill() {
        System.out.println("=============结账服务===============");
        System.out.print("请选择要结账的餐桌编号(-1退出)：");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1) {
            System.out.println("==============取消结账==============");
            return;
        }

        // 验证餐桌是否存在
        DiningTable diningTable = diningTableService.getDiningTableById(diningTableId);
        if (diningTable == null) {
            System.out.println("=============结账的餐桌不存在=============");
            return;
        }
        //验证餐桌是否需要结账的账单
        if (!billService.hasPayBillByDiningTableId(diningTableId)) {
            System.out.println("=============该餐位没有未结的账单=============");
            return;
        }
        System.out.print("结账方式(现金/微信支付/支付宝)回车表示退出：");
        String payMode = Utility.readString(20, ""); //如果输入回车，返回 ""
        if ("".equals(payMode)) {
            System.out.println("===========结账失败==========");
            return;
        }
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {
            //调用方法
            if (billService.payBill(diningTableId, payMode)) {
                System.out.println("=============完成结账============");
            } else {
                System.out.println("===========结账失败==========");
            }

        } else {
            System.out.println("============取消结账===========");
        }

    }


}
