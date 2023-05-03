package com.HCMS.service;

import com.HCMS.dao.MenuDAO;
import com.HCMS.domain.Menu;

import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/11/24 - 20:09
 * 完成对 menu 表的操作
 */
public class MenuService {

    // 定义MenuDAO属性
    private MenuDAO menuDAO = new MenuDAO();

    // 返回所有菜品，给界面使用
    public List<Menu> list() {
        List<Menu> menus = menuDAO.queryMulti("select * from menu", Menu.class);
        return menus;
    }

    // 根据需求来设置方法
    public Menu getMenuById(int id) {
        Menu menu = menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
        return menu;
    }

}
