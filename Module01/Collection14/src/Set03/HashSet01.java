package Set03;

import java.util.HashSet;
import java.util.Set;

/**
 * @ author Egcoo
 * @ date 2022/7/6 - 10:21
 */
@SuppressWarnings({"all"})
public class HashSet01 {
    public static void main(String[] args) {
        //1. 构造器走的源码
        /*
        public HashSet() {
        map = new HashMap<>();
        }
        2. HashSet 可以存放 null ,但是只能有一个 null,即元素不能重复
        */
        Set hashSet = new HashSet();
        hashSet.add(null);
        hashSet.add(null);
        System.out.println("hashSet=" + hashSet);

        HashSet set = new HashSet();
        //说明
        //1. 在执行 add 方法后，会返回一个 boolean 值
        //2. 如果添加成功，返回 true, 否则返回 false
        //3. 可以通过 remove 指定删除哪个对象


        System.out.println(set.add("john"));//T
        System.out.println(set.add("lucy"));//T
        System.out.println(set.add("john"));//F
        System.out.println(set.add("jack"));//T
        System.out.println(set.add("Rose"));//T
        set.remove("john");
        System.out.println("set=" + set);//3 个


        set = new HashSet();
        System.out.println("set=" + set);//0
        //4 Hashset 不能添加相同的元素/数据?
        set.add("lucy");//添加成功
        set.add("lucy");//加入不了
        set.add(new Dog("tom"));//OK
        set.add(new Dog("tom"));//Ok
        System.out.println("set=" + set);
        //在加深一下. 非常经典的面试题.
        //看源码，做分析， 先给小伙伴留一个坑，以后讲完源码，你就了然
        //去看他的源码，即 add 到底发生了什么?=> 底层机制. set.add(new String("hsp"));//ok
        set.add(new String("hsp"));//加入不了. System.out.println("set=" + set);
    }
}

class Dog { //定义了 Dog 类
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}