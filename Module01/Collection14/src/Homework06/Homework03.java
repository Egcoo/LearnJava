package Homework06;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2022/7/11 - 14:17
 */
@SuppressWarnings({"all"})
public class Homework03 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);

        map.replace("jack", 2600);
        System.out.println(map);

        //为所有员工工资加薪100元
        Set set = map.keySet();
        for (Object key : set) {
            //这里的本质上是更新
            map.put(key, (Integer) map.get(key) + 100);
        }
        System.out.println(map);

        System.out.println("=========遍历=========");
        //使用迭代器遍历
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        System.out.println("====遍历所有工资====");

        Collection values = map.values();
        for (Object value :values) {
            System.out.println(value);
        }

    }
}
