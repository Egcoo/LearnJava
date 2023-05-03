package Homework04;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2022/7/14 - 11:28
 */
public class DAO <T> {
    public Map<String,T> map = new HashMap<>();

    public void save(String id,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        map.put(id,entity);
    }

    //遍历 map 中存放的所有的 T 对象
//    遍历map [k-v]，将 map 的所有的value(T ,entity),封装到 ArrayList 返回即可
    public List<T> list(){
        List<T> list = new ArrayList<>();

        Set<String> set = map.keySet();
        for (String key :set) {
            list.add(map.get(key)); //也可以直接使用本类的 get(String id)
        }

        return list;

    }

    public void delete(String id){
        map.remove(id);
    }
}
