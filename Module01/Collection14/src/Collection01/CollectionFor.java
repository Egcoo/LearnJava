package Collection01;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ author Egcoo
 * @ date 2022/7/4 - 9:57
 */
public class CollectionFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));

        //1.使用增强 for 在collection 集合
        //2.增强 for ，底层依然是迭代器，
        //3.增强 for，可以理解成是简化版本的迭代器
        //
        for (Object book :col) {
            System.out.println("book = " + book);
        }

    }
}
