package Homework06;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ author Egcoo
 * @ date 2022/7/11 - 11:52
 */
@SuppressWarnings({"all"})
public class Homework02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Car("奥拓", 1000));
        arrayList.add(new Car("奥迪", 300000));
        arrayList.add(new Car("法拉利", 10000000));
        arrayList.add(new Car("奥迪", 300000));
        arrayList.add(new Car("保时捷", 70000000));
        arrayList.add(new Car("奥迪", 300000));

        System.out.println(arrayList);

        // remove:删除指定元素
        arrayList.remove(1);
        System.out.println(arrayList);

        // contains:查找元素是否存在
        //System.out.println(arrayList.contains());

        // size:获取元素个数
        System.out.println(arrayList.size());//2

        // isEmpty:判断是否为空
        System.out.println(arrayList.isEmpty());//F

        arrayList.clear();
        System.out.println("list=" + arrayList);

        //添加多个元素
        ArrayList list2 = new ArrayList();
        list2.add("红楼梦");
        list2.add("三国演义");
        arrayList.addAll(list2);
        System.out.println("arraylist = " + arrayList);

        for (Object o :arrayList) {
            System.out.println(o);
        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
            
        }

    }
}

class Car {
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
