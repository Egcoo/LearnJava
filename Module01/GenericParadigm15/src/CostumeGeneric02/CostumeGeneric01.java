package CostumeGeneric02;

import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2022/7/13 - 14:42
 */
@SuppressWarnings({"all"})
public class CostumeGeneric01 {
    public static void main(String[] args) {
        //T=Double, R=String, M=Integer
        Tiger<Double, String, Integer> g = new Tiger<>("john");
        g.setT(10.9); //OK
        //g.setT("yy"); //错误，类型不对
        System.out.println(g);
        Tiger g2 = new Tiger("john~~");//OK T=Object R=Object M=Object
        g2.setT("yy"); //OK ,因为 T=Object "yy"=String 是 Object 子类
        System.out.println("g2=" + g2);
    }
}

/*
1.tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
2.T,R,M 泛型的标识符，一般是单个大写字母
3.泛型标识符可以有多个
4，普通成员可以使用泛型（属性和方法）
5.使用泛型的数组，不可以初始化
6.静态方法中不能使用类的泛型
 */
class Tiger<T, R, M> {
    String name;
    R r;
    T t;
    M m;

    //因为数组在 new 不能确定 T 的类型，就无法在内存开空间
    T[] ts;

    //因为静态是和类相关的，在类加载时，对象还没有创建
    //所以，如果静态方法和静态属性使用了泛型，JVM 就无法完成初始化
    // static R r2;
    // public static void m1(M m) {}
    //

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(String name, R r, T t, M m) {
        this.name = name;
        this.r = r;
        this.t = t;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", t=" + t +
                ", m=" + m +
                ", ts=" + Arrays.toString(ts) +
                '}';
    }
}