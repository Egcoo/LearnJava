package InputStream02;

import ObjectOutputStream05.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @ author Egcoo
 * @ date 2022/7/26 - 12:18
 */
public class ObjectInputStream01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取
        //1.读取(反序列化) 的顺序需要和你保存的数据(序列化)的顺序保持一致
        //2.否则会出现异常

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        //System.out.println(ois.readObject()); //底层 Object -> Dog

        Object dog = ois.readObject();
        System.out.println("运行类型: " + dog.getClass());
        System.out.println("dog信息: " + dog);

        //1.如果我们想要调用 dog 方法,需要向下转型
        //2. 需要我们将 dog 类的定义，放到可以引用的位置
        Dog dog2 = (Dog)dog;
        System.out.println(dog2.getAge());

        //关闭外层流
        ois.close();


    }
}
