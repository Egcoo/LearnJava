package Generic01;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2022/7/12 - 10:50
 */
public class GenericExe01 {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<Student>();
        set.add(new Student("jack", 23));
        set.add(new Student("john", 21));
        set.add(new Student("smith", 24));

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student stu = (Student) iterator.next();
            System.out.println(stu.getName() + "--" + stu.getAge());

        }

        //使用泛型方式给 HashMap 放入 3 个学生对象
        //K -> String V->Student
        HashMap<String, Student> hm = new HashMap<String, Student>();
        /*
        public class HashMap<K,V> {}
        */
        hm.put("milan", new Student("milan", 38));
        hm.put("smith", new Student("smith", 48));

        hm.put("hsp", new Student("hsp", 28));
        //迭代器 EntrySet
        /*
        public Set<Map.Entry<K,V>> entrySet() {
                Set<Map.Entry<K,V>> es;
                return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
        }
        */
        Set<Map.Entry<String, Student>> entries = hm.entrySet();
        /*
        public final Iterator<Map.Entry<K,V>> iterator() {
            return new EntryIterator();
        }
        */

        //这里为什么会出现 Map.Entry<String, Student，因为在定义的时候就已经给指定了。
        Iterator<Map.Entry<String, Student>> iterator2 = entries.iterator();
        System.out.println("==============================");
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator2.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }

    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}