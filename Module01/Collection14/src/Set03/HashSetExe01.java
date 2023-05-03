package Set03;

import java.util.HashSet;
import java.util.Objects;

/**
 * @ author Egcoo
 * @ date 2022/7/7 - 9:08
 */
@SuppressWarnings({"all"})
public class HashSetExe01 {
    public static void main(String[] args) {
        /**
         * 定义一个 Employee 类，该类包含：private 成员属性 name,age 要求:
         * 创建 3 个 Employee 对象放入 HashSet 中
         * 当 name 和 age 的值相同时，认为是相同员工, 不能添加到 HashSet
         */

        /**
         * 1.HashSet 底层是HashMap，第一次添加时，table数组扩容到16，临界值（threshold）
         * 是16 * 加载因子(loadFactor) 是 0.75 = 12
         * 2.如果table 数组使用到了临界值 12，就会扩容到 16*2 = 32，新的临界值就是 32*0.75 = 24
         * 3.在 Java8中，如果一条链表的元素格数到达8，或者两条链表的节点数总和到达8时，也会采用数组的扩容机制。
         */
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("jack",21));
        hashSet.add(new Employee("Mary",23));
        hashSet.add(new Employee("smith",25));
        hashSet.add(new Employee("jack",21));

        System.out.println("hashSet = " + hashSet);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}