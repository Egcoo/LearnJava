package List02;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/7/4 - 11:03
 */
public class ListMethod01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
//1. List 集合类中元素有序(即添加顺序和取出顺序一致)、且可重复 [案例]
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("hsp");

        list.add("tom");
        System.out.println("list=" + list);
//2. List 集合中的每个元素都有其对应的顺序索引，即支持索引
// 索引是从 0 开始的
        System.out.println(list.get(3));//hsp

    }
}
