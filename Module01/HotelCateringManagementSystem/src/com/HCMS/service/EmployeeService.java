package com.HCMS.service;

import com.HCMS.dao.EmployeeDAO;
import com.HCMS.domain.Employee;

/**
 * @ author Egcoo
 * @ date 2022/11/23 - 12:24
 * 这个类完成对 employee 的各种操作，增删改查，通过调用EmployeeDAO完成
 */
public class EmployeeService {

    //定义一个 employeeDAO 属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    // 根据 empId和 pwd返回一个对象，查询不到返回null
    public Employee getEmployeeByIdAndPwd(String empid, String pwd) {
        Employee employee =
                employeeDAO.querySingle("select * from employee where empId=? and pwd=md5(?)", Employee.class, empid, pwd);

        return employee;
    }

}
