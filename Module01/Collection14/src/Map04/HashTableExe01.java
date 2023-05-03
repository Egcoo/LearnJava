package Map04;

import java.util.Hashtable;

/**
 * @ author Egcoo
 * @ date 2022/7/9 - 15:42
 */
@SuppressWarnings({"all"})
public class HashTableExe01 {
    public static void main(String[] args) {

        Hashtable table = new Hashtable();
        table.put("john",100);
//        table.put(null,100);
//        table.put("john",null);
        table.put("lucy",100);
        table.put("lic",100);
        table.put("lic",88);
        table.put("hello1",88);
        table.put("hello2",88);
        table.put("hello3",88);
        table.put("hello4",88);
        table.put("hello5",88);
        table.put("hello6",88);
        table.put("hello7",88);
        System.out.println(table);


        /*
        1.底层是一个数组 Hashtable$Entry[] 初始化大小为11
        2.临界值还是 0.75
        3.扩容，按照自己的扩容机制
         */
    }
}
