package com.HCMS.service;

import com.HCMS.dao.BasicDAO;
import com.HCMS.dao.BillDAO;
import com.HCMS.dao.MultiTableDAO;
import com.HCMS.domain.Bill;
import com.HCMS.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * @ author Egcoo
 * @ date 2022/11/24 - 20:40
 * 处理和账单相关的业务逻辑
 * 最复杂的逻辑就在这里，需要几个service 间的共同合作
 */
public class BillService {
    // 定义BillDAO属性
    private BillDAO billDAO = new BillDAO();
    // 定义 MenuService 属性
    private MenuService menuService = new MenuService();
    // 定义餐桌的状态
    private DiningTableService diningTableService = new DiningTableService();
    // 定义多表查询的属性
    private MultiTableDAO multiTableDAO = new MultiTableDAO();

    // 编写点餐的方法
    // 1.生成一个账单
    // 2.更新对应餐桌的状态
    // 3.成功返回true 失败返回false
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        // 生成一个账单号
        String billId = UUID.randomUUID().toString();

        // 将账单生成到Bill 表，要求直接计算账单金额
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);

        if (update <= 0) {
            return false;
        }

        // 需要提供一个更新餐桌状态的方法
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");
    }

    // 返回所有的账单，提供给View调用
    public List<Bill> list() {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    // 返回菜品名和账单信息
    // 返回所有的账单，提供给View调用
    public List<MultiTableBean> list2() {
        return multiTableDAO.queryMulti("select bill.*,name,price from bill,menu where bill.menuId = menu.id", MultiTableBean.class);
    }


    // 查看某个餐桌是否有未结账的账单
    public boolean hasPayBillByDiningTableId(int diningTableId) {
        Bill bill = billDAO.querySingle("select * from bill where diningTableId = ? and state = '未结账' limit 0,1", Bill.class, diningTableId);
        return bill != null;
    }

    // 完成结账[ 如果餐桌存在，并且该餐桌有未结账的账单]
    public boolean payBill(int diningTableId, String payMode) {

        // 1.修改 bill 表
        int update = billDAO.update("update bill set state=? where diningTableId=? and state = '未结账'", payMode, diningTableId);

        if (update <= 0) { // 如果更新没有成功，则表示失败
            return false;
        }

        // 2.修改diningTable
        // 表的方法写在DiningTableService 方法，完成更新，体现各司其职
        if (!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
            return false;
        }

        return true;
    }



}
