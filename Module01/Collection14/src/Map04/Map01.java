package Map04;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author Egcoo
 * @ date 2022/7/8 - 9:56
 */
@SuppressWarnings({"all"})
public class Map01 {
    public static void main(String[] args) {
        /*
        1. Map 与  Collection 并列存在，用于保存具有映射关系的：key-Value
        2.Map 中的Key 和 value 可以是任何引用类型的数据，会封装到 HashMap$Node
        3.Map 中的 Key不允许重复
        4.Map 中的 value可以重复
        5.Map 的 key 可以为 null，value也可以为 null，注意 key为null，只能有一个
        value为null，可以为多个
        6.常用 String 类作为Map 的Key
        7.key 和 value之间存在单向一对一关系，即通过制定的 key 总能找到对应的 value
         */

        Map map = new HashMap();
        map.put("no1", "韩顺平");//k-v
        map.put("no2", "张无忌");//k-v
        map.put("no1", "张三丰");//当有相同的 k , 就等价于替换. map.put("no3", "张三丰");//k-v
        map.put(null, null); //k-v
        map.put(null, "abc"); //等价替换
        map.put("no4", null); //k-v
        map.put("no5", null); //k-v
        map.put(1, "赵敏");//k-v
        map.put(new Object(), "金毛狮王");//k-v
        // 通过 get 方法，传入 key ,会返回对应的 value
        System.out.println(map.get("no2"));//张无忌
        System.out.println("map=" + map);
    }
}
