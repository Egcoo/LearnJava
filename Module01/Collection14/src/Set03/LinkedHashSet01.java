package Set03;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ author Egcoo
 * @ date 2022/7/7 - 10:35
 */
@SuppressWarnings({"all"})
public class LinkedHashSet01 {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("jack",1100));
        set.add(123);
        set.add("HSP");

        System.out.println("set = " + set);

        /*
        1.LinkedHashSet 加入顺序和取出元素/数据顺序一致
        2.LinkedHashSet 底层维护的是一个 LinkedHashMap（是HashMap 的子类）
        3. LInkedHashSet 底层结构(数组 table + 双向链表)
        4，第一次添加数据，直接将table 扩容到 16，存放数据的结点类型是 LinkedHashiMap$Entry
        5.数组是 HashMap$Node[] 存放的元素 是LinkedHashMap$Entry 类型
         */

    }
}

class Customer {
    private String name;
    private int num;

    public Customer(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}