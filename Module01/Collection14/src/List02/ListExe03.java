package List02;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/7/4 - 11:26
 */
public class ListExe03 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        /*
        添加 10 个以上的元素(比如 String "hello" )，在 2 号位插入一个元素"韩顺平教育"，
        获得第 5 个元素，删除第 6 个元素，修改第 7 个元素，在使用迭代器遍历集合，
        要求:使用 List 的实现类 ArrayList 完成。
        */

        List list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add("hello"+ i);
        }

        System.out.println("List = " + list);

        list.add(1,"韩顺平教育");
        System.out.println("List = " + list);

        System.out.println(list.get(4));

        list.remove(5);
        System.out.println("List = " + list);

        list.set(6,"三国演义");
        System.out.println("List = " + list);
    }
}
