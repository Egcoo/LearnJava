package Collection01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/7/4 - 10:12
 */
public class CollectionExe01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(new Dog("小黑", 3));
        list.add(new Dog("小白", 6));
        list.add(new Dog("小灰", 5));

        for (Object dog : list) {
            System.out.println(dog);
        }

        System.out.println("===这是使用迭代器输出===");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object Dog = iterator.next();
            System.out.println("dog = " + Dog);
        }


    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}