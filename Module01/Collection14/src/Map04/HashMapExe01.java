package Map04;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2022/7/8 - 14:34
 */
@SuppressWarnings({"all"})
public class HashMapExe01 {
    public static void main(String[] args) {

        /*
        1.使用 HashMap 添加了3个员工对象，要求
        键：员工ID；值：员工对象（员工类包括：姓名，工资，员工Id）
        2. 遍历显示工资 > 18000的员工

        遇到问题在不创建新对象的前提下内容如何放进去。
        记住存放在集合里的元素编译类型都是object，不向下转型的话用不了Emp的get方法
         */
        Map map = new HashMap();
        map.put("1001", new Employee("jack", 30000, "1001"));
        map.put("1002", new Employee("mary", 3000, "1002"));
        map.put("1003", new Employee("john", 23000, "1003"));

        //第一组: 先取出 所有的Key , 通过 Key 取出对应的 Value

        Set keyset = map.keySet();
        //(1) 增强 for
        System.out.println("---第一种方式---");
        for (Object key : keyset) {
//            这是向下转型，存放在集合里的元素遍历类型都是 object，不向下转型用不了Emp的get方法
            Employee employee = (Employee) map.get(key);
            if (employee.getSal() > 18000) {
                System.out.println(key + "-" + map.get(key));
            }
        }

        //(2)迭代器
        System.out.println("-----第二种方式----");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Employee employee = (Employee) map.get(key);
            if (employee.getSal() > 18000) {
                System.out.println(key + "-" + map.get(key));
            }
        }

        //第二组：把所有的 value 取出
        Collection values = map.values();
        //这里可以使用 所有的Collection 使用的遍历方法
        //(1) 增强for
        System.out.println("---取出所有的 value 增强for---");
        for (Object value : values) {
            System.out.println(value);
        }

        //(2)迭代器
        System.out.println("---取出所有的 value 迭代器---");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println(value);
        }

        //第三组：通过 EntrySet 来获取 k-v
        Set entrySet = map.entrySet();

        //(1)增强for
        System.out.println("-----使用 EntrySet 的for 增强（第三种）-------");
        for (Object entry : entrySet) {
            //将entry 转成 Map.Entry
            Map.Entry entry1 = (Map.Entry) entry;
            System.out.println(entry1.getKey() + "-" + entry1.getValue());
        }

        //(2) 迭代器
        System.out.println("----使用 EntrySet 的 迭代器(第 4 种)----");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator3.next();
            //System.out.println(next.getClass());
            //HashMap$Node -实现-> Map.Entry (getKey,getValue)
            //向下转型 Map.Entry

            Employee emp = (Employee) entry.getValue();
            if(emp.getSal() > 18000) {
                System.out.println(emp);
            }
            /*
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());

             */
        }


    }
}

class Employee {
    private String name;
    private int sal;
    private String ID;

    public Employee(String name, int sal, String ID) {
        this.name = name;
        this.sal = sal;
        this.ID = ID;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", ID='" + ID + '\'' +
                '}';
    }

}
