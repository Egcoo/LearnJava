package Generic01;

import java.util.ArrayList;

/**
 * @ author Egcoo
 * @ date 2022/7/12 - 9:42
 */
@SuppressWarnings({"all"})
public class Generic01 {
     public static void main(String[] args) {
          //使用传统的方法来解决存在两个弊端
          //1.不能对加入集合中的数据元素进行约束
          //2.遍历的时候，需要进行类型转换，如果集合中数据量大，则会对效率有影响
          ArrayList arrayList = new ArrayList();
          arrayList.add(new Dog("旺财", 10));
          arrayList.add(new Dog("发财", 1));
          arrayList.add(new Dog("小黄", 5));
          //假如我们的程序员，不小心，添加了一只猫
          //arrayList.add(new Cat("招财猫", 8));
          //遍历
          for (Object o : arrayList) {
          //向下转型 Object ->Dog
               Dog dog = (Dog) o;
               System.out.println(dog.getName() + "-" + dog.getAge());
          }
     }
}
/*
请编写程序，在 ArrayList 中，添加 3 个 Dog 对象
Dog 对象含有 name 和 age, 并输出 name 和 age (要求使用 getXxx())
*/
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
}