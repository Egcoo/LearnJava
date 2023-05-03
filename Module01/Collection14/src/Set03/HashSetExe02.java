package Set03;

import java.util.HashSet;
import java.util.Objects;

/**
 * @ author Egcoo
 * @ date 2022/7/7 - 9:54
 */
@SuppressWarnings({"all"})
public class HashSetExe02 {
    public static void main(String[] args) {
        /*
        定义一个Employee 类，该类包含：private成员属性，name,sal,birthday(MyDate类型)
        其中birthday 为MyDate类型（属性包括：year，month，day），要求：
        1.创建3 个Employee 放入HashSet中
        2.当 name 和birthday 的值相同时，认为是相同员工，不能添加到HashSet集合中
         */
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee1(2000,12,3,"jack",4000));
        hashSet.add(new Employee1(2003,8,8,"ego",4000));
        hashSet.add(new Employee1(2000,12,3,"mary",4000));
        hashSet.add(new Employee1(2000,12,5,"jack",4000));

        System.out.println("hashSet =" + hashSet);

    }
}

class Employee1 extends MyDate{
    private String name;
    private int sal;

    public Employee1(int year, int month, int day, String name, int sal) {
        super(year, month, day);
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee1 employee1 = (Employee1) o;
        return Objects.equals(name, employee1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}


