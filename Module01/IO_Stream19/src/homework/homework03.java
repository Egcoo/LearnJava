package homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @ author Egcoo
 * @ date 2022/7/28 - 10:11
 */
public class homework03 {
    public static void main(String[] args) throws IOException {

        String filePath = "E:\\Java_Project\\Module01\\IO_Stream19\\src\\dog.properties";
        Properties properties = new Properties();

        //load 的作用就是加载指定的配置文件，就是你想操作哪一个文件
        properties.load(new FileReader(filePath));
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");

        Dog dog = new Dog(name, age, color);
        System.out.println("====输出对象信息=====");
        System.out.println(dog);

        //将创建的dog 对象，序列化到文件 dog.dat 文件中
        String serPath = "C:\\Users\\Egcoo\\Desktop\\Download\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serPath));
        oos.writeObject(dog);

        //关闭流
        oos.close();
        System.out.println("dog 对象序列化完成");

    }

    //再编写一个方法，实现反序列化
    @Test
    private void m1() throws IOException, ClassNotFoundException {
        String serPath = "C:\\Users\\Egcoo\\Desktop\\Download\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serPath));

        Dog dog = (Dog)ois.readObject();
        System.out.println("======输出反序列化后dog的信息====");
        System.out.println(dog);
        ois.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}