package com.HCMS.domain;

/**
 * @ author Egcoo
 * @ date 2022/11/23 - 12:13
 * 这是一个 javabean 和 employee 对应
 */
public class Employee {
    private Integer id;
    private String empId;
    private String pwd;
    private String name;
    private String job;

    // 提供无参构造器，底层apache - dbutils反射需要
    public Employee() {

    }

    public Employee(Integer id, String empId, String pwd, String name, String job) {
        this.id = id;
        this.empId = empId;
        this.pwd = pwd;
        this.name = name;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
