package Generic01;

import java.util.ArrayList;

/**
 * @ author Egcoo
 * @ date 2022/7/12 - 9:55
 */
public class GenericImprove02 {
    public static void main(String[] args) {

        //1. 当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是 Dog 类型 (细节后面说...)
        //2. 如果编译器发现添加的类型，不满足要求，就会报错
        //3. 在遍历的时候，可以直接取出 Dog 类型而不是 Object
        //4. public class ArrayList<E> {} E 称为泛型,那么 Dog->E

        ArrayList<Dog1> arrayList = new ArrayList<Dog1>();
        arrayList.add(new Dog1("旺财", 10));
        arrayList.add(new Dog1("发财", 1));
        arrayList.add(new Dog1("小黄", 5));
        //假如我们的程序员，不小心，添加了一只猫
        //arrayList.add(new Cat("招财猫", 8));
        //遍历
        for (Dog1 dog1 : arrayList) {
            //向下转型 Object ->Dog
            System.out.println(dog1.getName() + "-" + dog1.getAge());
        }

    }
}

/*
请编写程序，在 ArrayList 中，添加 3 个 Dog 对象
Dog 对象含有 name 和 age, 并输出 name 和 age (要求使用 getXxx())
*/
class Dog1 {
    private String name;
    private int age;

    public Dog1(String name, int age) {
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

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
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