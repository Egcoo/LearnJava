package Homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @ author Egcoo
 * @ date 2022/10/28 - 9:28
 */
public class homework02 {
    public static void main(String[] args) throws Exception {

        // 1.class 类的 forName 方法得到File 类的class 对象
        Class<?> fileClass = Class.forName("java.io.File");

        // 2.得到所有的构造器
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        // 遍历输出
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File构造器=" + declaredConstructor);
        }
        // 3.指定的得到 public java.io.File(java.lang.String)
        Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor(String.class);
        String fileAllPath = "C:\\Users\\Egcoo\\Desktop\\Download";
        Object file = declaredConstructor.newInstance(fileAllPath); // 创建 File 对象

        // 4.得到 createNewFile 的方法对象
        Method createNewFile = fileClass.getMethod("createNewFile");
        createNewFile.invoke(file);
        // file 的运行类型就是 File
        System.out.println(file.getClass());
        System.out.println("创建文件成功" + fileAllPath);
    }
}



