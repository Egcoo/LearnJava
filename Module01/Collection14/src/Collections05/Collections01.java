package Collections05;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2022/7/11 - 10:11
 */
@SuppressWarnings({"all"})
public class Collections01 {
    public static void main(String[] args) throws RuntimeException {
        //创建 ArrayList 集合，用于测试.
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");
        list.add("tom");
        // 1.reverse(List)：反转 List 中元素的顺
        Collections.reverse(list);
        System.out.println("list = " + list);

        // 2.shuffle(List)：对 List 集合元素进行随机排序

        for (int i = 0; i < 3; i++) {
            Collections.shuffle(list);
            System.out.println("list = " + list);
        }
        // 3.sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序

        Collections.sort(list);
        System.out.println("list = " + list);
        // 4.sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序

        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o1).length();

            }
        });

        System.out.println("list =" + list);
        // 5.swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

        Collections.swap(list, 0, 1);
        System.out.println("交换后的情况");
        System.out.println("list=" + list);
        //6.Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println("自然顺序最大元素=" + Collections.max(list));
        //7.Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
        Object maxObject = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("长度最大的元素=" + maxObject);


        //Object min(Collection)
        //Object min(Collection，Comparator)
        //上面的两个方法，参考 max 即可
        //8.int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        System.out.println("tom 出现的次数=" + Collections.frequency(list, "tom"));

        //9.void copy(List dest,List src)：将 src 中的内容复制到 dest 中
        ArrayList dest = new ArrayList();
        //为了完成一个完整拷贝，我们需要先给 dest 赋值，大小和 list.size()一样
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        //拷贝
        Collections.copy(dest, list);
        System.out.println("dest=" + dest);

        //10.boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
        //如果 list 中，有 tom 就替换成 汤姆


        Collections.replaceAll(list, "tom", "汤姆");
        System.out.println("list 替换后=" + list);
    }
}
